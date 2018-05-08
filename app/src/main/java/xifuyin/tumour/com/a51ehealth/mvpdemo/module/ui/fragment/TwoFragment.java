package xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseFragment;

/**
 * Created by Administrator on 2018/5/8.
 */

public class TwoFragment extends BaseFragment {


    @Override
    public int getLayoutId() {
        return R.layout.fragment;
    }

    @Override
    protected void initView(View view) {
        TextView tv = view.findViewById(R.id.tv);
        tv.setText("TwoFragment");
    }

    @Override
    protected void initListener() {

        Log.e("rrrrrrr","TwoFragmentinitListener");
    }

    @Override
    protected void getData() {

        Log.e("rrrrrrr","TwoFragmentgetData");
    }



}
