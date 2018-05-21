package com.example.administrator.l_app.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.l_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<Fragment> mFragments;
    private View mView;
    private String[] mPageTitle={"新闻","视频","图片"};


    public CircleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_circle, container, false);
        initView();
        init();
        return mView;
    }

    private void init() {
        mFragments = new ArrayList<>();
        mFragments.add(new NewsFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new ImageFragment());

        mViewPager.setAdapter(new MyFragmentViewPagerAdapter(getChildFragmentManager()));

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initView() {
        mTabLayout = (TabLayout)mView.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager)mView.findViewById(R.id.view_pager);
    }
    private class MyFragmentViewPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        //显示具体顶部标题
        @Override
        public CharSequence getPageTitle(int position) {
            return mPageTitle[position];
        }
    }

    }


