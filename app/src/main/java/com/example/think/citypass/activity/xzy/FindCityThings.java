package com.example.think.citypass.activity.xzy;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.think.citypass.ParamUtils;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.xzy.FindCTyoutaidu;
import com.example.think.citypass.fragment.zzh.naonao.NaonaoDiFragment;
import com.example.think.citypass.fragment.zzh.naonao.NaonaoXingFragment;
import com.example.think.citypass.fragment.zzh.naonao.WangyouFragment;
import com.example.think.citypass.model.bean.TitleBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by think on 2017/5/22.
 */

public class FindCityThings  extends BaseActivity implements View.OnClickListener{
    TabLayout  tabLayout;
    ViewPager  viewPager;
    List<String>  stringList;
    List<BaseFragment>  fragmentList;
    ViewpagerAdapter  adapter;
    ImageView imageView;
    private List<TitleBean> titleBeen;

    @Override
    protected int layoutId() {
        return R.layout.findcitything;
    }

    @Override
    protected void initView() {

        tabLayout= (TabLayout) findViewById(R.id.findcitything_tablayout);
        viewPager= (ViewPager) findViewById(R.id.findcitything_viewpager);
        imageView = (ImageView) findViewById(R.id.image1);
    }

    @Override
    protected void initData() {
        titleBeen = new ArrayList<>();
        stringList=new ArrayList<>();
        fragmentList=new ArrayList<>();
    }

    @Override
    protected void initListener() {
       imageView.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
       JSONObject jo = new JSONObject();
        try {
            jo.put("siteID",2422);
            jo.put("type", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String param = ParamUtils.createParam("PHSocket_GetUseNavigationInfo", jo);
        Map<String,String> map = new HashMap<>();
        map.put("param",param);
        RetrofitUtil.getInstance().postRetrofit("http://appnew.ccoo.cn/appserverapi.ashx", map, new ResaultCallBack() {
            @Override
            public void onSuccess(Object pbj) {
                TitleBean bean = (TitleBean) pbj;
                for (int i = 0; i < bean.getServerInfo().size(); i++) {
                    String name = bean.getServerInfo().get(i).getName();
                    stringList.add(name);
                }
                for (int i = 0; i < stringList.size(); i++) {
                    if(i == 5){
                        NaonaoXingFragment naonaoXingFragment = new NaonaoXingFragment();
                        fragmentList.add(naonaoXingFragment);
                    }else {
                        WangyouFragment wangyouFragment = new WangyouFragment();
                        fragmentList.add(wangyouFragment);
                    }
                }


                adapter=new ViewpagerAdapter(getSupportFragmentManager(),stringList,fragmentList);
                viewPager.setAdapter(adapter);
                tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
                tabLayout.setupWithViewPager(viewPager);
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
        },TitleBean.class);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image1:
                finish();
                break;
        }
    }


    class  ViewpagerAdapter   extends FragmentPagerAdapter{
          List<String>  stringList;
          List<BaseFragment>  fragmentList;
        public ViewpagerAdapter(FragmentManager fm,List<String>  stringList,List<BaseFragment>  fragmentList) {
            super(fm);
            this.stringList=stringList;
            this.fragmentList=fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return stringList.get(position);
        }
    }


}
