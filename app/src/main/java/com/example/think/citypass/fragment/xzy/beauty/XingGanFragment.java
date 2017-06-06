package com.example.think.citypass.fragment.xzy.beauty;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.Urls;
import com.example.think.citypass.fragment.xzy.beauty.adapter.XingGanAdapter;
import com.example.think.citypass.fragment.xzy.beauty.adapter.ZuiXinAdapter;
import com.example.think.citypass.model.bean.XingGanBean;
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

public class XingGanFragment extends BaseFragment {
    private MRefreshUtils mRefreshUtils;

    private XingGanAdapter adapter;

    private List<XingGanBean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> data = new ArrayList<>();

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

    @Override
    protected int layoutId() {
        return R.layout.naonao_refreshlist;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        adapter = new XingGanAdapter(data);
        mRefreshUtils = new MRefreshUtils(getActivity(), (RelativeLayout) getFragmentLayoutView(), onListStateListener);
        mRefreshUtils.setItemDecoration(5);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, XingGanBean.class);
    }


    private ResaultCallBack callBack = new ResaultCallBack() {
        @Override
        public void onSuccess(Object obj) {
            XingGanBean xingGanBean = (XingGanBean) obj;
            List<XingGanBean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> newTCoverInfoList = xingGanBean.getServerInfo().getNewTCoverInfoList().getNewTCoverInfoList();
            if (isFrist) {
                isFrist = false;
                data.addAll(newTCoverInfoList);
                mRefreshUtils.setPageNums(xingGanBean.getPageNum());
                mRefreshUtils.setAdapter(2, adapter);
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
            RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, XingGanBean.class);
        }

        @Override
        public void onRefresh() {
            page = 1;
            RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, XingGanBean.class);
        }

        @Override
        public void onSuccess(boolean Refresh, Object result) {
            XingGanBean xingGanBean = (XingGanBean) result;
            List<XingGanBean.ServerInfoBean.NewTCoverInfoListBeanX.NewTCoverInfoListBean> newTCoverInfoList = xingGanBean.getServerInfo().getNewTCoverInfoList().getNewTCoverInfoList();
            if (Refresh) {
                mRefreshUtils.startUpdate(xingGanBean.getGxNum());
                data.clear();
            }
            data.addAll(newTCoverInfoList);
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
            jo.put("pageSize", 5);
            jo.put("ImName", "flag");
            jo.put("userID", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return LinuxUtils.createnewsParam(Urls.ZUIXIN, jo);
    }

}
