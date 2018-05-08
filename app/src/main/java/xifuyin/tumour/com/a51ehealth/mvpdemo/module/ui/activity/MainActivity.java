package xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseActivity;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.fragment.FiveFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.fragment.FourFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.fragment.OneFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.fragment.ThereFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.fragment.TwoFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.weight.bottomview.BottomNavigationViewEx;
import xifuyin.tumour.com.a51ehealth.mvpdemo.weight.bottomview.NoSlidingViewPaper;

/**
 * Created by Administrator on 2018/5/8.
 */

public class MainActivity extends BaseActivity {

    private NoSlidingViewPaper mViewPager;
    private BottomNavigationViewEx bnve;
    private final ArrayList<Fragment> fgLists = new ArrayList<>(5);

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mViewPager = findViewById(R.id.content);
        bnve = findViewById(R.id.bnve);
    }

    @Override
    protected void initListener() {
        //开启放大动画
        bnve.enableAnimation(false);
        //关闭所有动画
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);

        //底部四个按钮对应的四个Fragment，其中 TwoFragment 中想去实现聚合会话列表，点进去进入会话页面
        fgLists.add(new OneFragment());
        fgLists.add(new TwoFragment());
        fgLists.add(new ThereFragment());
        fgLists.add(new FourFragment());
        fgLists.add(new FiveFragment());

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
        mViewPager.setOffscreenPageLimit(4); //预加载
        // 绑定ViewPager
        bnve.setupWithViewPager(mViewPager);

    }
}
