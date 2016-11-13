package hersh.coldplay.vivavidaplay;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;


public class MainActivity extends Activity {
	MediaPlayer viva; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viva = MediaPlayer.create(this, R.raw.vivalavidasong);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public void openLyrics(View v) {
    	String url = "http://www.azlyrics.com/lyrics/coldplay/vivalavida.html";
    	Intent i = new Intent(Intent.ACTION_VIEW);
    	i.setData(Uri.parse(url));
    	startActivity(i);
    }
    
    public void openInfo(View v) {
    	String url = "http://en.wikipedia.org/wiki/Viva_la_Vida";
    	Intent i = new Intent(Intent.ACTION_VIEW);
    	i.setData(Uri.parse(url));
    	startActivity(i);
    }
    
    public void onToggleClicked(View v) {
        // Is the toggle on
        boolean on = ((ToggleButton) v).isChecked();
        if (on) {
            viva.start();
        } else {
            viva.pause();
        }
    }
    
    public void stop(View v) {
        //viva.stop();
    }
}
