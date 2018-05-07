package xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BasePresenterImpl;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.contact.LoginContact;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.model.LoginBean;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.RetrofitUtil;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.api.API;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.cache.CacheCompose;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.observer.BaseObserver;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.schedulers.RxSchedulers;

/**
 * Created by Administrator on 2018/5/4.
 * <p>
 * 实现接口是为了规范方法名字，继承BasePersenter是为了处理Activity的内存泄漏,
 */

public class LoginPersenter extends BasePresenterImpl<LoginContact.View> implements LoginContact.Persenter {

    public LoginPersenter(LoginContact.View View) {
        super(View);
    }


    @Override
    public void getData() {

        RetrofitUtil
                .getInstance()
                .create(API.class)
                .Login("yinfeilong", "88888888")
                .subscribeOn(Schedulers.io())//指定联网请求的线程，事件产生的线程
                .compose(LoadingDialog())//加载dialog的操作符
                .compose(CacheCompose.cache("eee"))//如果需要缓存，添加这个操作符
                .observeOn(AndroidSchedulers.mainThread())//事件订阅的线程
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);//添加流的控制
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        View.setData(loginBean);
                        Log.e("rrrrrrrrrr3", Thread.currentThread().getName());
                    }

                });


    }


}
