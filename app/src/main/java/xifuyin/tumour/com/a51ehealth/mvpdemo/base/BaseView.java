package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

/**
 * Created by Administrator on 2018/5/4.
 */

public interface BaseView {

    //显示加载提示
    void showLoadingDialog();

    //隐藏加载提示
    void dissmassLoadingDialog();

    //显示错误提示布局
    void showErrorView();

    //隐藏显示错误提示布局
    void dissmassErrorView();

}
