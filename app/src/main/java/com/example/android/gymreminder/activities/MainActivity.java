package com.example.android.gymreminder.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.gymreminder.R;
import com.example.android.gymreminder.fragments.FragmentA;
import com.example.android.gymreminder.fragments.FragmentB;
import com.example.android.gymreminder.fragments.FragmentC;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActionBar = getSupportActionBar();
        mActionBar.setTitle("Fragment A");

        initComponents();
        setupViewPager(mPager);
        mTabLayout.setupWithViewPager(mPager);
        if (mTabLayout.getTabCount()==3){
            mTabLayout.getTabAt(0).setCustomView(R.layout.tabs);
            ((TextView)mTabLayout.getTabAt(0).getCustomView().findViewById(R.id.tvText)).setText("A");
            mTabLayout.getTabAt(1).setCustomView(R.layout.tabs);
            ((TextView)mTabLayout.getTabAt(1).getCustomView().findViewById(R.id.tvText)).setText("B");
            mTabLayout.getTabAt(2).setCustomView(R.layout.tabs);
            ((TextView)mTabLayout.getTabAt(2).getCustomView().findViewById(R.id.tvText)).setText("C");
        }

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mActionBar.setTitle("Fragment A");
                        break;
                    case 1:
                        mActionBar.setTitle("Fragment B");
                        break;
                    case 2:
                        mActionBar.setTitle("Fragment C");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initComponents() {
        mTabLayout = (TabLayout) findViewById(R.id.sliding_tab);
        mPager = (ViewPager) findViewById(R.id.pager);
    }

    private void setupViewPager(ViewPager viewPager) {
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFrag(new FragmentA());
        mPagerAdapter.addFrag(new FragmentB());
        mPagerAdapter.addFrag(new FragmentC());
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
    }
}
