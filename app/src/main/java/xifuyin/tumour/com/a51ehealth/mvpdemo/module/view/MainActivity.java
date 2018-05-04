package xifuyin.tumour.com.a51ehealth.mvpdemo.module.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;
import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.base.BaseActivity;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.contact.LoginContact;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.model.LoginBean;
import xifuyin.tumour.com.a51ehealth.mvpdemo.module.persenter.LoginPersenter;

public class MainActivity extends BaseActivity<LoginPersenter> implements View.OnClickListener, LoginContact.View {

    private Button btn1;
    private TextView tv;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
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
