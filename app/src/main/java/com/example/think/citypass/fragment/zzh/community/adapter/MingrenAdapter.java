package com.example.think.citypass.fragment.zzh.community.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.model.enitity.PengchangBean;
import com.example.think.citypass.myview.RoundImageView;

import java.util.List;

public class MingrenAdapter extends RecyclerView.Adapter<MingrenAdapter.ViewHolder> {
    private List<PengchangBean.ServerInfoBean.InfoBean> data;

    public MingrenAdapter(List<PengchangBean.ServerInfoBean.InfoBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(View.inflate(App.activity, R.layout.naonaodi_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvCount.setText(String.valueOf(position+4));
        holder.tvUserName.setText(data.get(position).getNick());
        holder.tvLocation.setText(data.get(position).getLifeAddr());
        holder.tvLevel.setText("Lv."+data.get(position).getLevel());
        holder.tvType.setText("回帖数");
        holder.tvRepliesCount.setText(String.valueOf(data.get(position).getSum()));
        Glide.with(App.activity)
                .load(data.get(position).getUserFace())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.shape_image_zhanwei)
                .centerCrop()
                .crossFade(500)
                .into(holder.userImage);
        holder.rlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(App.activity, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 :data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCount,tvUserName,tvLocation,tvLevel,tvType,tvRepliesCount;

        private RoundImageView userImage;

        private RelativeLayout rlItem;

        public ViewHolder(View itemView) {
            super(itemView);
            rlItem = (RelativeLayout) itemView.findViewById(R.id.naonaodiItem);
            tvCount = (TextView) itemView.findViewById(R.id.naonaodiCount);
            tvUserName = (TextView) itemView.findViewById(R.id.userNameText);
            tvLocation = (TextView) itemView.findViewById(R.id.location_text);
            tvLevel = (TextView) itemView.findViewById(R.id.naonao_level);
            tvType = (TextView) itemView.findViewById(R.id.naonao_type);
            tvRepliesCount = (TextView) itemView.findViewById(R.id.repliesCount);
            userImage = (RoundImageView) itemView.findViewById(R.id.userImage);
        }
    }
}
