package xifuyin.tumour.com.a51ehealth.mvpdemo.net.observer;


import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import xifuyin.tumour.com.a51ehealth.mvpdemo.app.App;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.exception.ApiErrorHelper;


/**
 * Created by Administrator on 2017/8/26/026.
 */

public abstract class BaseObserver <T> implements Observer <T> {


    @Override
    public abstract void onNext(@NonNull T t) ;

    @Override
    public void onError(@NonNull Throwable e) {
        //异常，统一交给该处理的类去处理
        ApiErrorHelper.handleCommonError(App.getApplication(),e);

        Log.e("rrrrrrrrerror",e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
