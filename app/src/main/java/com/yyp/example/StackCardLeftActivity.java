package com.yyp.example;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yyp.example.adapter.StackCardLeftAdapter;
import com.yyp.example.bean.NewsBean;
import com.yyp.example.utils.DensityUtils;
import com.yyp.stackcardview.config.PageTransformerConfig;
import com.yyp.stackcardview.transformer.StackCardPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * 左层叠展示界面
 *
 * Created by yyp on 2019/2/20
 */
public class StackCardLeftActivity extends AppCompatActivity {

    private ViewPager stackCardViewPager;
    private StackCardLeftAdapter stackCardLeftAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_card_left);

        stackCardViewPager = findViewById(R.id.stack_card_vp);

        configLeftStackCardViewPager();
        loadData();
    }

    /**
     * 配置左层叠 StackCardViewPager
     */
    private void configLeftStackCardViewPager() {
        stackCardViewPager.setPageTransformer(true, StackCardPageTransformer.getBuild()
                .setViewType(PageTransformerConfig.LEFT) //层叠方向
                .setTranslationOffset(DensityUtils.dp2px(this, 50f)) //左右位置偏移量
                .setScaleOffset(DensityUtils.dp2px(this, 50f)) //缩放偏移量
                .setAlphaOffset(0.5f) //卡片透明度偏移量
                .setMaxShowPage(3) //最大显示的页数
                .create(stackCardViewPager));

        //创建适配器
        stackCardLeftAdapter = new StackCardLeftAdapter(getSupportFragmentManager());
        stackCardViewPager.setAdapter(stackCardLeftAdapter);
    }

    /**
     * 加载左层叠卡片数据
     */
    private void loadData(){
        List<NewsBean> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            list.add(new NewsBean("", "你好！外星人" + i, getResources().getString(R.string.content),
                    "在浙里", 100 + i * 10));
        }

        stackCardLeftAdapter.setList(list, true);
        stackCardViewPager.setCurrentItem(list.size()-1, false); //刚开始显示最后一个，也就是第一条数据
    }
}
