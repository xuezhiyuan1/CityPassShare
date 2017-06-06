package com.example.think.citypass.fragment.xzy.beauty;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.Urls;
import com.example.think.citypass.fragment.xzy.beauty.adapter.FmnlAdapter;
import com.example.think.citypass.fragment.zzh.community.adapter.WorthAdapter;
import com.example.think.citypass.model.enitity.WorthBean;
import com.example.think.citypass.model.entity.FmnlBean;
import com.example.think.citypass.model.entity.ZuiXinBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.LinuxUtils;
import com.example.think.citypass.utils.recyclerviewutils.MRefreshUtils;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2017/6/6.
 */

public class FmnlFragment extends BaseFragment {

    private MRefreshUtils mRefreshUtils;

    private FmnlAdapter adapter;

    private List<FmnlBean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> data = new ArrayList<>();

    private int page = 1;

    private boolean isFrist = true;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mRefreshUtils.requestData(msg.obj);
            }
        }
    };
    private View viewFoot;

    @Override
    protected int layoutId() {
        return R.layout.naonao_refreshlist;
    }

    @Override
    protected void initView(View view) {
        viewFoot = LayoutInflater.from(getContext()).inflate(R.layout.datasnullmore, null);

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        adapter = new FmnlAdapter(data);
        mRefreshUtils = new MRefreshUtils(getActivity(), (RelativeLayout) getFragmentLayoutView(), onListStateListener);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, FmnlBean.class);
    }


    private ResaultCallBack callBack = new ResaultCallBack() {
        @Override
        public void onSuccess(Object obj) {
            FmnlBean fmnlBean = (FmnlBean) obj;
            List<FmnlBean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> figureTCoverInfoList = fmnlBean.getServerInfo().getFigureTCoverInfoList().getFigureTCoverInfoList();

            if (isFrist) {
                isFrist = false;
                data.addAll(figureTCoverInfoList);
                mRefreshUtils.setPageNums(fmnlBean.getPageNum());
                mRefreshUtils.setAdapter(1, adapter);
                mRefreshUtils.showNormal();
            } else {
                Message message = new Message();
                message.obj = obj;
                message.what = 1;
                handler.sendMessageDelayed(message, 1500);
            }

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


    private MRefreshUtils.OnListStateListener onListStateListener = new MRefreshUtils.OnListStateListener() {
        @Override
        public void onLoadMore() {
            page++;
            RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, FmnlBean.class);
        }

        @Override
        public void onRefresh() {
            page = 1;
            RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, FmnlBean.class);
        }

        @Override
        public void onSuccess(boolean Refresh, Object result) {
            FmnlBean fmnlBean = (FmnlBean) result;
            List<FmnlBean.ServerInfoBean.FigureTCoverInfoListBeanX.FigureTCoverInfoListBean> figureTCoverInfoList = fmnlBean.getServerInfo().getFigureTCoverInfoList().getFigureTCoverInfoList();

            if (Refresh) {
                mRefreshUtils.startUpdate(fmnlBean.getGxNum());
                data.clear();
            }
            data.addAll(figureTCoverInfoList);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onFailure(boolean Refresh, Object result) {

        }

        @Override
        public void onFirstFailure() {

        }
    };

    private String getParams() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2422);
            jo.put("curPage", page);
            jo.put("pageSize", 10);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return LinuxUtils.createnewsParam(Urls.FENGMIANNVLANG, jo);
    }

}
