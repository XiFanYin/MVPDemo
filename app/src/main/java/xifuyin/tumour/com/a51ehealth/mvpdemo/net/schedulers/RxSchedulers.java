package xifuyin.tumour.com.a51ehealth.mvpdemo.net.schedulers;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2017/8/26/026.
 */

public class RxSchedulers {


    public static <T> ObservableTransformer<T, T> io_main() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())//指定联网请求的线程，事件产生的线程
                        .observeOn(AndroidSchedulers.mainThread())//指定doOnTerminate的线程
                        ;
            }
        };
    }


}
