package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import xifuyin.tumour.com.a51ehealth.mvpdemo.dialog.LoadingDialog;

/**
 * Created by Administrator on 2018/5/4.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {

    public P Persenter;
    public Activity act;
    private LoadingDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        act = this;

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


    @Override
    public void showLoadingDialog() {
        dialog = new LoadingDialog(act);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();



    }

    @Override
    public void dissmassLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
