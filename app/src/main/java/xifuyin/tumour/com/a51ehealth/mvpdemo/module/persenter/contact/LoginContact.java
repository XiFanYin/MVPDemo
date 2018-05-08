package xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter.contact;

import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BasePresenter;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseView;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.model.LoginBean;

/**
 * Created by Administrator on 2018/5/4.
 */

public interface LoginContact {

    //这里继承BaseView，是为了限制在BasePresenterImpl里边的泛型是属于BaseView类型
    interface View extends BaseView {
        //接口向外传递数据
        void setData(LoginBean loginBean);
    }

    interface Persenter extends BasePresenter {

        //获取数据的方法名称规范
        void getData();

    }


}
