package com.example.think.citypass.fragment.zzh.community;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.Urls;
import com.example.think.citypass.fragment.zzh.community.adapter.TushuoAdapter;
import com.example.think.citypass.model.enitity.TushuoBean;
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

public class TushuoFragment extends BaseFragment {
    private MRefreshUtils mRefreshUtils;

    private TushuoAdapter adapter;

    private List<TushuoBean.ServerInfoBean> data = new ArrayList<>();

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
        adapter = new TushuoAdapter(data);
        mRefreshUtils = new MRefreshUtils(getActivity(), (RelativeLayout) getFragmentLayoutView(), onListStateListener);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, TushuoBean.class);
    }


    private ResaultCallBack callBack = new ResaultCallBack() {
        @Override
        public void onSuccess(Object obj) {
            TushuoBean tushuoBean = (TushuoBean) obj;
            List<TushuoBean.ServerInfoBean> infoBeanList = tushuoBean.getServerInfo();

            if (isFrist) {
                isFrist = false;
                data.addAll(infoBeanList);
                mRefreshUtils.setPageNums(tushuoBean.getPageNum());
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
            RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, TushuoBean.class);
        }

        @Override
        public void onRefresh() {
            page = 1;
            RetrofitUtil.getInstance().postRetrofitTwo(getParams(), callBack, TushuoBean.class);
        }

        @Override
        public void onSuccess(boolean Refresh, Object result) {
            TushuoBean tushuoBean = (TushuoBean) result;
            List<TushuoBean.ServerInfoBean> infoBeen = ((TushuoBean) result).getServerInfo();

            if (Refresh) {
                mRefreshUtils.startUpdate(tushuoBean.getGxNum());
                data.clear();
            }
            data.addAll(infoBeen);
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
            jo.put("userName", "");
            jo.put("userID", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return LinuxUtils.createnewsParam(Urls.TUSHUO, jo);
    }
}
