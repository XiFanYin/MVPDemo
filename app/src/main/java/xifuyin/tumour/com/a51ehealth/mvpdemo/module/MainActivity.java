package xifuyin.tumour.com.a51ehealth.mvpdemo.module;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseActivity;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.image.ui.ImageFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.ui.NewsFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.setting.ui.SettingFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.video.ui.VideoFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.weight.NoSlidingViewPaper;

/**
 * Created by Administrator on 2018/5/8.
 */

public class MainActivity extends BaseActivity {


    private NavigationView mNavigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NoSlidingViewPaper mViewPager;
    private TabLayout table_layout;
    private AppBarLayout appbar;
    private final ArrayList<Fragment> fgLists = new ArrayList<>(4);
    private MenuItem menuItem;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mNavigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        table_layout = findViewById(R.id.table_layout);
        mViewPager = findViewById(R.id.viewpager);
        appbar = findViewById(R.id.appbar);
        //设置数据
        fgLists.add(NewsFragment.newInstance());
        fgLists.add(ImageFragment.newInstance());
        fgLists.add(VideoFragment.newInstance());
        fgLists.add(SettingFragment.newInstance());
    }

    @Override
    public void initBar() {
        super.initBar();
        //设置页面标题
        toolbar.setTitle("新闻");
        //设置页面标题颜色
        toolbar.setTitleTextColor(Color.WHITE);
        //设置左侧图标
        toolbar.setNavigationIcon(R.drawable.ic_list_white);
        //取代ActionBar
        setSupportActionBar(toolbar);
        //设置左侧点击事件
        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });
    }


    //如果有Menu,创建完后,系统会自动添加到ToolBar上
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_news, menu);
        menuItem = menu.getItem(0);
        return true;
    }

    //处理Menu的点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_channel_manage) {
            Toast.makeText(act, "添加频道被点击", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initListener() {
        //左侧栏的点击事件
        mNavigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.action_news:
                    mViewPager.setCurrentItem(0);
                    toolbar.setTitle("新闻");
                    menuItem.setVisible(true);
                    menuItem.setEnabled(true);
                    break;

                case R.id.action_video:
                    mViewPager.setCurrentItem(1);
                    toolbar.setTitle("视频");
                    menuItem.setVisible(false);
                    menuItem.setEnabled(false);
                    break;
                case R.id.action_photo:
                    mViewPager.setCurrentItem(2);
                    toolbar.setTitle("图片");
                    menuItem.setVisible(false);
                    menuItem.setEnabled(false);
                    break;
                case R.id.action_settings:
                    mViewPager.setCurrentItem(3);
                    toolbar.setTitle("设置");
                    menuItem.setVisible(false);
                    menuItem.setEnabled(false);
                    break;
            }
            item.setChecked(true);
            drawerLayout.closeDrawer(GravityCompat.START);

            return false;
        });

        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fgLists.get(position);
            }

            @Override
            public int getCount() {
                return fgLists.size();
            }
        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3); //预加载剩下三页


    }
    //把这个Tablelayout对象传递给fragment中去
    public TabLayout getTableLayout() {
        return table_layout;
    }




}
