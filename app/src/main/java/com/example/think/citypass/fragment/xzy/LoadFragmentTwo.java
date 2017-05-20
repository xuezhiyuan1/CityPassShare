package com.example.think.citypass.fragment.xzy;

import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.Urls;
import com.example.think.citypass.model.entity.FindBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by think on 2017/5/19.
 */

public class LoadFragmentTwo extends BaseFragment {
    //热门事   One
    private ImageView imageView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
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
    @Override
    protected int layoutId() {
        return R.layout.find_fragement;
    }

    @Override
    protected void initView(View view) {
        //热门事   One
        imageView = (ImageView) view.findViewById(R.id.bg_imagview);
        textView1 = (TextView) view.findViewById(R.id.title_textview);
        textView2 = (TextView) view.findViewById(R.id.title_textview_hot);
        textView3 = (TextView) view.findViewById(R.id.content_textview);
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
    }

    @Override
    protected void initData() {
        Map<String, String> map = new HashMap<>();
        map.put("param", "{\"customerID\":8001,\"requestTime\":\"2017-05-16 15:25:59\",\"Method\":\"PHSocket_GetAppSetInfo\",\"customerKey\":\"CEE365A69C5ADE99398408693ABAEE95\",\"appName\":\"CityGeneral\",\"version\":\"1.0\",\"Param\":{\"siteID\":2488,\"type\":3},\"Statis\":{\"SiteId\":0,\"UserId\":0,\"PhoneNo\":\"Le X620\",\"SystemNo\":2,\"System_VersionNo\":\"Android 6.0\",\"PhoneId\":\"\",\"PhoneNum\":\"0\"}}");
        RetrofitUtil.getInstance().postRetrofit(Urls.FINDPAGE, map, new ResaultCallBack() {
            @Override
            public void onSuccess(Object pbj) {
                FindBean findBean = (FindBean) pbj;
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

    }

    @Override
    protected void loadData() {


    }
}
