package com.example.think.citypass.fragment.zzh.community;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.Urls;
import com.example.think.citypass.fragment.zzh.community.adapter.MingrenAdapter;
import com.example.think.citypass.model.enitity.PengchangBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.LinuxUtils;
import com.example.think.citypass.utils.recyclerviewutils.MRefreshUtils;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/5/22.
 */

public class MingrenFragment extends BaseFragment {
    private MRefreshUtils mRefreshUtils;

    private List<PengchangBean.ServerInfoBean.InfoBean> data;
    private List<PengchangBean.ServerInfoBean.InfoBean> headData;

    private View headView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mRefreshUtils.requestData("成功");
            }
        }
    };

    private ImageView goldenImage, silveryImage, copperyImage;

    private TextView goldenTextName,goldenTextCount,goldenTextType,silveryTextName,silveryTextCount,silveryTextType,copperyTextName,copperyTextCount,copperyTextType;

    @Override
    protected int layoutId() {
        return R.layout.naonao_refreshlist;
    }

    @Override
    protected void initView(View view) {
        headView = View.inflate(App.activity, R.layout.cover_ranking_item, null);
        headView.findViewById(R.id.top_relay).setBackgroundResource(R.drawable.tieba_top_bg1);


        goldenImage = (ImageView) headView.findViewById(R.id.image_golden);

        silveryImage = (ImageView) headView.findViewById(R.id.image_silvery);

        copperyImage = (ImageView) headView.findViewById(R.id.image_coppery);

        goldenTextCount = (TextView) headView.findViewById(R.id.gift_text1);
        goldenTextType = (TextView) headView.findViewById(R.id.gift_texts1);
        goldenTextName = (TextView) headView.findViewById(R.id.top_name_text1);


        silveryTextCount = (TextView) headView.findViewById(R.id.gift_text2);
        silveryTextType = (TextView) headView.findViewById(R.id.gift_texts2);
        silveryTextName = (TextView) headView.findViewById(R.id.top_name_text2);

        copperyTextCount = (TextView) headView.findViewById(R.id.gift_text3);
        copperyTextType = (TextView) headView.findViewById(R.id.gift_texts3);
        copperyTextName = (TextView) headView.findViewById(R.id.top_name_text3);

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        headData = new ArrayList<>();

        mRefreshUtils = new MRefreshUtils(getActivity(), (RelativeLayout) getFragmentLayoutView(), onListStateListener);

        mRefreshUtils.movelayoutDismiss();

        mRefreshUtils.addHeadView(headView);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, PengchangBean.class);
    }

    private ResaultCallBack callBack = new ResaultCallBack() {
        @Override
        public void onSuccess(Object pbj) {
            List<PengchangBean.ServerInfoBean.InfoBean> info = ((PengchangBean) pbj).getServerInfo().getInfo();
            if (info.size() > 3) {
                for (int i = 0; i < 3; i++) {
                    headData.add(info.get(0));
                    info.remove(info.get(0));
                }
                data.addAll(info);
            } else if (!(info == null || info.size() == 0&&info.size()<=3)) {
                for (int i = 0; i < info.size(); i++) {
                    headData.add(info.get(0));
                    info.remove(info.get(0));
                }
            }

            if (headData.get(0) != null) {
                Glide.with(App.activity)
                        .load(headData.get(0).getUserFace())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.shape_image_zhanwei)
                        .centerCrop()
                        .crossFade(500)
                        .into(goldenImage);
                goldenTextName.setText(headData.get(0).getNick());
                goldenTextCount.setText(headData.get(0).getSum());
                goldenTextType.setText("获得回复");
                goldenImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(App.activity, String.valueOf(headData.get(0).getUserID()), Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                goldenImage.setImageResource(R.drawable.shape_image_zhanwei);
            }

            if (headData.get(1) != null) {
                Glide.with(App.activity)
                        .load(headData.get(1).getUserFace())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.shape_image_zhanwei)
                        .centerCrop()
                        .crossFade(500)
                        .into(silveryImage);
                silveryTextName.setText(headData.get(1).getNick());
                silveryTextCount.setText(headData.get(1).getSum());
                silveryTextType.setText("获得回复");
                silveryImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(App.activity, String.valueOf(headData.get(1).getUserID()), Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                silveryImage.setImageResource(R.drawable.shape_image_zhanwei);
            }

            if (headData.get(2) != null) {
                Glide.with(App.activity)
                        .load(headData.get(2).getUserFace())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.shape_image_zhanwei)
                        .centerCrop()
                        .crossFade(500)
                        .into(copperyImage);
                copperyTextName.setText(headData.get(2).getNick());
                copperyTextCount.setText(headData.get(2).getSum());
                copperyTextType.setText("获得回复");
                copperyImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(App.activity, String.valueOf(headData.get(2).getUserID()), Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                copperyImage.setImageResource(R.drawable.shape_image_zhanwei);
            }

            mRefreshUtils.setAdapter(1, new MingrenAdapter(data));

            mRefreshUtils.showNormal();

            mRefreshUtils.setNoMore(true);
        }

        @Override
        public void onError(String errorMsg) {
            Toast.makeText(App.activity, errorMsg, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void notNet(String netData) {
            Toast.makeText(App.activity, netData, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onErrorParams(String errorParams) {
            Toast.makeText(App.activity, errorParams, Toast.LENGTH_SHORT).show();
        }
    };


    private String getParams() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2422);
            jo.put("userID", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String value = LinuxUtils.createnewsParam(Urls.MINGRENTANG, jo);
        return value;
    }

    private MRefreshUtils.OnListStateListener onListStateListener = new MRefreshUtils.OnListStateListener() {
        @Override
        public void onLoadMore() {

        }

        @Override
        public void onRefresh() {
            handler.sendEmptyMessageDelayed(1, 2000);
        }

        @Override
        public void onSuccess(boolean Refresh, Object result) {
            mRefreshUtils.setNoMore(true);
        }

        @Override
        public void onFailure(boolean Refresh, Object result) {

        }

        @Override
        public void onFirstFailure() {

        }
    };
}
