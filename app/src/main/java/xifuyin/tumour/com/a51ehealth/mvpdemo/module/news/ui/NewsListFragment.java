package xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.app.App;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.ui.adapter.TestAdapter;

/**
 * Created by Administrator on 2018/5/10.
 */

public class NewsListFragment extends BaseFragment {

    protected static final String NEWS_ID = "news_id";
    private String mNewsId;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mNewsId = getArguments().getString(NEWS_ID);
        }
    }

    public static NewsListFragment newInstance(String newsId) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NEWS_ID, newsId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected void initView(View view) {
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        recyclerView = view.findViewById(R.id.recyclerView);


    }

    @Override
    protected void initListener() {

        List<String> channelId = Arrays.asList(App.getApplication().getResources().getStringArray(R.array.news_channel_id));
        //设置布局为垂直布局
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        TestAdapter adapter = new TestAdapter(android.R.layout.simple_list_item_1, channelId);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        swipeRefreshLayout.setEnabled(true);
                    }
                }, 10000);
            }
        });
    }


    @Override
    protected void getSerivceData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
