package xifuyin.tumour.com.a51ehealth.mvpdemo.base;


import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/5/4.
 */

public interface BasePresenter {

    //Activity关闭把view对象置为空
    void detach();


    //将网络请求的每一个disposable添加进入CompositeDisposable，再退出时候一并注销
    void addDisposable(Disposable subscription);


    //注销所有请求
    void unDisposable();


    //显示加载进度的提示
    <T> ObservableTransformer<T, T> LoadingDialog();


    //显示网络连接有问题的Ui
    <T> ObservableTransformer<T, T> LoadingErrorView();

}
