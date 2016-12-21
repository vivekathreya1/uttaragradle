package com.indian.uttara.commonui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.indian.uttara.R;
import com.indian.uttara.main.view.MainActivity;

public class NoNetwork extends AppCompatActivity {
	
	TextView mRetry;
	SharedPreferences mSharedPreferences;
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.no_internet);
		mSharedPreferences = getSharedPreferences("Uttara", Context.MODE_PRIVATE);
		mListeners();
	
	}
	
	private void mListeners(){
		mRetry = (TextView) findViewById(R.id.noInternetButtonText);
		
		mRetry.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if(mSharedPreferences.getBoolean("NetworkAccess", false)){
				Intent i = new Intent(NoNetwork.this, MainActivity.class);
				startActivity(i);
				finish();
				}
			}
		});
		
	}

}
