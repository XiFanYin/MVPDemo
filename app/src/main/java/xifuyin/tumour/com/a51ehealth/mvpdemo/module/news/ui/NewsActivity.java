package xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseMvpLoadingActivity;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.image.ui.ImageActivity;
import xifuyin.tumour.com.a51ehealth.mvpdemo.db.NewsDBTable;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.persenter.NewsDBPresenter;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.persenter.contact.NewsDBContact;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.ui.adapter.TableAdapter;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.setting.ui.SettingActivity;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.video.ui.VideoActivity;
import xifuyin.tumour.com.a51ehealth.mvpdemo.utils.ViewUtils;

/**
 * Created by Administrator on 2018/5/8.
 */

public class NewsActivity extends BaseMvpLoadingActivity<NewsDBPresenter> implements NewsDBContact.view {


    private NavigationView mNavigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    private ViewPager view_pager;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private TableAdapter adapter;
    private TabLayout table_layout;


    @Override
    protected NewsDBPresenter initPersenter() {
        return new NewsDBPresenter(this);
    }

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
        view_pager = findViewById(R.id.viewpager);

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
                case R.id.action_video:
                    Intent intent2 = new Intent(NewsActivity.this, VideoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.action_photo:
                    Intent intent3 = new Intent(NewsActivity.this, ImageActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.action_settings:

                    Intent intent = new Intent(NewsActivity.this, SettingActivity.class);
                    startActivity(intent);
                    break;
            }
            item.setChecked(true);
            drawerLayout.closeDrawer(GravityCompat.START);

            return false;
        });


    }


    @Override
    public void getSerivceData() {
        Persenter.queryDB();
    }

    //得到数据库查询到的数据
    @Override
    public void getDB(List<NewsDBTable> newsDBTableList) {

        for (int i = 0; i < newsDBTableList.size(); i++) {
            fragments.add(NewsListFragment.newInstance(newsDBTableList.get(i).tableId));
            titles.add(newsDBTableList.get(i).tableName);
        }
        adapter = new TableAdapter(getSupportFragmentManager(),fragments,titles);
        view_pager.setAdapter(adapter);
        //绑定,会自动绑定
        table_layout.setupWithViewPager(view_pager);
        ViewUtils.dynamicSetTabLayoutMode(table_layout);
    }
}
