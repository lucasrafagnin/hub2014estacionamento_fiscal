package com.mmidgard.hubestacionamento_fiscal;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GlobalActivity extends Activity {

	public void adicionarRecarga() {
		Button recarregar = (Button)findViewById(R.id.recarregar);
		recarregar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(GlobalActivity.this);
				dialog.setTitle("Login Paypal");
				dialog.setContentView(R.layout.recarga);
				dialog.setCancelable(true);
				dialog.show();
			}
		});

	}
}
