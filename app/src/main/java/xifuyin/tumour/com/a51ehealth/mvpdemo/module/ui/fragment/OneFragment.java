package xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseMvpShowErrorFragment;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.model.LoginBean;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter.LoginPersenter;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter.contact.LoginContact;

/**
 * Created by Administrator on 2018/5/8.
 */

public class OneFragment extends BaseMvpShowErrorFragment<LoginPersenter> implements LoginContact.View {

    private TextView tv;

    @Override
    protected LoginPersenter initPersenter() {
        return new LoginPersenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView(View view) {

        tv = view.findViewById(R.id.tv);
    }

    @Override
    protected void initListener() {

    }


    @Override
    protected void getData() {

        Persenter.getData();

    }

    @Override
    protected void onRetry() {
        Persenter.getData();
    }

    @Override
    public void setData(LoginBean loginBean) {
        tv.setText(new Gson().toJson(loginBean));
    }
}
