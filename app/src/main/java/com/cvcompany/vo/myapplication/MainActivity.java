package com.cvcompany.vo.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.cvcompany.vo.myapplication.View.Adapter.MyViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private LayoutInflater inflater;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewPager();
        animation = AnimationUtils.loadAnimation(this, R.anim.effect_button);
    }

    private void initViewPager() {
        MyViewPagerAdapter adapter=  new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        initView1();
        initView2();
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setCustomView(R.layout.view1);
        tabLayout.getTabAt(1).setCustomView(R.layout.view2);
    }

    private void initView2() {
        View view = inflater.inflate(R.layout.view1,null);
        ImageView img  =view.findViewById(R.id.img);
        img.setAnimation(animation);
    }

    private void initView1() {
        View view = inflater.inflate(R.layout.view2,null);
        ImageView img  =view.findViewById(R.id.img);
        img.setAnimation(animation);
    }
}
