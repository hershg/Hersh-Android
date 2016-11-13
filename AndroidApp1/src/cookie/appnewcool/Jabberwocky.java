package cookie.appnewcool;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

public class Jabberwocky extends Activity {

	WebView myWebView;
	MediaPlayer lethergo; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jabberwocky);
		
		myWebView = (WebView) findViewById(R.id.webView1);
        myWebView.loadUrl("file:///android_asset/jabberwocky.html");
        
        lethergo = MediaPlayer.create(this, R.raw.let_her_go);
        lethergo.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jabberwocky, menu);
		return true;
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
	
	public void onPause() {
		if(lethergo.isPlaying()) {
			lethergo.pause();
		}
		super.onPause();
	}
	
	public void onResume() {
		if(!lethergo.isPlaying()) {
			lethergo.start();
		}
		super.onPause();
	}
	
	public void WikiPage(View v) {
    	String url = "https://en.wikipedia.org/wiki/Jabberwocky";
    	Intent i = new Intent(Intent.ACTION_VIEW);
    	i.setData(Uri.parse(url));
    	startActivity(i);
    }
	public void Image(View v) {
    	myWebView.loadUrl("file:///android_asset/jabberwocky.jpg");
    }
}
