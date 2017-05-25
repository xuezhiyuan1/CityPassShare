package com.example.think.citypass.fragment.zzh;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.zzh.community.BanquFragment;
import com.example.think.citypass.fragment.zzh.community.MingrenFragment;
import com.example.think.citypass.fragment.zzh.community.NewestFragment;
import com.example.think.citypass.fragment.zzh.community.PengchangFragment;
import com.example.think.citypass.fragment.zzh.community.ThematicFragment;
import com.example.think.citypass.fragment.zzh.community.TushuoFragment;
import com.example.think.citypass.fragment.zzh.community.WorthFragment;
import com.example.think.citypass.myview.ChildViewPager;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends BaseFragment {

    private TabLayout tabLayout;

    private ChildViewPager viewPager;

    private String[] titles = {"捧场王", "名人堂", "版区", "最新", "热帖", "图说", "专题活动", "值得一看"};

    private List<Fragment> data;

    private ZzhPagerAdapter zzhPagerAdapter;


    @Override
    protected int layoutId() {
        return R.layout.fragment_community;
    }

    @Override
    protected void initView(View view) {
        tabLayout = (TabLayout) view.findViewById(R.id.community_tablayout);
        viewPager = (ChildViewPager) view.findViewById(R.id.community_viewpager);
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
        PengchangFragment pengchangFragment = new PengchangFragment();
        MingrenFragment mingrenFragment = new MingrenFragment();
        BanquFragment banquFragment = new BanquFragment();
        NewestFragment newestFragment = new NewestFragment();
        NewestFragment newestFragment1 = new NewestFragment();
        TushuoFragment tushuoFragment = new TushuoFragment();
        ThematicFragment thematicFragment = new ThematicFragment();
        WorthFragment worthFragment = new WorthFragment();
        data.add(pengchangFragment);
        data.add(mingrenFragment);
        data.add(banquFragment);
        data.add(newestFragment);
        data.add(newestFragment1);
        data.add(tushuoFragment);
        data.add(thematicFragment);
        data.add(worthFragment);

    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void loadData() {
        viewPager.setCurrentItem(3);
    }
}
