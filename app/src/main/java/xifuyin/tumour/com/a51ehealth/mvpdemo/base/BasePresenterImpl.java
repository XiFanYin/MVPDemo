package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/5/4.
 * <p>
 * 实现接口是为了规范方法名字,这里边处理V的内存泄漏问题，
 * 这里的内存泄漏是因为用接口传递参数，导致匿名内部类持有外部类引用，而这个外部类就是Activity，所以在activiry销毁的时候，要释放到内部类
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter {

    public V View;
    private CompositeDisposable mCompositeDisposable;

    public BasePresenterImpl(V View) {
        this.View = View;
    }


    @Override
    public void detach() {
        unDisposable();
        this.View = null;

    }


    /**
     * 将Disposable添加
     *
     * @param subscription
     */
    @Override
    public void addDisposable(Disposable subscription) {
        //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);

    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();
            mCompositeDisposable =null;
        }
    }
}
