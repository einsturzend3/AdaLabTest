package com.gabr1.adalab1;

import com.gabr1.models.ApplicationDataContext;
import com.gabr1.models.User;
import com.mobandme.ada.exceptions.AdaFrameworkException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private Button btnEnviar, btnBorrar;
	private EditText campoUserName, campoPass, campoEmail;
	private ApplicationDataContext dataContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialize();
	}

	public void initialize() {
		btnEnviar = (Button) findViewById(R.id.btnSend);
		btnBorrar = (Button) findViewById(R.id.btnClean);
		campoUserName = (EditText) findViewById(R.id.campoUserName);
		campoPass = (EditText) findViewById(R.id.campoPass);
		campoEmail = (EditText) findViewById(R.id.campoEmail);

		btnEnviar.setOnClickListener(this);
		btnBorrar.setOnClickListener(this);

	}

	public void save(View view) {
		User user = new User();
		user.setUserName(campoUserName.getText().toString());
		user.setPassword(campoPass.getText().toString());
		user.setEmail(campoEmail.getText().toString());

		dataContext.getUsersSet().add(user);
		try {
			dataContext.getUsersSet().save();
			Toast.makeText(getBaseContext(), "Usuario agregado correctamente!",
					Toast.LENGTH_SHORT).show();
		} catch (AdaFrameworkException e) {
			Log.e("Error: ", "Error salvando user: " + e.getMessage());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnSend:
			save(v);
			break;
		case R.id.btnClean:
			campoUserName.setText("");
			campoPass.setText("");
			campoEmail.setText("");
			break;
		}

	}

}
