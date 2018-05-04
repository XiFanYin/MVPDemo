package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/5/4.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public P Persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        initView(savedInstanceState);

        initListener();

        Persenter = initPersenter();
    }


    public abstract int getLayout();


    protected abstract void initView(Bundle savedInstanceState);


    protected abstract void initListener();


    protected abstract P initPersenter();


    @Override
    protected void onDestroy() {

        Persenter.detach();//在presenter中解绑释放view

        super.onDestroy();

    }
}
