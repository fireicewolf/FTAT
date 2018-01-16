package com.dukeg.ftat.Utils.Log;

import android.util.Log;

import com.dukeg.ftat.BuildConfig;

/**
 * Created by DukeG on 2017/12/18.
 * This is a logger for debug version.
 */

public class logger {
    private static final boolean isDebug = BuildConfig.DEBUG;

    private static final String InformationTAG = "FTAT logger(Event)";

    private static final String DebugTAG = "FTAT logger(Debug)";

    public static void d (String msg) {
        if (isDebug) {
            Log.d(DebugTAG, msg);
        }
    }

    public static void i (String msg) {
        Log.i(InformationTAG, msg);
    }
}
