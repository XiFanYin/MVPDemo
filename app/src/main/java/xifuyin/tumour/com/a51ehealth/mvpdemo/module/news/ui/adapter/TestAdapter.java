package xifuyin.tumour.com.a51ehealth.mvpdemo.module.news.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;

/**
 * Created by Administrator on 2018/5/11.
 */

public class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TestAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(android.R.id.text1, item);

    }
}
