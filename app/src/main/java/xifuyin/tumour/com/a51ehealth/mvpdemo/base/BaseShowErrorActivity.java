package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;
import xifuyin.tumour.com.a51ehealth.mvpdemo.dialog.LoadingDialog;

/**
 * Created by Administrator on 2018/5/7.
 */

public abstract class BaseShowErrorActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {


    public P Persenter;
    public Activity act;
    private LoadingDialog dialog;

    private RelativeLayout container;
    private RelativeLayout error_layout;
    private Button error_btn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        container = findViewById(R.id.container_layout);
        error_layout = findViewById(R.id.error_layout);
        error_btn = findViewById(R.id.error_btn);
        LayoutInflater.from(this).inflate(getLayout(), container, true);
        error_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onError();
            }
        });
        act = this;

        initView(savedInstanceState);

        initListener();

        Persenter = initPersenter();
    }

    protected abstract void onError();


    public abstract int getLayout();


    protected abstract void initView(Bundle savedInstanceState);


    protected abstract void initListener();


    protected abstract P initPersenter();


    @Override
    protected void onDestroy() {

        Persenter.detach();//在presenter中解绑释放view

        super.onDestroy();

    }


    @Override
    public void showLoadingDialog() {
        dialog = new LoadingDialog(act);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


    }

    @Override
    public void dissmassLoadingDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }


    @Override
    public void showErrorView() {
        container.setVisibility(View.GONE);
        error_layout.setVisibility(View.VISIBLE);
    }

    @Override
    public void dissmassErrorView() {

        container.setVisibility(View.VISIBLE);
        error_layout.setVisibility(View.GONE);
    }
}
