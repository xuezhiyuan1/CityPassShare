package com.example.think.citypass.fragment.xzy.citything;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.think.citypass.ParamUtils;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.cityadapter.QianWaterAdapter;
import com.example.think.citypass.model.entity.CityBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by think on 2017/5/31.
 */

public class LoveWaterTop extends BaseFragment {

    private QianWaterAdapter adapter;
    private List<CityBean.ServerInfoBean> datas;
    private ListView listView;
    private int pageSize = 1;
    private LinearLayout linearLayout;
    private View headView;
    private View viewFoot;

    @Override
    protected int layoutId() {
        return R.layout.love_top_water;
    }

    @Override
    protected void initView(View view) {
        headView = LayoutInflater.from(getActivity()).inflate(R.layout.loveqianwaterhead, null);
        datas = new ArrayList<>();
        linearLayout = (LinearLayout) view.findViewById(R.id.load_city);
        adapter = new QianWaterAdapter(getActivity(),datas);
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


    public String dataCreatParams(int type) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2422);
            jo.put("type", type);
            jo.put("curPage", pageSize++ );
            jo.put("pageSize", 50);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = ParamUtils.createParam("PHSocket_GetCityNewsUserList", jo);
        Log.i("aaaaa",params);
        return params;

    }

    @Override
    protected void loadData() {
        Map<String,String> map = new HashMap<>();
        map.put("param",dataCreatParams(3));
        RetrofitUtil.getInstance().postRetrofit("http://appnew.ccoo.cn/appserverapi.ashx", map, new ResaultCallBack() {
            @Override
            public void onSuccess(Object obj) {
                CityBean bean = (CityBean) obj;
                List<CityBean.ServerInfoBean> serverInfo = bean.getServerInfo();
                Log.i("asdasd",serverInfo.size()+"");
                datas.addAll(serverInfo);
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
        },CityBean.class);
    }
}
