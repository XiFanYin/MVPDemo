package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;

/**
 * Created by Administrator on 2018/5/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public Activity act;
    public ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设制竖屏

        setContentView(getLayout2());

        initView2(savedInstanceState);

        initBar();

        initListener2();

        getSerivceData();



    }

    public void initBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }


    public int getLayout2() {
        return getLayout();
    }

    public abstract int getLayout();


    public void initView2(Bundle savedInstanceState) {
        initView(savedInstanceState);
    }

    public abstract void initView(Bundle savedInstanceState);


    protected void initListener2() {
        initListener();
    }

    protected abstract void initListener();

    public void getSerivceData() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImmersionBar.destroy();
    }
}
