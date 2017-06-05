package com.example.think.citypass.fragment.cityadapter;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.CommonAdapter;
import com.example.think.citypass.common.base.ViewHolder;
import com.example.think.citypass.model.entity.XinShangBean;

import java.util.List;

/**
 * Created by think on 2017/6/5.
 */

public class XinShanglistAdapter extends CommonAdapter<XinShangBean.ServerInfoBean.CoverXinShangInfoListBeanX.CoverXinShangInfoListBean> {
    private Context context;
    public XinShanglistAdapter(Context context, List<XinShangBean.ServerInfoBean.CoverXinShangInfoListBeanX.CoverXinShangInfoListBean> datas) {
        super(context, datas, R.layout.xinshanglistview);
        this.context = context;
    }

    @Override
    public void display(ViewHolder holder, XinShangBean.ServerInfoBean.CoverXinShangInfoListBeanX.CoverXinShangInfoListBean serverInfoBean) {

            String age = serverInfoBean.getAge();
            String positionName = serverInfoBean.getPositionName();
            String nick3 = serverInfoBean.getNick();
            String likeTotal3 = serverInfoBean.getLikeTotal();
            String userfaces = serverInfoBean.getUserface();
            int number = serverInfoBean.getNumber();
            String sex = serverInfoBean.getSex();


            holder.setText(R.id.level_text,number+"");
            holder.setImage(R.id.head_image,userfaces);
            holder.setText(R.id.name_text,nick3);
            holder.setText(R.id.position_text,positionName);
            holder.setText(R.id.gift_count_text,likeTotal3);
            holder.setText(R.id.age_text,age);
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.drawable.ccoo_icon_boy_white);
            ImageView imageView1 = new ImageView(context);
            imageView1.setImageResource(R.drawable.my_main_women);
            LinearLayout linearLayout = new LinearLayout(context);
            if(sex.equals("男")){
                holder.setImage(R.id.sex_image,imageView.toString());
                linearLayout.setBackgroundColor(Color.parseColor("#12c8f5"));
            }else {
                holder.setImage(R.id.sex_image,imageView1.toString());
                linearLayout.setBackgroundColor(Color.parseColor("#f42597"));
            }


        }

    }

