package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;

/**
 * Created by Administrator on 2018/5/7.
 * <p>
 * <p>
 * 带有加载失败的UI
 */

public abstract class BaseMvpShowErrorActivity<P extends BasePresenter> extends BaseMvpLoadingActivity<P> implements BaseView {

    private RelativeLayout container;
    private RelativeLayout error_layout;
    private Button error_btn;


    @Override
    public int getLayout2() {
        return R.layout.base_layout;
    }


    @Override
    public void initView2(Bundle savedInstanceState) {
        container = findViewById(R.id.container_layout);
        error_layout = findViewById(R.id.error_layout);
        error_btn = findViewById(R.id.error_btn);
        LayoutInflater.from(this).inflate(getLayout(), container, true);

        initView(savedInstanceState);
    }


    @Override
    protected void initListener2() {
        error_btn.setOnClickListener((view -> {
            onRetry();
        }));
        initListener();
    }

    protected abstract void onRetry();


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
