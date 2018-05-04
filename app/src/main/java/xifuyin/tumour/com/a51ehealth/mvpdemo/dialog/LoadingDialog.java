package xifuyin.tumour.com.a51ehealth.mvpdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import xifuyin.tumour.com.a51ehealth.mvpdemo.R;


public class LoadingDialog extends Dialog {

	public LoadingDialog(Context context) {
		super(context, R.style.LoadingDialogTheme);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commom_loading_layout);

	}


}

