package com.example.sendsmsandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText edtPhoneNumber = (EditText) findViewById(R.id.editText1);
		final EditText edtContent = (EditText) findViewById(R.id.editText2);
		final Button btnSend = (Button) findViewById(R.id.button1);

		btnSend.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
				final String SmsNo = edtPhoneNumber.getText().toString();
				final String SmsContent = edtContent.getText().toString();
				final Uri uri = Uri.parse("smsto:" + SmsNo);
				final Intent sendMessage = new Intent(Intent.ACTION_SEND, uri);
				sendMessage.putExtra("sms_body", SmsContent);
				startActivity(sendMessage);

				if (sendMessage.resolveActivity(getPackageManager()) != null) {
					startActivity(sendMessage);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
