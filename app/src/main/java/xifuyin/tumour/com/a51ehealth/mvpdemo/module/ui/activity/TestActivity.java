package xifuyin.tumour.com.a51ehealth.mvpdemo.module.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseMvpLoadingActivity;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.model.LoginBean;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter.LoginPersenter;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter.contact.LoginContact;

public class TestActivity extends BaseMvpLoadingActivity<LoginPersenter> implements View.OnClickListener, LoginContact.View {

    private Button btn1;
    private TextView tv;


    @Override
    public int getLayout() {
        return R.layout.activity_test;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        btn1 = findViewById(R.id.btn1);
        tv = findViewById(R.id.tv);
    }


    @Override
    public void initListener() {
        btn1.setOnClickListener(this);
    }

    @Override
    protected LoginPersenter initPersenter() {
        return new LoginPersenter(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn1:

                Persenter.getData();

                break;

        }
    }

    @Override
    public void setData(LoginBean loginBean) {

        tv.setText(new Gson().toJson(loginBean));
    }


}