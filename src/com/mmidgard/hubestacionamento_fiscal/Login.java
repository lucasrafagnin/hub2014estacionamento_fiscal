package com.mmidgard.hubestacionamento_fiscal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);

		Button logar = (Button)findViewById(R.id.logar);
		logar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText usuario = (EditText)findViewById(R.id.usuario);
				EditText senha = (EditText)findViewById(R.id.senha);

				String sUsuario = usuario.getText().toString();
				String sSenha = senha.getText().toString();

				if (sUsuario.equals("admin") && sSenha.equals("admin")) {
					Intent i = new Intent(Login.this, Inicial.class);
					startActivity(i);
					finish();
				} else {
					Toast.makeText(Login.this, "Login e/ou senha incorreto(s)", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}
