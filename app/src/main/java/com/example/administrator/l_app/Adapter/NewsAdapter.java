package com.example.administrator.l_app.Adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.l_app.R;
import com.example.administrator.l_app.bean.News;

import java.util.List;

/**
 * Created by Administrator on 2018/5/18.
 */

public class NewsAdapter extends BaseQuickAdapter<News,BaseViewHolder>{
    public NewsAdapter(@LayoutRes int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        Glide.with(mContext).load(item.getImageUrl()).into((ImageView) helper.getView(R.id.news_thumb));
        helper.setText(R.id.news_title,item.getTitle());
        helper.setText(R.id.news_content,item.getContent());
    }
}
