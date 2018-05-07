package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import xifuyin.tumour.com.a51ehealth.mvpdemo.dialog.LoadingDialog;

/**
 * Created by Administrator on 2018/5/4.
 * <p>
 * 抽取BaseActivity，实现BaseView，规定统一的方法名字
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
        //在presenter中解绑释放view
        Persenter.detach();
        super.onDestroy();

    }

    /**
     * 加载中的dialog显示
     */
    @Override
    public void showLoadingDialog() {
        dialog = new LoadingDialog(act);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


    }

    /**
     * 加载完成的dialog消失
     */
    @Override
    public void dissmassLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    @Override
    public void showErrorView() {
        //这个基类没有封装这个需求，去控实现一下
    }

    @Override
    public void dissmassErrorView() {
        //这个基类没有封装这个需求，去控实现一下
    }
}
