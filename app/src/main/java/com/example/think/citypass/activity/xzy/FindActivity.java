package com.example.think.citypass.activity.xzy;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.xzy.FindCTyoutaidu;
import com.example.think.citypass.fragment.zzh.naonao.WangyouFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2017/5/22.
 */

public class FindActivity  extends BaseActivity implements View.OnClickListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    List<String> stringList;
    List<BaseFragment>  fragmentList;
    ViewpagerAdapter adapter;
    ImageView imageView;
    @Override
    protected int layoutId() {
        return R.layout.find_activity;
    }

    @Override
    protected void initView() {
        tabLayout= (TabLayout) findViewById(R.id.findcitything_tablayout);
        viewPager= (ViewPager) findViewById(R.id.findcitything_viewpager);
        imageView = (ImageView) findViewById(R.id.image_citything);
    }

    @Override
    protected void initData() {
        stringList=new ArrayList<>();
        fragmentList=new ArrayList<>();
        stringList.add("带头大哥");
        stringList.add("铁杆粉丝");
        stringList.add("热门活动");
        stringList.add("娱乐交友");
        stringList.add("亲子教育");
        stringList.add("运动户外");
        stringList.add("网络活动");
        stringList.add("促销优惠");
        stringList.add("公益活动");
        stringList.add("工作生活");
        for (int i = 0; i < stringList.size(); i++) {
            WangyouFragment wangyouFragment = new WangyouFragment();
            fragmentList.add(wangyouFragment);
        }
        adapter=new ViewpagerAdapter(getSupportFragmentManager(),stringList,fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void initListener()  {
       imageView.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_citything:
                finish();
                break;
        }
    }


    class  ViewpagerAdapter   extends FragmentPagerAdapter {
        List<String>  stringList;
        List<BaseFragment>  fragmentList;
        public ViewpagerAdapter(FragmentManager fm, List<String>  stringList, List<BaseFragment>  fragmentList) {
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
