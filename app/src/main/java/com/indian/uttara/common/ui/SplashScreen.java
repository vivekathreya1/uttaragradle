package com.indian.uttara.common.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.indian.uttara.R;
import com.indian.uttara.api.model.ServicesRepo;
import com.indian.uttara.api.ApiServiceInterface;
import com.indian.uttara.api.RestClient;
import com.indian.uttara.common.database.DbHelper;
import com.indian.uttara.main.view.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vivekathreya on 9/4/2016.
 */
public class SplashScreen extends Activity {

    private final int DISPLAY_TIME = 3000;
    private boolean isBackpressed = false;
    private final static int MY_PERMISSIONS_REQUEST_ALL_PERMISSION = 1;

    @Override
    @TargetApi(Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        List<String> checkDeniedPermissions = new ArrayList<>();
        if (!((int) Build.VERSION.SDK_INT < 23)) {
            validatePermissions(checkDeniedPermissions, Manifest.permission.ACCESS_NETWORK_STATE);
            validatePermissions(checkDeniedPermissions, Manifest.permission.INTERNET);
            validatePermissions(checkDeniedPermissions, Manifest.permission.ACCESS_FINE_LOCATION);
            validatePermissions(checkDeniedPermissions, Manifest.permission.ACCESS_COARSE_LOCATION);
            validatePermissions(checkDeniedPermissions, Manifest.permission.READ_SMS);
            validatePermissions(checkDeniedPermissions, Manifest.permission.RECEIVE_SMS);
            validatePermissions(checkDeniedPermissions, Manifest.permission.READ_EXTERNAL_STORAGE);

            if (checkDeniedPermissions.size() > 0) {
                requestPermissions(checkDeniedPermissions.toArray(new String[checkDeniedPermissions.size()]), MY_PERMISSIONS_REQUEST_ALL_PERMISSION);
            }else{
                callSplash();
            }
        } else {
            callSplash();
        }


    }

    private void callSplash() {  //TODO this has been called way to many times and the activity is being created many times
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        UIUtil.startProgressBar(progressBar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


//                if (new NetworkStatusReceiver().isOnline()) {
////                    mGpsTracking = new GPSTracking(SplashScreen.this);
////                    Double latitude = mGpsTracking.getLatitude();
////                    Double longitude = mGpsTracking.getLongitude();
////                    LocationAddress.getAddressFromLocation(latitude, longitude, getApplicationContext(), mhandler);
////                    RetrofitCall();
//
//                    getServicesList();
//                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
//                    finish();
//                } else {
//                      startActivity(new Intent(SplashScreen.this, NoNetwork.class));
//                    finish();
//                }
                UIUtil.stopProgressBar(progressBar);

                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();

            }
        }, DISPLAY_TIME);
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void validatePermissions(List<String> addPermissionToList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            addPermissionToList.add(permission);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ALL_PERMISSION: {
                Map<String, Integer> setAllPermission = new HashMap<>();
                setAllPermission.put(Manifest.permission.ACCESS_NETWORK_STATE, PackageManager.PERMISSION_GRANTED);
                setAllPermission.put(Manifest.permission.INTERNET, PackageManager.PERMISSION_GRANTED);
                setAllPermission.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                setAllPermission.put(Manifest.permission.ACCESS_COARSE_LOCATION, PackageManager.PERMISSION_GRANTED);
                setAllPermission.put(Manifest.permission.READ_SMS, PackageManager.PERMISSION_GRANTED);
                setAllPermission.put(Manifest.permission.RECEIVE_SMS, PackageManager.PERMISSION_GRANTED);
                setAllPermission.put(Manifest.permission.READ_EXTERNAL_STORAGE, PackageManager.PERMISSION_GRANTED);

                for (int i = 0; i < permissions.length; i++) {
                    setAllPermission.put(permissions[i], grantResults[i]);
                    if (setAllPermission.get(Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED
                            && setAllPermission.get(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED
                            && setAllPermission.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                            && setAllPermission.get(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                            && setAllPermission.get(Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED
                            && setAllPermission.get(Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED
                            && setAllPermission.get(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        callSplash();
                    } else {
                        // TODO show popup to enable permissions
                        Toast.makeText(SplashScreen.this,"Permisiions", Toast.LENGTH_SHORT).show();
                    }
                }

                return;
            }
        }
    }

    private void getServicesList(){


        ApiServiceInterface apiServices = RestClient.createService(ApiServiceInterface.class);
        Call<List<ServicesRepo>> servicesList = apiServices.getAllServices();

        servicesList.enqueue(new Callback<List<ServicesRepo>>() {
            @Override
            public void onResponse(Call<List<ServicesRepo>> call, Response<List<ServicesRepo>> response) {
                if(response.body() != null && response.isSuccessful()){
                    new DbHelper(SplashScreen.this).insertAllServicesList(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<ServicesRepo>> call, Throwable t) {

            }
        });


    }
}
