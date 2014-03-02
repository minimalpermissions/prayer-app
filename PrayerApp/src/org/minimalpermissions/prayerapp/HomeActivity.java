package org.minimalpermissions.prayerapp;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class HomeActivity extends Activity implements OnEditorActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_home);
        
        EditText input = (EditText) this.findViewById(R.id.home_input);
        input.setOnEditorActionListener(this);
        
        this.fetchContacts();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
    public void fetchContacts() {

		final Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
		final String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
		final String PHOTO_ID = ContactsContract.Contacts.PHOTO_ID;
		
		ContentResolver contentResolver = this.getContentResolver();

		Cursor c = contentResolver.query(CONTENT_URI, null,null, null, null);	

		Util.d("COUNT: %d", c.getCount());
		
		// Loop for every contact in the phone
		if (c.getCount() > 0) {
			
			c.moveToFirst();
			
			while (!c.isAfterLast()) {
				Log.d("PRAYER", c.getString(c.getColumnIndex( DISPLAY_NAME )));
				c.moveToNext();
			}
		}
	}


	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		return false;
	}
    
}
