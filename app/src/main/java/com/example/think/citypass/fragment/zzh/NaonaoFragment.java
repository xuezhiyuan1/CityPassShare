package com.example.think.citypass.fragment.zzh;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.zzh.naonao.NaonaoDiFragment;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by ASUS on 2017/5/16.
 */

public class NaonaoFragment extends BaseFragment {

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private LinearLayout linearLayout;

    private String[] titles = {"闹闹帝", "闹闹王", "闹闹星", "广场", "话题", "推荐", "晒图", "网友自荐"};

    private List<Fragment> data;

    private ZzhPagerAdapter zzhPagerAdapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_naonao;
    }

    @Override
    protected void initView(View view) {
        linearLayout = (LinearLayout) view.findViewById(R.id.ll_loading);
        tabLayout = (TabLayout) view.findViewById(R.id.naonaoTabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.naonaoViewPager);
    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        initFragment();
        zzhPagerAdapter = new ZzhPagerAdapter(getFragmentManager(), data, titles);
        viewPager.setAdapter(zzhPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragment() {
        NaonaoDiFragment naonaoDiFragment = new NaonaoDiFragment();
        data.add(naonaoDiFragment);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }
}
