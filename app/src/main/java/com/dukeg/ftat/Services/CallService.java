package com.dukeg.ftat.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.dukeg.ftat.Utils.Log.logger;
import com.dukeg.ftat.BroadcastReceiver.PhoneListener;

/**
 * Created by DukeG on 28/12/2017.
 * This is a service for voice call.
 */

public class CallService extends Service {

    private PhoneListener phoneListener;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        phoneListener = new PhoneListener(this);
        phoneListener.register(new PhoneListener.PhoneStateListener() {
            @Override
            public void onCallStateIDLE() {

            }
            @Override
            public void onCallStateRinging(String incomingNumber) {
                logger.i("Incoming call number is "+incomingNumber);
            }

            @Override
            public void onCallStateOFFHOOK() {

            }
        });
        logger.d("Call listener service start");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if (phoneListener != null) {
            phoneListener.unregister();
        }
        logger.d("Call listener Service stop");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
