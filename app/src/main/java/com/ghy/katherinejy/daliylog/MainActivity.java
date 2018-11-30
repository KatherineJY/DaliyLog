package com.ghy.katherinejy.daliylog;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

import com.ghy.katherinejy.daliylog.fragments.VpSimpleFragment;
import com.ghy.katherinejy.daliylog.fragments.WhenFragment;
import com.ghy.katherinejy.daliylog.views.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private ViewPagerIndicator mIndicator;
    private List<String> mTitles = Arrays.asList("When", "Where", "Mine");
    private List<Fragment> mContents = new ArrayList<>();
    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);

        initView();
		mIndicator.setVisibleTabCount(3);
        mIndicator.setTabItemTitles(mTitles);
        initFragments();
        mViewPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mViewPager,0);
    }

    private void initFragments() {
        WhenFragment whenFragment = new WhenFragment();
        mContents.add(whenFragment);
        WhenFragment whenFragment1 = new WhenFragment();
        mContents.add(whenFragment1);
//        for (String title : mTitles) {
//            VpSimpleFragment fragment = VpSimpleFragment.newInstance(title);
//            mContents.add(fragment);
//        }
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mContents.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mContents.get(position);
            }
        };
    }

    private void initView() {
        mViewPager = findViewById(R.id.id_viewpager);
        mIndicator = findViewById(R.id.id_indicator);
    }



}