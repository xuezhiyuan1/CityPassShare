package com.example.think.citypass.fragment.xzy;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.xzy.FindActivity;
import com.example.think.citypass.activity.xzy.FindCityThings;
import com.example.think.citypass.activity.xzy.Sao1SaoActivity;
import com.example.think.citypass.activity.zxm.FindhouseActivity;
import com.example.think.citypass.activity.zxm.FindworkActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.FragmentBuilder;
import com.example.think.citypass.common.config.Urls;
import com.example.think.citypass.fragment.zzh.community.BanquFragment;
import com.example.think.citypass.model.entity.FindBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;
import java.util.HashMap;
import java.util.Map;
//提交526

/**
 * Created by think on 2017/5/19.
 */

public class LoadFragmentTwo extends BaseFragment implements View.OnClickListener{
    //美女秀
    LinearLayout linearLayout1;
    //型男秀
    LinearLayout linearLayout2;
    //萌宝秀
    LinearLayout linearLayout3;
    //交流场
    //社区
    LinearLayout layout1;
    //圈子
    LinearLayout layout2;
    //问事
    LinearLayout layout3;
    //热门事   One
    private ImageView imageView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    //城事    活动
    LinearLayout  bglsyout,bglayout2;
    //热门事   Two
    private ImageView imageView2;
    private TextView textView4;
    private TextView textView5;
    //精彩人
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    //交流场
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    //聪明购
    private ImageView imageView9;
    private ImageView imageView10;
    private ImageView imageView11;
    private ImageView imageView12;
    private ImageView imageView13;
    private ImageView imageView14;
    //百事通
    private ImageView imageView15;
    private ImageView imageView16;
    private ImageView imageView17;
    private ImageView imageView18;
    private ImageView imageView19;
    private ImageView imageView20;
    private ImageView imageView21;
    private ImageView imageView22;

    private ImageView imageView23;
    private ImageView imageView24;
    private ImageView imageView25;
    private ImageView imageView26;
    private ImageView imageView27;
    private ImageView imageView28;
    private ImageView imageView29;
    private ImageView imageView30;
    //二维码
    private ImageView erweima;
    //无网络加载试图
    LinearLayout linearLayout;
    @Override
    protected int layoutId() {
        return R.layout.find_fragement;
    }

