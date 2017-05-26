package com.example.think.citypass.fragment.zzh.community.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.model.enitity.ThematicBean;

import java.util.List;

/**
 * Created by ASUS on 2017/5/18.
 */

public class ThematicAdapter extends RecyclerView.Adapter<ThematicAdapter.ViewHolder> {
    private List<ThematicBean.ServerInfoBean> data;

    public ThematicAdapter(List<ThematicBean.ServerInfoBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(View.inflate(App.activity, R.layout.thematic_activities_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (data.get(position).getClassType() == 0) {
            holder.countTv.setText("已有" + data.get(position).getHit() + "人感兴趣");
            holder.countIv.setImageResource(R.drawable.ccoo_icon_look2);
            holder.labelIv.setImageResource(R.drawable.bbs_zhuanti_left);
        } else if (data.get(position).getClassType() == 1) {
            holder.countTv.setText("活动时间：" + data.get(position).getStartTime() + "至" + data.get(position).getEndTime());
            holder.countIv.setImageResource(R.drawable.icon_little_time);
            holder.labelIv.setImageResource(R.drawable.bbs_huodong_left);
        }

        holder.titleTv.setText(data.get(position).getTitle());
        Glide.with(App.activity)
                .load(data.get(position).getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.shape_image_zhanwei)
                .into(holder.titleIv);
        holder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(App.activity, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView countTv, titleTv;

        private ImageView titleIv, labelIv, countIv, stateIv;

        private RelativeLayout rl;

        public ViewHolder(View itemView) {
            super(itemView);
            rl = (RelativeLayout) itemView.findViewById(R.id.activity_rl);
            titleTv = (TextView) itemView.findViewById(R.id.activity_title_text);
            countTv = (TextView) itemView.findViewById(R.id.activity_count);
            titleIv = (ImageView) itemView.findViewById(R.id.activity_title_image);
            labelIv = (ImageView) itemView.findViewById(R.id.activity_title_label);
            countIv = (ImageView) itemView.findViewById(R.id.activity_count_image);
            stateIv = (ImageView) itemView.findViewById(R.id.activity_state);
        }
    }
}
