package xifuyin.tumour.com.a51ehealth.mvpdemo.net.cache;

import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import xifuyin.tumour.com.a51ehealth.mvpdemo.app.App;


/**
 * Created by Administrator on 2018/2/7.
 */

public class CacheProviderUtils {

    private static CacheProviderUtils mInstance;
    private final RxCache persistence;


    /**
     * 单例模式，生成该类对象
     *
     * @return
     */
    public static CacheProviderUtils getInstance() {
        if (mInstance == null) {
            synchronized (CacheProviderUtils.class) {
                mInstance = new CacheProviderUtils();
            }
        }

        return mInstance;
    }


    public CacheProviderUtils() {
        persistence = new RxCache.Builder().persistence(App.getApplication().getFilesDir(), new GsonSpeaker());
    }


    public <T> T using(Class<T> cache) {

        return persistence.using(cache);
    }

}
