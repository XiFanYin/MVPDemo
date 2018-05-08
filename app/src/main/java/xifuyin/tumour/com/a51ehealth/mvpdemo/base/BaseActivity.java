package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by Administrator on 2018/5/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public Activity act;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设制竖屏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //隐藏掉系统原先的导航栏
        setContentView(getLayout2());

        initView2(savedInstanceState);

        initListener2();

        getData();
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

    public void getData() {
    }

    ;
}
