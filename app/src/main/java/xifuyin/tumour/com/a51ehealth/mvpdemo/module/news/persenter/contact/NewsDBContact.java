package xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.persenter.contact;

import java.util.List;

import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BasePresenter;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseView;
import xifuyin.tumour.com.a51ehealth.mvpdemo.db.NewsDBTable;

/**
 * Created by Administrator on 2018/5/10.
 */

public interface NewsDBContact {


    interface view extends BaseView {
        //把数据库查询到的数据通过接口传递出去
        void getDB(List<NewsDBTable> newsDBTableList);

    }


    interface presenter extends BasePresenter {
        //具体去实现的查询代码
        void queryDB();
    }


}
