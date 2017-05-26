package com.example.think.citypass.fragment.zzh.community.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.model.enitity.WorthBean;
import com.example.think.citypass.myview.RoundImageView;

import java.util.List;

public class WorthAdapter extends RecyclerView.Adapter<WorthAdapter.ViewHolder> {
    private List<WorthBean.ServerInfoBean> data;

    public WorthAdapter(List<WorthBean.ServerInfoBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(View.inflate(App.activity, R.layout.newest_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(data.get(position).getImagesNum() == 0)
            holder.rl.setVisibility(View.GONE);
        holder.nameTv.setText(data.get(position).getRole());
        holder.contentTv.setText(data.get(position).getTbody());
        holder.laoziTv.setText(data.get(position).getBName());
        if(data.get(position).getReplyTime().contains("2017")){
            holder.timeTv.setText(data.get(position).getReplyTime().substring(5));
        }else{
            holder.timeTv.setText(data.get(position).getReplyTime());
        }
        holder.zanTv.setText(String.valueOf(data.get(position).getSUP()));
        holder.replyTv.setText(String.valueOf(data.get(position).getReply()));
        Glide.with(App.activity)
                .load(data.get(position).getUserface())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.shape_image_zhanwei)
                .centerCrop()
                .into(holder.headIv);
        SpannableString spanStr = getSpannableString(
                holder.worthTv, data.get(position).getTitle(),
                holder.titleTv);
        holder.titleTv.setText(spanStr);
    }

    private SpannableString getSpannableString(TextView worthTv, String content, TextView titleTv) {
        String res = "";
        worthTv.setVisibility(View.VISIBLE);
        worthTv.setText("值得一看");
        res = getLengthStr(worthTv, titleTv);
        SpannableString spanStr = new SpannableString(res + content);
        return spanStr;
    }

    private String getLengthStr(TextView tv1, TextView tv2) {
        float width = tv1.getPaint().measureText(tv1.getText().toString())
                + tv1.getCompoundPaddingLeft()
                + tv1.getCompoundPaddingRight();
        String res = "";
        while (tv2.getPaint().measureText(res) < width + 6) {
            res += " ";
        }
        //res += "  ";
        //LogUtils.showErrorLog(ImageSpanTools.class, "width=" + width + "   res=" + tv2.getPaint().measureText(res));

        return res;
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTv, worthTv, titleTv,contentTv,laoziTv,timeTv,zanTv,replyTv;

        private RoundImageView headIv;

        private RelativeLayout rl;


        public ViewHolder(View itemView) {
            super(itemView);

            worthTv = (TextView) itemView.findViewById(R.id.newest_worth);
            titleTv = (TextView) itemView.findViewById(R.id.newest_title_tv);
            contentTv = (TextView) itemView.findViewById(R.id.newest_content_tv);
            laoziTv = (TextView) itemView.findViewById(R.id.laizi_tv);
            headIv = (RoundImageView) itemView.findViewById(R.id.head_iv);
            nameTv = (TextView) itemView.findViewById(R.id.name_tv);
            timeTv = (TextView) itemView.findViewById(R.id.time_tv);
            zanTv = (TextView) itemView.findViewById(R.id.zan_tv);
            replyTv= (TextView) itemView.findViewById(R.id.reply_tv);
            rl = (RelativeLayout) itemView.findViewById(R.id.newest_image_relative);
        }
    }
}
