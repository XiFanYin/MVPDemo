package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/5/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public Activity act;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = this;
        setContentView(getLayout2());

        initView2(savedInstanceState);
        initListener2();
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
}
