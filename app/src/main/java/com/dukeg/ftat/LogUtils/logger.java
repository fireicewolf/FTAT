package com.dukeg.ftat.LogUtils;

import android.util.Log;

import com.dukeg.ftat.BuildConfig;

/**
 * Created by DukeG on 2017/12/18.
 * This is a logger for debug version.
 */

public class logger {
    private static final boolean isDebug = BuildConfig.DEBUG;

    private static final String TAG = "DukeG";

    public static void d (String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    public static void i (String msg) {
        if (isDebug) {
            Log.i(TAG, msg);
        }
    }
}
