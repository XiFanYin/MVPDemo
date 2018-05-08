package xifuyin.tumour.com.a51ehealth.mvpdemo.base;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;

/**
 * Created by Administrator on 2018/5/8.
 */

public abstract class BaseMvpShowErrorFragment<P extends BasePresenter> extends BaseMvpLoadingFragment<P> {

    private RelativeLayout container;
    private RelativeLayout error_layout;
    private Button error_btn;

    public int getLayoutId2() {
        return R.layout.base_layout;
    }


    protected void initListener2() {
        error_btn.setOnClickListener((view -> {
            onRetry();
        }));
        initListener();
    }




    protected void initView2(View mView) {
        container = mView.findViewById(R.id.container_layout);
        error_layout = mView.findViewById(R.id.error_layout);
        error_btn = mView.findViewById(R.id.error_btn);
        LayoutInflater.from(mContext).inflate(getLayoutId(), container, true);
        initView(mView);
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
