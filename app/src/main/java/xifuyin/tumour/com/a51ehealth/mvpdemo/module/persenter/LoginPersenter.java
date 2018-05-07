package xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter;

import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BasePresenterImpl;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.contact.LoginContact;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.model.LoginBean;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.RetrofitUtil;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.api.API;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.cache.CacheCompose;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.cache.CacheProviderUtils;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.cache.Provider;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.observer.BaseObserver;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.schedulers.RxSchedulers;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.utils.NetworkDetector;

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
                .compose(CacheCompose.cache("eee"))//如果需要缓存，添加这个操作符
                .compose(RxSchedulers.io_main())//切换线程的操作符
                .compose(LoadingDialog())//加载dialog的操作符
                .compose(LoadingErrorView())//没有网时候显示的Ui,理论上和需要缓存的转换不能同时存在
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);//添加流的控制
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        View.setData(loginBean);
                    }

                });


    }


}
