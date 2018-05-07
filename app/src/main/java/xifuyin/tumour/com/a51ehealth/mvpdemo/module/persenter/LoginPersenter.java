package xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter;

import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BasePresenterImpl;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.contact.LoginContact;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.model.LoginBean;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.RetrofitUtil;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.api.API;
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
                .compose(RxSchedulers.io_main())
                .compose(LoadingDialog())
                .compose(LoadingErrorView())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        View.setData(loginBean);
                    }

                });
    }
}
