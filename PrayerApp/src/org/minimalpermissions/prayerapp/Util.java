package org.minimalpermissions.prayerapp;

import java.util.Locale;

import android.util.Log;

final class Util {
	private static final String TAG = "PRAYER";
	
	private Util() {}
	
	static void d(String format, Object...args) {
		Log.d(TAG, String.format(Locale.US, format, args));
	}
	
}
