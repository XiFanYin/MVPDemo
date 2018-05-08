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

public abstract class BaseMvpLoadingActivity<P extends BasePresenter> extends BaseActivity implements BaseView {

    public P Persenter;
    private LoadingDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Persenter = initPersenter();
    }

    protected abstract P initPersenter();




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


    @Override
    protected void onDestroy() {
        //在presenter中解绑释放view
        if (Persenter != null) {
            Persenter.detach();
        }
        super.onDestroy();

    }
}
