package com.example.think.citypass.fragment.zzh.community.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.Utils;
import com.example.think.citypass.activity.zzh.PostDetailActivity;
import com.example.think.citypass.model.enitity.NewestBean;
import com.example.think.citypass.myview.RoundImageView;

import java.util.List;

public class NewestAdapter extends RecyclerView.Adapter<NewestAdapter.ViewHolder> {
    private List<NewestBean.ServerInfoBean> data;

    public NewestAdapter(List<NewestBean.ServerInfoBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(View.inflate(App.activity, R.layout.newest_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.titleTv.setText(data.get(position).getTitle());
        holder.contentTv.setText(data.get(position).getTbody());
        if (data.get(position).getImagesNum() == 0) {
            holder.imageRL.setVisibility(View.GONE);
        } else {
            holder.imageRL.setVisibility(View.VISIBLE);
            holder.imageLL.setVisibility(View.VISIBLE);
            String[] images = data.get(position).getImages().split("\\|");

            for (int i = 0; i < 3; i++) {
                ImageView imageView = (ImageView) holder.imageLL.getChildAt(i);
                if (i <= images.length - 1) {
                    imageView.setVisibility(View.VISIBLE);
                    Glide.with(App.activity)
                            .load(images[i])
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .placeholder(R.drawable.shape_image_zhanwei)
                            .into(imageView);
                } else {
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
            if (data.get(position).getImagesNum() <= 3) {
                holder.imageNumTv.setVisibility(View.GONE);
            } else {
                holder.imageNumTv.setVisibility(View.VISIBLE);
                holder.imageNumTv.setText("共" + data.get(position).getImagesNum() + "张");
            }
        }
        holder.laiziTv.setText(data.get(position).getBName());

        Glide.with(App.activity)
                .load(data.get(position).getUserface())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.headIv);

        holder.nameTv.setText(data.get(position).getRole());
        holder.timeTv.setText(Utils.getTime(data.get(position).getReplyTime()));
        holder.zanTv.setText(String.valueOf(data.get(position).getSUP()));
        holder.replyTv.setText(String.valueOf(data.get(position).getReply()));

        holder.infoLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.activity, PostDetailActivity.class);
                intent.putExtra("TopicID", data.get(position).getTopicID());
                intent.putExtra("BoardID", data.get(position).getBoardID());
                intent.putExtra("BName", data.get(position).getBName());
                intent.putExtra("Title", data.get(position).getTitle());
                intent.putExtra("MapName", data.get(position).getMapName());
                App.activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv, titleTv, contentTv, imageNumTv, laiziTv, timeTv, zanTv, replyTv;

        private RoundImageView headIv;

        private RelativeLayout imageRL;

        private LinearLayout imageLL, infoLL;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTv = (TextView) itemView.findViewById(R.id.name_tv);
            titleTv = (TextView) itemView.findViewById(R.id.newest_title_tv);
            contentTv = (TextView) itemView.findViewById(R.id.newest_content_tv);
            imageNumTv = (TextView) itemView.findViewById(R.id.newest_image_num_tv);
            laiziTv = (TextView) itemView.findViewById(R.id.laizi_tv);
            timeTv = (TextView) itemView.findViewById(R.id.time_tv);
            zanTv = (TextView) itemView.findViewById(R.id.zan_tv);
            replyTv = (TextView) itemView.findViewById(R.id.reply_tv);
            imageRL = (RelativeLayout) itemView.findViewById(R.id.newest_image_relative);
            imageLL = (LinearLayout) itemView.findViewById(R.id.newest_image_layout);
            infoLL = (LinearLayout) itemView.findViewById(R.id.newest_info);
            headIv = (RoundImageView) itemView.findViewById(R.id.head_iv);
        }
    }
}
