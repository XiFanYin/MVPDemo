package xifuyin.tumour.com.a51ehealth.mvpdemo.app;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;
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

        //初始化数据库
        FlowManager.init(this);
        /*内存泄漏*/
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
