package com.example.android.gymreminder.activities;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.gymreminder.R;
import com.example.android.gymreminder.fragments.Stats;
import com.example.android.gymreminder.fragments.Inbox;
import com.example.android.gymreminder.fragments.Days;
import com.example.android.gymreminder.fragments.Profile;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private ActionBar mActionBar;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActionBar = getSupportActionBar();
        if (mActionBar != null)
            mActionBar.setTitle("Stats");

        initComponents();
        setupViewPager(mPager);

        mTabLayout.setupWithViewPager(mPager);
        if (mTabLayout.getTabCount() == 4) {
            mTabLayout.getTabAt(0).setCustomView(R.layout.tabs);
            ((TextView) mTabLayout.getTabAt(0).getCustomView().findViewById(R.id.tvText)).setText("Stats");
            ((ImageView) mTabLayout.getTabAt(0).getCustomView().findViewById(R.id.ivIcon)).setImageResource(R.drawable.fragment_a);
            mTabLayout.getTabAt(1).setCustomView(R.layout.tabs);
            ((TextView) mTabLayout.getTabAt(1).getCustomView().findViewById(R.id.tvText)).setText("Inbox");
            ((ImageView) mTabLayout.getTabAt(1).getCustomView().findViewById(R.id.ivIcon)).setImageResource(R.drawable.fragment_b);
            mTabLayout.getTabAt(2).setCustomView(R.layout.tabs);
            ((TextView) mTabLayout.getTabAt(2).getCustomView().findViewById(R.id.tvText)).setText("Days");
            ((ImageView) mTabLayout.getTabAt(2).getCustomView().findViewById(R.id.ivIcon)).setImageResource(R.drawable.fragment_c);
            mTabLayout.getTabAt(3).setCustomView(R.layout.tabs);
            ((TextView) mTabLayout.getTabAt(3).getCustomView().findViewById(R.id.tvText)).setText("Profile");
            ((ImageView) mTabLayout.getTabAt(3).getCustomView().findViewById(R.id.ivIcon)).setImageResource(R.drawable.person);
        }

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mActionBar.setTitle("Stats");
                        break;
                    case 1:
                        mActionBar.setTitle("Inbox");
                        break;
                    case 2:
                        mActionBar.setTitle("Days");
                        break;
                    case 3:
                        mActionBar.setTitle("Profile");
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
        mPagerAdapter.addFrag(new Stats());
        mPagerAdapter.addFrag(new Inbox());
        mPagerAdapter.addFrag(new Days());
        mPagerAdapter.addFrag(new Profile());
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setOffscreenPageLimit(4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.myProfile:
                break;
            case R.id.settings:
                break;
            case R.id.logout:
                break;
            case R.id.alerts:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
