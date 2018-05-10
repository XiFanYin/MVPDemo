package xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.app.App;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseFragment;

/**
 * Created by Administrator on 2018/5/10.
 */

public class NewsListFragment extends BaseFragment {

    protected static final String NEWS_ID = "news_id";
    private String mNewsId;
    private TextView tv;


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
        tv = view.findViewById(R.id.tv);
    }
    @Override
    protected void initListener() {
        tv.setText(mNewsId);
    }


    @Override
    protected void getSerivceData() {

    }
}
