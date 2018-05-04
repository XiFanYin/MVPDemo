package xifuyin.tumour.com.a51ehealth.mvpdemo.net.api;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.model.LoginBean;


/**
 * Created by yinfeilong on 2017/8/25.
 */

public interface API {


    @FormUrlEncoded
    @POST("accountLogin.html")
    Observable<LoginBean> Login(@Field("loginname") String loginname, @Field("password") String password);


}
