package com.indian.uttara.commonui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;

import com.indian.uttara.R;

/**
 * Created by Vivekathreya on 9/5/2016.
 */
public class UIUtil {

    private static ProgressDialog mProgressDialog;
    private static Object mObject = new Object();

    public static void startProgressDialog(Context context, String message) {
        synchronized (mObject) {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, "", message);
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setCancelable(false);
            }
        }
    }

    public static void stopProgressDialog(Context context) {
        synchronized (mObject) {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
                mProgressDialog = null;
            }
        }
    }



    public static void startProgressBar(ProgressBar mProgressBar) {
        synchronized (mObject) {
            if (mProgressBar == null) {
                mProgressBar.setIndeterminate(true);
                mProgressBar.setVisibility(View.VISIBLE);
            }
        }
    }

    public static void stopProgressBar(ProgressBar mProgressBar) {
        synchronized (mObject) {
            if (mProgressBar != null && mProgressBar.isShown()) {
                mProgressBar.setVisibility(View.GONE);
            }
        }
    }
}
