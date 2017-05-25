package com.example.think.citypass.fragment.zzh.community.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.think.citypass.App;
import com.example.think.citypass.R;

import java.util.List;

public class WorthAdapter extends RecyclerView.Adapter<WorthAdapter.ViewHolder> {
    private List<String> data;

    public WorthAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(View.inflate(App.activity, R.layout.newest_item, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText("大黄蜂");
        holder.rl.setVisibility(View.GONE);

        SpannableString spanStr = getSpannableString(
                holder.worthTv, "及第三基地阿斯接地啊手机的骄傲司机考试课东山口第四大祭司",
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
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv, worthTv, titleTv;

        private RelativeLayout rl;


        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.name_tv);
            worthTv = (TextView) itemView.findViewById(R.id.newest_worth);
            titleTv = (TextView) itemView.findViewById(R.id.newest_title_tv);
            rl = (RelativeLayout) itemView.findViewById(R.id.newest_image_relative);
        }
    }
}
