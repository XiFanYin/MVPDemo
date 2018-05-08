package xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.fragment;

import android.view.View;
import android.widget.TextView;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseFragment;

/**
 * Created by Administrator on 2018/5/8.
 */

public class FourFragment extends BaseFragment {


    @Override
    public int getLayoutId() {
        return R.layout.fragment;
    }

    @Override
    protected void initView(View view) {
        TextView tv = view.findViewById(R.id.tv);
        tv.setText("FourFragment");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void getData(boolean hasNetWork) {

    }


}
