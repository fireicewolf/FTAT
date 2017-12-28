package com.dukeg.ftat.VoiceCall;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by DukeG on 28/12/2017.
 * This is a service for voice call.
 */

public class VoiceCallService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
