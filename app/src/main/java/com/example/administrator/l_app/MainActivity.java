package com.example.administrator.l_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.administrator.l_app.Fragment.CircleFragment;
import com.example.administrator.l_app.Fragment.FindFragment;
import com.example.administrator.l_app.Fragment.MeFragment;
import com.example.administrator.l_app.Fragment.MsgFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    private BottomNavigationBar mBottomNavigationBar;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();

    }

    private void init() {
        mFragments = new ArrayList<>();
        mFragments.add(new CircleFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new MsgFragment());
        mFragments.add(new MeFragment());

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.nav_circle_selector,"动态"))
                .addItem(new BottomNavigationItem(R.drawable.nav_find_selector,"发现"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.nav_me_selector,"我"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        //设置默认页面
        setFragment(0);
    }

    private void initView() {
        mBottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
    }

    private void setFragment(int position){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_container,mFragments.get(position));
        ft.commit();

    }

        @Override
        public void onTabSelected(int position) {
            setFragment(position);
        }

        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {

        }

}