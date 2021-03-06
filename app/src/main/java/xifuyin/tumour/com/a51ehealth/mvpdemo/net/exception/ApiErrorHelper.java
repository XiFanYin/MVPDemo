package xifuyin.tumour.com.a51ehealth.mvpdemo.net.exception;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;


/**
 * Created by Administrator on 2017/8/12/012.
 * <p>
 * 统一错误的处理类
 * <p>
 * http://www.jianshu.com/p/c105a4177982
 */

public class ApiErrorHelper {


    public static void handleCommonError(Context context, Throwable e) {

        if (e instanceof ConnectException) {

        } else if (e instanceof SocketTimeoutException) {

        } else if (e instanceof ApiException) {
            //ApiException处理
            ApiException exception = (ApiException) e;

            Toast.makeText(context, exception.getMessage(), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(context, "本地未知错误，一般都是解析数据格式错误"+e.getMessage(), Toast.LENGTH_SHORT).show();

        }


    }
}


