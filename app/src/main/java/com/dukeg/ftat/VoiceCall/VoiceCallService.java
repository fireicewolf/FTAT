package com.dukeg.ftat.VoiceCall;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.dukeg.ftat.LogUtils.logger;

/**
 * Created by DukeG on 28/12/2017.
 * This is a service for voice call.
 */

public class VoiceCallService extends Service {

    private PhoneListener phoneListener;
    @Override
    public void onCreate() {
        super.onCreate();
        phoneListener = new PhoneListener(this);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        phoneListener.register(new PhoneListener.PhoneStateListener() {
            @Override
            public void onCallStateIDLE() {

            }
            @Override
            public void onCallStateRinging(String incomingNumber) {
                logger.d(incomingNumber);
            }

            @Override
            public void onCallStateOFFHOOK() {

            }
        });
        logger.d("Service start");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if (phoneListener != null) {
            phoneListener.unregister();
        }
        logger.d("Service stop");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
