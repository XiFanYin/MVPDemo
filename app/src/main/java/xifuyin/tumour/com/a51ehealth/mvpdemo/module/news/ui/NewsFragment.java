package xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseMvpLoadingFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.db.NewsDBTable;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.persenter.NewsDBPresenter;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.persenter.contact.NewsDBContact;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.MainActivity;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.TableAdapter;
import xifuyin.tumour.com.a51ehealth.mvpdemo.utils.ViewUtils;

/**
 * Created by Administrator on 2018/5/11.
 */

public class NewsFragment extends BaseMvpLoadingFragment<NewsDBPresenter> implements NewsDBContact.view {
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private ViewPager viewpager;
    private TableAdapter adapter;
    private TabLayout tableLayout;


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }


    @Override
    public int getLayoutId() {

        return R.layout.base_fragment_layout;
    }


    @Override
    protected void initView(View view) {
        viewpager = view.findViewById(R.id.viewpager);
        tableLayout = ((MainActivity) getActivity()).getTableLayout();
    }


    @Override
    protected void initListener() {

    }


    @Override
    protected void getSerivceData() {
        Persenter.queryDB();
    }


    //处理Menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.menu_news, menu);

    }

    //处理Menu的点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_channel_manage) {
            Toast.makeText(mContext, "添加频道被点击", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected NewsDBPresenter initPersenter() {
        return new NewsDBPresenter(this);
    }


    //得到数据库查询到的数据
    @Override
    public void getDB(List<NewsDBTable> newsDBTableList) {

        for (int i = 0; i < newsDBTableList.size(); i++) {
            fragments.add(NewsListFragment.newInstance(newsDBTableList.get(i).tableId));
            titles.add(newsDBTableList.get(i).tableName);
        }
        adapter = new TableAdapter(getChildFragmentManager(), fragments, titles);
        viewpager.setAdapter(adapter);
        //绑定,会自动绑定
        tableLayout.setupWithViewPager(viewpager);
        ViewUtils.dynamicSetTabLayoutMode(tableLayout);
    }
}
