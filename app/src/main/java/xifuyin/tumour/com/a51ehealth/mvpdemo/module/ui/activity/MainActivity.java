package xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.gyf.barlibrary.ImmersionBar;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseActivity;

/**
 * Created by Administrator on 2018/5/8.
 */

public class MainActivity extends BaseActivity {


    private NavigationView mNavigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mNavigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);

    }

    @Override
    public void initBar() {
        super.initBar();
        mImmersionBar.titleBar(toolbar).init();
    }

    @Override
    protected void initListener() {

        mNavigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.action_news:

                    break;
                case R.id.action_video:

                    break;
                case R.id.action_photo:

                    break;
                case R.id.action_settings:

                    break;
            }
            item.setChecked(true);
            drawerLayout.closeDrawer(GravityCompat.START);

            return false;
        });


    }
}
