package myapp.coursera.app3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

public class MainActivity extends Activity implements TextWatcher {

	private static final String TAG = "MainActivity";
	
	private EditText mName;
	private EditText mAddress;
	private EditText mDate;
	private EditText mTime;
	private EditText mEmail;
	private EditText mMyPhone;
	private EditText mDestPhone;
	private EditText mComment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mName = (EditText) findViewById(R.id.name);
		mAddress = (EditText) findViewById(R.id.address);
		mDate = (EditText) findViewById(R.id.date);
		mTime = (EditText) findViewById(R.id.time);
		mEmail = (EditText) findViewById(R.id.email);
		mMyPhone = (EditText) findViewById(R.id.myphone);
		mDestPhone = (EditText) findViewById(R.id.destphone);
		mComment = (EditText) findViewById(R.id.comment);

		mComment.addTextChangedListener(this);
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}

	@Override
	public void afterTextChanged(Editable s) {
		String message = s.toString();

		boolean messageValid = message.length() > 0;
		View view = findViewById(R.id.button1);
		boolean buttonVisible = view.getVisibility() == View.VISIBLE;
		if (buttonVisible == messageValid) {
			return;
		}
		Animation anim;
		if (messageValid == true) {
			view.setVisibility(View.VISIBLE);
			anim = AnimationUtils.makeInAnimation(this, true);
		} else {
			anim = AnimationUtils.makeOutAnimation(this, true);
			view.setVisibility(View.INVISIBLE);
		}
		view.startAnimation(anim);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void processForm(View button) {
		textMessage();
	}
	
	public void textMessage() {
		String name = mName.getText().toString();
		String address = mAddress.getText().toString();
		String date = mDate.getText().toString();
		String time = mTime.getText().toString();
		String email = mEmail.getText().toString();
		String myphone = mMyPhone.getText().toString();
		String destphone = mDestPhone.getText().toString();
		String comment = mComment.getText().toString();

		String message = name + " says: \n" + comment;
		message = message + "\nSender information: \n" + "Phone: " + myphone;

		if (email.length() > 0) {
			message = message + "\nEmail: " + email;
		}
		if (address.length() > 0) {
			message = message + "\nStreet Address: " + address;
		}
		if (date.length() > 0) {
			message = message + "\nDate sent: " + date;
		}
		if (time.length() > 0) {
			message = message + "\nTime sent: " + time;
		}
		
		Intent text = new Intent(Intent.ACTION_VIEW);
		text.setData(Uri.fromParts("sms", destphone, null));
		text.putExtra("sms_body", message);

		try {
			startActivity(text);
		} catch (Exception ex) {
			Log.e(TAG, "Error sending message", ex);
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
