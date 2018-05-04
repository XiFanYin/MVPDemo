package xifuyin.tumour.com.a51ehealth.mvpdemo.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;


/**
 * Created by Administrator on 2018/2/6.
 */

public class App extends Application {
    //全局上下文
    private static App application;

    @Override
    public void onCreate() {
        super.onCreate();
        this.application = this;


        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }


    }

    /**
     * 提供全局上下文静态方法
     *
     * @return
     */
    public static App getApplication() {
        return application;
    }


}
