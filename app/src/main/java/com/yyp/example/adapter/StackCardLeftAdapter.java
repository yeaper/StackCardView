package com.yyp.example.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.yyp.example.bean.NewsBean;
import com.yyp.example.fragment.CardLeftFragment;
import com.yyp.stackcardview.adapter.StackCardAdapter;

/**
 * 左层叠卡片适配器
 *
 * Created by yyp on 2019/2/18
 */
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
