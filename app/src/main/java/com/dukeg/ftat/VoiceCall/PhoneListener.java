package com.dukeg.ftat.VoiceCall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.dukeg.ftat.LogUtils.logger;

/**
 * Created by johnyu on 28/12/2017.
 * This is a broadcast listener for voice call.
 */

class PhoneListener {

    private Context mContext;
    private PhoneBroadcastReceiver receiver;
    private PhoneStateListener mPhoneStateListener;

    PhoneListener(Context context) {
        mContext = context;
        receiver = new PhoneBroadcastReceiver();
    }

    void register(PhoneStateListener listener) {
        mPhoneStateListener = listener;
        if (receiver != null) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
            mContext.registerReceiver(receiver, filter);
            logger.d("listener register");
        }
    }

    void unregister() {
        if (receiver != null) {
            mContext.unregisterReceiver(receiver);
            logger.d("listener unregister");
        }
    }

    private class PhoneBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent != null) {

                TelephonyManager mTelephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                logger.d("intent ok");
                if (mTelephonyManager != null){
                    int TelephonyState = mTelephonyManager.getCallState();
                    switch (TelephonyState) {
                        //挂断
                        case TelephonyManager.CALL_STATE_IDLE:
                            mPhoneStateListener.onCallStateIDLE();
                            break;
                        //来电
                        case TelephonyManager.CALL_STATE_RINGING:
                            Log.i("DukeG", "RING.....");
                            String incomingNumber = intent.getStringExtra("incoming_number");
                            mPhoneStateListener.onCallStateRinging(incomingNumber);
                            break;
                        //接听
                        case TelephonyManager.CALL_STATE_OFFHOOK:
                            mPhoneStateListener.onCallStateOFFHOOK();
                            break;
                    }
                }
            }
            else {
                logger.d("intent failed");
            }
        }
    }


    public interface PhoneStateListener {

        void onCallStateIDLE();

        void onCallStateRinging(String incomingNumber);

        void onCallStateOFFHOOK();
    }
}


