package com.yyp.stackcardview.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Collections;
import java.util.List;

/**
 * 层叠卡片适配器基类
 *
 * Created by yyp on 2019/2/21
 */
public abstract class StackCardAdapter<T> extends FragmentPagerAdapter {

    private List<T> list;

    public StackCardAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * 设置数据集合 处理排序
     *
     * @param list 数据集合
     * @param reverse 是否倒序排序
     */
    public void setList(List<T> list, boolean reverse) {
        if(reverse){
            Collections.reverse(list); //倒序排序
        }
        this.list = list;
        notifyDataSetChanged();
    }

    /**
     * 获取数据集合
     *
     * @return .
     */
    public List<T> getList() {
        return list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

}
