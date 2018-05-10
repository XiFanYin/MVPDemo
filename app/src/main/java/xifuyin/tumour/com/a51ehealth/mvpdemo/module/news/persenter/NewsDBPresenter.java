package xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.persenter;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.app.App;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BasePresenterImpl;
import xifuyin.tumour.com.a51ehealth.mvpdemo.db.NewsDBTable;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.persenter.contact.NewsDBContact;
import xifuyin.tumour.com.a51ehealth.mvpdemo.net.schedulers.RxSchedulers;
import xifuyin.tumour.com.a51ehealth.mvpdemo.utils.SPUtils;

;

/**
 * Created by Administrator on 2018/5/10.
 */

public class NewsDBPresenter extends BasePresenterImpl<NewsDBContact.view> implements NewsDBContact.presenter {


    public NewsDBPresenter(NewsDBContact.view View) {
        super(View);
    }


    @Override
    public void queryDB() {
        Observable.create(new ObservableOnSubscribe<List<NewsDBTable>>() {
            @Override
            public void subscribe(ObservableEmitter<List<NewsDBTable>> e) throws Exception {
                //数据库中插入Table数据
                if (!SPUtils.getBoolean("initTable", false)) {
                    List<String> channelName = Arrays.asList(App.getApplication().getResources().getStringArray(R.array.news_channel));
                    List<String> channelId = Arrays.asList(App.getApplication().getResources().getStringArray(R.array.news_channel_id));
                    for (int i = 0; i < channelName.size(); i++) {
                        NewsDBTable table = new NewsDBTable();
                        table.tableId = channelId.get(i);
                        table.tableName = channelName.get(i);
                        table.save();
                    }
                    SPUtils.saveBoolean("initTable", true);
                }
                //查询前三个，返回,后期改成动态的
                List<NewsDBTable> newsDBTables = new Select().from(NewsDBTable.class).queryList().subList(0, 3);
                e.onNext(newsDBTables);
            }
        })
                .compose(RxSchedulers.io_main())
                .subscribe(new Observer<List<NewsDBTable>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addDisposable(d);
                    }

                    @Override
                    public void onNext(List<NewsDBTable> newsDBTables) {
                        View.getDB(newsDBTables);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
