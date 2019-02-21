# 层叠片卡效果

<img src="http://bmob-cdn-20165.b0.upaiyun.com/2019/02/21/563aa2874095d4e280cd910b18ed349a.png"  height="400" width="240">

<img src="http://bmob-cdn-20165.b0.upaiyun.com/2019/02/21/5f1c0cfc40ac69b48058b22d515cf0c6.png"  height="400" width="240">

## 说明

通过设置 ViewPager 的 PageTransformer 实现卡片层叠效果，支持左层叠和右层叠两种效果

## 添加依赖

1、 主工程 build.gradle 添加仓库地址:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

2、 app项目工程 build.gradle 添加依赖:


```gradle
dependencies {
    implementation 'com.github.yeaper:StackCardView:1.0.0'
}
```

## 用法

以左层叠效果为例

1、 控件使用 ViewPager

2、 卡片使用 Fragment，布局示例如下：

主要是 CardView 的属性 android:layout_gravity 设置为 right，居右；右层叠反之

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".fragment.CardRightFragment">

    <android.support.v7.widget.CardView
        android:id="@+id/card_view"
        android:layout_width="300dp"
        android:layout_height="match_parent"
        android:layout_gravity="right">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <ImageView
                android:id="@+id/image"
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:src="@drawable/news_img1"
                android:scaleType="centerCrop"/>

            <TextView
                android:id="@+id/title"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textSize="21sp"
                android:padding="5dp"/>

            <TextView
                android:id="@+id/content"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="15sp"
                android:lineSpacingMultiplier="1.2"
                android:padding="5dp"/>

            <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:padding="5dp"
                android:layout_marginTop="20dp"
                android:layout_marginBottom="10dp">
                <TextView
                    android:id="@+id/column"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textSize="15sp"
                    android:textColor="@color/red"/>

                <TextView
                    android:id="@+id/read_count"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textSize="15sp"
                    android:layout_marginLeft="10dp"/>
            </LinearLayout>

        </LinearLayout>


    </android.support.v7.widget.CardView>
</LinearLayout>
```

3、 自定义 ViewPager 的适配器，继承 StackCardAdapter，示例如下：

只需要处理 getItem() 的逻辑


```java
public class StackCardLeftAdapter extends StackCardAdapter<NewsBean> {

    public StackCardLeftAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(getList() == null){
            return CardLeftFragment.getInstance(null);
        }else{
            return CardLeftFragment.getInstance(getList().get(i));
        }
    }
}
```

4、 为 ViewPager 设置 PageTransFormer，这里使用StackCardPageTransformer，示例如下：


```java
stackCardViewPager.setPageTransformer(true, StackCardPageTransformer.getBuild()
                .setViewType(PageTransformerConfig.LEFT) //层叠方向
                .setTranslationOffset(DensityUtils.dp2px(this, 50f)) //左右位置偏移量
                .setScaleOffset(DensityUtils.dp2px(this, 50f)) //缩放偏移量
                .setAlphaOffset(0.5f) //卡片透明度偏移量
                .setMaxShowPage(3) //最大显示的页数
                .create(stackCardViewPager));
```

参数说明：

| 参数 | 类型 | 描述 |
|:---|:---|:---|
| viewType | int | 卡片层叠方向：左、右 |
| translationOffset | float | 卡片向左/右的偏移量，单位用px |
| scaleOffset | float | 卡片的缩放偏移量，单位用px |
| alphaOffset | float | 底下的卡片相对于上一层卡片的透明度 |
| maxShowPage | int | 最多显示的卡片个数 |

5、 加载数据

左层叠效果：需要将数据倒序排列，并将 ViewPager 定位到最后一张卡片

```java
stackCardLeftAdapter.setList(list, true); //数据倒序排列
stackCardViewPager.setCurrentItem(list.size()-1, false); //定位到最后一张卡片
```

右层叠效果：数据顺序排列

```java
stackCardLeftAdapter.setList(list, false); //数据顺序排列
```
