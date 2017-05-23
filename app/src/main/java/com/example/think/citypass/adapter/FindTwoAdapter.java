package com.example.think.citypass.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.CommonAdapter;
import com.example.think.citypass.common.base.ViewHolder;
import com.example.think.citypass.model.entity.FindBean;

import java.util.List;

/**
 * Created by think on 2017/5/19.
 */

public class FindTwoAdapter extends CommonAdapter<FindBean.ServerInfoBean.ChannelListBean> {

    public FindTwoAdapter(Context context, List<FindBean.ServerInfoBean.ChannelListBean> datas) {
        super(context, datas, R.layout.find_fragment_hot);
    }
    @Override
    public void display(ViewHolder holder, FindBean.ServerInfoBean.ChannelListBean channelListBean) {
        holder.setText(R.id.title_textview,channelListBean.getChannelName())
                .setText(R.id.content_textview,channelListBean.getChannelMemo())
                .setImage(R.id.bg_imagview,channelListBean.getChannelImg());
    }
}
