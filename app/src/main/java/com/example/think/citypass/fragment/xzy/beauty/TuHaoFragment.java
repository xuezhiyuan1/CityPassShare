package com.example.think.citypass.fragment.xzy.beauty;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.zzh.naonao.adapter.WangyouAdapter;
import com.example.think.citypass.utils.recyclerviewutils.MRefreshUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2017/6/6.
 */

public class TuHaoFragment extends BaseFragment {

    private MRefreshUtils mRefreshUtils;

    private TextView textView;
    private List<String> data;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mRefreshUtils.requestData("成功");
            }
        }
    };


    @Override
    protected int layoutId() {
        return R.layout.naonao_refreshlist;
    }

    @Override
    protected void initView(View view) {
        textView = (TextView) view.findViewById(R.id.nullData);
    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        mRefreshUtils = new MRefreshUtils(getActivity(), (RelativeLayout) getFragmentLayoutView(), onListStateListener);
        mRefreshUtils.setAdapter(1, new WangyouAdapter());
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        handler.sendEmptyMessageDelayed(1, 2000);
    }

    private MRefreshUtils.OnListStateListener onListStateListener = new MRefreshUtils.OnListStateListener() {
        @Override
        public void onLoadMore() {
            if (data.size() == 0 || data.isEmpty()) {
                mRefreshUtils.setNoMore(true);
                textView.setVisibility(View.VISIBLE);
            } else {
                handler.sendEmptyMessageDelayed(1, 2000);
                textView.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onRefresh() {
            handler.sendEmptyMessageDelayed(1, 2000);
        }

        @Override
        public void onSuccess(boolean Refresh, Object result) {

            mRefreshUtils.showNormal();
            if (Refresh) {
                mRefreshUtils.startUpdate(10);
            }

        }

        @Override
        public void onFailure(boolean Refresh, Object result) {

        }

        @Override
        public void onFirstFailure() {

        }
    };
}
