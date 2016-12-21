package com.indian.uttara.common;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Vivekathreya on 9/5/2016.
 */
public class Util {

    private static boolean isInternet = false;

    public  static boolean isOnline(){
        try {
          isInternet = new checkOnlineAsync().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return isInternet;
    }

    public static class checkOnlineAsync extends AsyncTask<Integer, Void, Boolean>{

        @Override
        protected Boolean doInBackground(Integer... integers) {
            Runtime runtime = Runtime.getRuntime();
            try {
                Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
                int exitValue = ipProcess.waitFor();
                return (exitValue == 0);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            isInternet = aBoolean;
        }
    }
}
