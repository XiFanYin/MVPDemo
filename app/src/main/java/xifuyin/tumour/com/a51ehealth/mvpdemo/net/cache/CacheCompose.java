package xifuyin.tumour.com.a51ehealth.mvpdemo.net.cache;

import io.reactivex.ObservableTransformer;
import io.rx_cache2.DynamicKey;
import io.rx_cache2.EvictDynamicKey;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.model.LoginBean;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.utils.NetworkDetector;

/**
 * Created by Administrator on 2018/5/7.
 * <p>
 * 这里使用具体的类型，不再使用泛型
 */

public class CacheCompose {

    public static ObservableTransformer<LoginBean, LoginBean> cache(String key_flag) {
        return upstream -> CacheProviderUtils
                .getInstance()
                .using(Provider.class)
                .getLogin(upstream, new DynamicKey(key_flag), new EvictDynamicKey(NetworkDetector.isNetworkReachable()));
    }
}
