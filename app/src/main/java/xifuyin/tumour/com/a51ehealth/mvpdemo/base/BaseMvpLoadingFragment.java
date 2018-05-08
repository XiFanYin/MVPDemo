package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xifuyin.tumour.com.a51ehealth.mvpdemo.dialog.LoadingDialog;

/**
 * Created by Administrator on 2018/5/8.
 */

public abstract class BaseMvpLoadingFragment<P extends BasePresenter> extends BaseFragment implements BaseView {

    private LoadingDialog dialog;
    public P Persenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Persenter = initPersenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    protected abstract P initPersenter();


    @Override
    public void onDestroyView() {
        //在presenter中解绑释放view
        if (Persenter != null) {
            Persenter.detach();
        }
        isViewInitiated = false;
        isDataRequested = false;
        super.onDestroyView();
    }

    /**
     * 加载中的dialog显示
     */
    @Override
    public void showLoadingDialog() {
        dialog = new LoadingDialog(mContext);
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
