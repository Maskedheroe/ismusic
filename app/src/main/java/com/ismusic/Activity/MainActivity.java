package com.ismusic.Activity;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;

import com.ismusic.Adapter.ViewPagerAdapter;
import com.ismusic.Fragment.HomeFragment;
import com.ismusic.Interface.IMainContract;
import com.ismusic.Model.Global;
import com.ismusic.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainContract.View,View.OnClickListener {

    private ViewPager viewPager;
    private ImageView leftMenu;
    private ImageView searchButton;
    private TabLayout tabLayout;
    private DrawerLayout drawlayout;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void initView() {
        viewPager = findViewById(R.id.pager_main);
        searchButton = findViewById(R.id.search);
        leftMenu = findViewById(R.id.left_menu);
        tabLayout = findViewById(R.id.tab_layout);
        drawlayout = findViewById(R.id.drawlayout);
        fragmentList  = new ArrayList<>();
        for (int i=0;i<Global.title.length;i++){
            tabLayout.addTab(tabLayout.newTab().setText(Global.title[i]));
            fragmentList.add(new HomeFragment());
        }
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),this,fragmentList,Global.title);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        leftMenu.setOnClickListener(this);
    }


    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.left_menu:
                drawlayout.openDrawer(GravityCompat.START);
                break;
        }
    }
}
