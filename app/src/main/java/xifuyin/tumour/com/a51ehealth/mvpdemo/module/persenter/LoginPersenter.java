package xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter;

import android.os.SystemClock;
import android.util.Log;

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
                .doOnSubscribe((disposable) -> {
                    View.showLoadingDialog();
                })
                .doOnError((throwable)-> {
     //这里的的错误有可能用户没有网，没有网需要显示没有网的页面提示，一个图片，一个重新请求的按钮
     // 也可能是API接口错误，这时候提示页面变成另外一个
     //即使这里我知道是用户是因为没有网导致的网络连接错误，我怎么去更新页面呢
     // （这个时候页面已经加载了，而我又不想再每个页面都写一遍没有网络，和加载错误的布局），这个请求错误，没有网络状态等一系列提示布局，能不能写一遍到Base里边
                })
                .doFinally(() -> {
                    View.dissmassLoadingDialog();
                })
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
