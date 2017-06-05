package com.example.think.citypass.fragment.xzy.beauty;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.think.citypass.ParamUtils;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.cityadapter.XinShanglistAdapter;
import com.example.think.citypass.model.entity.XinShangBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by think on 2017/6/5.
 */

public class XinShangFragment extends BaseFragment {


    private List<XinShangBean.ServerInfoBean> datas;
    private ListView listView;
    private int pageSize = 1;
    private XinShanglistAdapter adapter;
    private LinearLayout linearLayout;
    private View headView;
    private View viewFoot;
    private List<XinShangBean.ServerInfoBean.CoverXinShangInfoListBeanX.CoverXinShangInfoListBean> mListA=new ArrayList<>();
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textViewg1;
    private TextView textViewg2;
    private TextView textViewg3;

    @Override
    protected int layoutId() {
        return R.layout.love_top_water;
    }

    @Override
    protected void initView(View view) {
        headView = LayoutInflater.from(getActivity()).inflate(R.layout.cover_ranking_item, null);
        datas = new ArrayList<>();
        linearLayout = (LinearLayout) view.findViewById(R.id.load_city);

        imageView1 = (ImageView) headView.findViewById(R.id.image_golden);
        imageView2 = (ImageView) headView.findViewById(R.id.image_silvery);
        imageView3 = (ImageView) headView.findViewById(R.id.image_coppery);

        textView1 = (TextView) headView.findViewById(R.id.top_name_text1);
        textView2 = (TextView) headView.findViewById(R.id.top_name_text2);
        textView3 = (TextView) headView.findViewById(R.id.top_name_text3);

        textViewg1 = (TextView) headView.findViewById(R.id.gift_text1);
        textViewg2 = (TextView) headView.findViewById(R.id.gift_text2);
        textViewg3 = (TextView) headView.findViewById(R.id.gift_text3);


        adapter = new XinShanglistAdapter(getContext(),mListA);
        listView = (ListView) view.findViewById(R.id.list_item);
        listView.addHeaderView(headView);
        viewFoot = LayoutInflater.from(getContext()).inflate(R.layout.datasnullmore, null);
        listView.addFooterView(viewFoot);
        listView.setAdapter(adapter);
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what == 200){
                linearLayout.setVisibility(View.GONE);
            }
            return true;
        }
    });

    @Override
    protected void initData() {
        handler.sendEmptyMessageAtTime(200,2000);
    }

    @Override
    protected void initListener() {

    }

    public String dataCreatParams() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2422);
            jo.put("curPage",pageSize);
            jo.put("TypeId", 0);
            jo.put("pageSize", 50);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = ParamUtils.createParam("PHSocket_GetCoverXinShangInfo", jo);
        return params;

    }

    @Override
    protected void loadData() {
        Map<String,String> map = new HashMap<>();
        map.put("param",dataCreatParams());
        RetrofitUtil.getInstance().postRetrofit("http://appnew.ccoo.cn/appserverapi.ashx", map, new ResaultCallBack() {
            @Override
            public void onSuccess(Object obj) {
                XinShangBean bean = (XinShangBean) obj;
                List<XinShangBean.ServerInfoBean.CoverXinShangInfoListBeanX.CoverXinShangInfoListBean> list = bean.getServerInfo().getCoverXinShangInfoList().getCoverXinShangInfoList();
                mListA.addAll(list);

                String userface = bean.getServerInfo().getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3().get(0).getUserface();
                Glide.with(getContext()).load(userface).into(imageView1);
                String userface2 = bean.getServerInfo().getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3().get(1).getUserface();
                Glide.with(getContext()).load(userface2).into(imageView2);
                String userface3 = bean.getServerInfo().getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3().get(2).getUserface();
                Glide.with(getContext()).load(userface3).into(imageView3);

                String nick = bean.getServerInfo().getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3().get(0).getNick();
                textView1.setText(nick);
                String nick1 = bean.getServerInfo().getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3().get(1).getNick();
                textView2.setText(nick1);
                String nick2 = bean.getServerInfo().getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3().get(2).getNick();
                textView3.setText(nick2);

                String likeTotal = bean.getServerInfo().getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3().get(0).getLikeTotal();
                textViewg1.setText(likeTotal);
                String likeTotal1 = bean.getServerInfo().getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3().get(1).getLikeTotal();
                textViewg2.setText(likeTotal1);
                String likeTotal2 = bean.getServerInfo().getCoverXinShangInfoListTop3().getCoverXinShangInfoListTop3().get(2).getLikeTotal();
                textViewg3.setText(likeTotal2);

                adapter.notifyDataSetChanged();
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
        },XinShangBean.class);
    }

}
