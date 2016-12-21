package com.indian.uttara.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class NetworkStatusReceiver extends BroadcastReceiver{
	
	private Editor mPrefEditor;
	private SharedPreferences mSharedPreferences;
	
	@Override
	public void onReceive(final Context context, final Intent intent) {
		boolean s =isOnline();
		mSharedPreferences = context.getSharedPreferences("Uttara", Context.MODE_PRIVATE);
		mPrefEditor = mSharedPreferences.edit(); 
		mPrefEditor.putBoolean("NetworkAccess", s);
		mPrefEditor.commit();
		Toast.makeText(context, "Network" + s, Toast.LENGTH_SHORT).show();
	}
	
	public boolean isOnline() {
		Runtime runtime = Runtime.getRuntime();
		try {
			Process ipProcess = runtime.exec("/system/bin/ping -c 1 www.google.com");
			int exitValue = ipProcess.waitFor();
			return (exitValue == 0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}
}