    @Override
    protected void initView(View view) {

        linearLayout1 = (LinearLayout) view.findViewById(R.id.layout1);
        linearLayout2 = (LinearLayout) view.findViewById(R.id.layout2);
        linearLayout3 = (LinearLayout) view.findViewById(R.id.layout3);

        layout1 = (LinearLayout) view.findViewById(R.id.home_layout1);
        layout2 = (LinearLayout) view.findViewById(R.id.home_layout2);
        layout3 = (LinearLayout) view.findViewById(R.id.home_layout3);

        //热门事   One
        imageView = (ImageView) view.findViewById(R.id.bg_imagview);
        textView1 = (TextView) view.findViewById(R.id.title_textview);
        textView2 = (TextView) view.findViewById(R.id.title_textview_hot);
        textView3 = (TextView) view.findViewById(R.id.content_textview);
        bglsyout= (LinearLayout) view.findViewById(R.id.bg_layout);
        bglayout2= (LinearLayout) view.findViewById(R.id.bg_layout2);

        //热门事   Two
        imageView2 = (ImageView) view.findViewById(R.id.bg_imagview2);
        textView4 = (TextView) view.findViewById(R.id.title_textview2);
        textView5 = (TextView) view.findViewById(R.id.content_textview2);
        //精彩人
        textView6 = (TextView) view.findViewById(R.id.title);
        textView7 = (TextView) view.findViewById(R.id.title1);
        textView8 = (TextView) view.findViewById(R.id.content1);
        imageView3 = (ImageView) view.findViewById(R.id.image1);
        imageView4 = (ImageView) view.findViewById(R.id.image2);
        imageView5 = (ImageView) view.findViewById(R.id.image3);
        //交流场
        imageView6 = (ImageView) view.findViewById(R.id.imageview_shequ);
        imageView7 = (ImageView) view.findViewById(R.id.imageview_quanzi);
        imageView8 = (ImageView) view.findViewById(R.id.imageview_wenshi);
        //聪明购
        imageView9 = (ImageView) view.findViewById(R.id.imageview1);
        imageView10 = (ImageView) view.findViewById(R.id.imageview2);
        imageView11 = (ImageView) view.findViewById(R.id.imageview3);
        imageView12 = (ImageView) view.findViewById(R.id.imageview4);
        imageView13 = (ImageView) view.findViewById(R.id.imageview5);
        imageView14 = (ImageView) view.findViewById(R.id.imageview6);
        //百事通
        imageView15 = (ImageView) view.findViewById(R.id.imageView_baishitong1);
        imageView16 = (ImageView) view.findViewById(R.id.imageView_baishitong2);
        imageView16.setOnClickListener(this);
        imageView17 = (ImageView) view.findViewById(R.id.imageView_baishitong3);
        imageView17.setOnClickListener(this);
        imageView18 = (ImageView) view.findViewById(R.id.imageView_baishitong4);
        imageView19 = (ImageView) view.findViewById(R.id.imageView_baishitong5);
        imageView20 = (ImageView) view.findViewById(R.id.imageView_baishitong6);
        imageView21 = (ImageView) view.findViewById(R.id.imageView_baishitong7);
        imageView22 = (ImageView) view.findViewById(R.id.imageView_baishitong8);

        imageView23 = (ImageView) view.findViewById(R.id.imageView_title1);
        imageView24 = (ImageView) view.findViewById(R.id.imageView_title2);
        imageView25 = (ImageView) view.findViewById(R.id.imageView_title3);
        imageView26 = (ImageView) view.findViewById(R.id.imageView_title4);
        imageView27 = (ImageView) view.findViewById(R.id.imageView_title5);
        imageView28 = (ImageView) view.findViewById(R.id.imageView_title6);
        imageView29 = (ImageView) view.findViewById(R.id.imageView_title7);
        imageView30 = (ImageView) view.findViewById(R.id.imageView_title8);
        //二维码
        erweima = (ImageView) view.findViewById(R.id.right_image_erweima_find);
        //无网络加载试图
        linearLayout = (LinearLayout) view.findViewById(R.id.ll_loading);
    }
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what == 200){
                linearLayout.setVisibility(View.GONE);
                Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    });
    @Override
    protected void initData() {
        //无网络加载试图
        handler.sendEmptyMessageDelayed(200,2000);
        //添加数据
        Map<String, String> map = new HashMap<>();
        map.put("param", "{\"customerID\":8001,\"requestTime\":\"2017-05-16 15:25:59\",\"Method\":\"PHSocket_GetAppSetInfo\",\"customerKey\":\"CEE365A69C5ADE99398408693ABAEE95\",\"appName\":\"CityGeneral\",\"version\":\"1.0\",\"Param\":{\"siteID\":2488,\"type\":3},\"Statis\":{\"SiteId\":0,\"UserId\":0,\"PhoneNo\":\"Le X620\",\"SystemNo\":2,\"System_VersionNo\":\"Android 6.0\",\"PhoneId\":\"\",\"PhoneNum\":\"0\"}}");
        RetrofitUtil.getInstance().postRetrofit(Urls.FINDPAGE, map, new ResaultCallBack() {
            @Override
            public void onSuccess(Object pbj) {
                FindBean findBean = (FindBean) pbj;
                Log.d("FindBean",findBean.toString());
                //热门事   One
                String channelName = findBean.getServerInfo().get(0).getChannelList().get(0).getChannelName();
                textView2.setText(channelName);
                String channelImg = findBean.getServerInfo().get(0).getChannelList().get(0).getChannelImg();
                Glide.with(getContext()).load(channelImg).into(imageView);
                String plateName = findBean.getServerInfo().get(0).getPlateName();
                textView1.setText(plateName);
                String channelMemo = findBean.getServerInfo().get(0).getChannelList().get(0).getChannelMemo();
                textView3.setText(channelMemo);
                //热门事   Two
                String channelImg1 = findBean.getServerInfo().get(0).getChannelList().get(1).getChannelImg();
                Glide.with(getContext()).load(channelImg1).into(imageView2);
                String channelName1 = findBean.getServerInfo().get(0).getChannelList().get(1).getChannelName();
                textView4.setText(channelName1);
                String channelMemo1 = findBean.getServerInfo().get(0).getChannelList().get(1).getChannelMemo();
                textView5.setText(channelMemo1);
                //精彩人
                String plateName1 = findBean.getServerInfo().get(1).getPlateName();
                textView6.setText(plateName1);
                String channelName2 = findBean.getServerInfo().get(1).getChannelList().get(0).getChannelName();
                textView7.setText(channelName2);
                String channelMemo2 = findBean.getServerInfo().get(1).getChannelList().get(0).getChannelMemo();
                textView8.setText(channelMemo2);
                String channelImg2 = findBean.getServerInfo().get(1).getChannelList().get(0).getChannelImg();
                Glide.with(getContext()).load(channelImg2).into(imageView3);
                String channelImg3 = findBean.getServerInfo().get(1).getChannelList().get(1).getChannelImg();
                Glide.with(getContext()).load(channelImg3).into(imageView4);
                String channelImg4 = findBean.getServerInfo().get(1).getChannelList().get(2).getChannelImg();
                Glide.with(getContext()).load(channelImg4).into(imageView5);
                //交流场
                String channelImg5 = findBean.getServerInfo().get(2).getChannelList().get(0).getChannelImg();
                Glide.with(getContext()).load(channelImg5).into(imageView6);
                String channelImg6 = findBean.getServerInfo().get(2).getChannelList().get(1).getChannelImg();
                Glide.with(getContext()).load(channelImg6).into(imageView7);
                String channelImg7 = findBean.getServerInfo().get(2).getChannelList().get(2).getChannelImg();
                Glide.with(getContext()).load(channelImg7).into(imageView8);
                //聪明购
                String channelImg8 = findBean.getServerInfo().get(3).getChannelList().get(0).getChannelImg();
                Glide.with(getContext()).load(channelImg8).into(imageView9);
                String channelImg9 = findBean.getServerInfo().get(3).getChannelList().get(1).getChannelImg();
                Glide.with(getContext()).load(channelImg9).into(imageView10);
                String channelImg10 = findBean.getServerInfo().get(3).getChannelList().get(2).getChannelImg();
                Glide.with(getContext()).load(channelImg10).into(imageView11);
                String channelImg11 = findBean.getServerInfo().get(3).getChannelList().get(3).getChannelImg();
                Glide.with(getContext()).load(channelImg11).into(imageView12);
                String channelImg12 = findBean.getServerInfo().get(3).getChannelList().get(4).getChannelImg();
                Glide.with(getContext()).load(channelImg12).into(imageView13);
                String channelImg13 = findBean.getServerInfo().get(3).getChannelList().get(5).getChannelImg();
                Glide.with(getContext()).load(channelImg13).into(imageView14);
                //百事通
                String channelImg14 = findBean.getServerInfo().get(4).getChannelList().get(0).getChannelImg();
                Glide.with(getContext()).load(channelImg14).into(imageView15);
                String channelImg15 = findBean.getServerInfo().get(4).getChannelList().get(1).getChannelImg();
                Glide.with(getContext()).load(channelImg15).into(imageView16);
                String channelImg16 = findBean.getServerInfo().get(4).getChannelList().get(2).getChannelImg();
                Glide.with(getContext()).load(channelImg16).into(imageView17);
                String channelImg17 = findBean.getServerInfo().get(4).getChannelList().get(3).getChannelImg();
                Glide.with(getContext()).load(channelImg17).into(imageView18);
                String channelImg18 = findBean.getServerInfo().get(4).getChannelList().get(4).getChannelImg();
                Glide.with(getContext()).load(channelImg18).into(imageView19);
                String channelImg19 = findBean.getServerInfo().get(4).getChannelList().get(5).getChannelImg();
                Glide.with(getContext()).load(channelImg19).into(imageView20);
                String channelImg20 = findBean.getServerInfo().get(4).getChannelList().get(6).getChannelImg();
                Glide.with(getContext()).load(channelImg20).into(imageView21);
                String channelImg21 = findBean.getServerInfo().get(4).getChannelList().get(7).getChannelImg();
                Glide.with(getContext()).load(channelImg21).into(imageView22);


                String channelImg22 = findBean.getServerInfo().get(5).getChannelList().get(0).getChannelImg();
                Glide.with(getContext()).load(channelImg22).into(imageView23);
                String channelImg24 = findBean.getServerInfo().get(5).getChannelList().get(1).getChannelImg();
                Glide.with(getContext()).load(channelImg24).into(imageView24);
                String channelImg25 = findBean.getServerInfo().get(5).getChannelList().get(2).getChannelImg();
                Glide.with(getContext()).load(channelImg25).into(imageView25);
                String channelImg26 = findBean.getServerInfo().get(5).getChannelList().get(3).getChannelImg();
                Glide.with(getContext()).load(channelImg26).into(imageView26);
                String channelImg27 = findBean.getServerInfo().get(5).getChannelList().get(4).getChannelImg();
                Glide.with(getContext()).load(channelImg27).into(imageView27);
                String channelImg28 = findBean.getServerInfo().get(5).getChannelList().get(5).getChannelImg();
                Glide.with(getContext()).load(channelImg28).into(imageView28);
                String channelImg29 = findBean.getServerInfo().get(5).getChannelList().get(6).getChannelImg();
                Glide.with(getContext()).load(channelImg29).into(imageView29);
                String channelImg30 = findBean.getServerInfo().get(5).getChannelList().get(7).getChannelImg();
                Glide.with(getContext()).load(channelImg30).into(imageView30);

            }

            @Override
            public void onError(String errorMsg) {

            }

            @Override
            public void notNet(String netData) {

            }

            @Override
            public void onErrorParams(String errorParams) {

            }
        }, FindBean.class);
    }

    @Override
    protected void initListener() {
        //二维码
        erweima.setOnClickListener(this);
        //城市  生活
        bglsyout.setOnClickListener(this);
        bglayout2.setOnClickListener(this);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);

        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);

    }

    @Override
    protected void loadData() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bg_layout:
                Toast.makeText(getContext(), "城事", Toast.LENGTH_SHORT).show();
                Intent  intent=new Intent(getContext(), FindCityThings.class);
                startActivity(intent);
                break;
            case R.id.bg_layout2:
                Toast.makeText(getContext(), "活动", Toast.LENGTH_SHORT).show();
                Intent  intent2=new Intent(getContext(), FindActivity.class);
                startActivity(intent2);
                break;
            case R.id.imageView_baishitong2:
                Toast.makeText(getContext(), "找工作", Toast.LENGTH_SHORT).show();
                Intent  intent3=new Intent(getContext(), FindworkActivity.class);
                startActivity(intent3);
                break;
            case R.id.imageView_baishitong3:
                Toast.makeText(getContext(), "找房子", Toast.LENGTH_SHORT).show();
                Intent  intent4=new Intent(getContext(), FindhouseActivity.class);
                startActivity(intent4);
                break;
            case R.id.right_image_erweima_find:
                Intent intentErweima = new Intent(getContext(), Sao1SaoActivity.class);
                startActivity(intentErweima);
                break;
            //美女秀
            case R.id.layout1:
                Intent intentBeauty = new Intent(getContext(), Sao1SaoActivity.class);
                startActivity(intentBeauty);
                break;
            //型男秀
            case R.id.layout2:
                Intent intentNan = new Intent(getContext(), Sao1SaoActivity.class);
                startActivity(intentNan);
                break;
            //萌宝秀
            case R.id.layout3:
                Intent intentBao = new Intent(getContext(), Sao1SaoActivity.class);
                startActivity(intentBao);
                break;
            //社区
            case R.id.home_layout1:
                FragmentBuilder.getInstance().show(BanquFragment.class).builder();
                break;
            //圈子
            case R.id.home_layout2:
                FragmentBuilder.getInstance().show(BanquFragment.class).builder();
                break;
            //问事
            case R.id.home_layout3:
                FragmentBuilder.getInstance().show(BanquFragment.class).builder();
                break;
        }
    }
}
