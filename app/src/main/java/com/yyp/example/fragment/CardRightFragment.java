package com.yyp.example.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yyp.example.R;
import com.yyp.example.bean.NewsBean;

/**
 * 卡片子页面
 */
public class CardRightFragment extends Fragment {

    private NewsBean newsBean;

    private CardView cardView;
    private ImageView image;
    private TextView title;
    private TextView content;
    private TextView column;
    private TextView readCount;


    public static CardRightFragment getInstance(NewsBean news) {
        CardRightFragment cardFragment = new CardRightFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("news", news);
        cardFragment.setArguments(bundle);
        return cardFragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_right, container, false);

        cardView = view.findViewById(R.id.card_view);
        image = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        content = view.findViewById(R.id.content);
        column = view.findViewById(R.id.column);
        readCount = view.findViewById(R.id.read_count);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击了" + title.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null) {
            newsBean = (NewsBean) getArguments().getSerializable("news");
        }

        if(newsBean != null){ //设置数据
            title.setText(newsBean.getTitle());
            content.setText(newsBean.getContent());
            column.setText(newsBean.getColumn());
            readCount.setText(String.format("%d人已读", newsBean.getReadCount()));
        }

    }
}
