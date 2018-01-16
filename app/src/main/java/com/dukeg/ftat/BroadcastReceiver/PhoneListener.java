package com.dukeg.ftat.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;

import com.dukeg.ftat.Utils.Log.logger;

/**
 * Created by DukeG on 28/12/2017.
 * This is a broadcast listener for voice call.
 */

public class PhoneListener {

    private Context mContext;
    private PhoneBroadcastReceiver receiver;
    private PhoneStateListener mPhoneStateListener;

    public PhoneListener(Context context) {
        mContext = context;
        receiver = new PhoneBroadcastReceiver();
    }

    public void register(PhoneStateListener listener) {
        mPhoneStateListener = listener;
        if (receiver != null) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
            mContext.registerReceiver(receiver, filter);
            logger.d("listener register");
        }
    }

    public void unregister() {
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
                logger.d("Phone broadcast receiver intent ok");

                if (mTelephonyManager != null){
                    int TelephonyState = mTelephonyManager.getCallState();
                    switch (TelephonyState) {
                        //挂断
                        case TelephonyManager.CALL_STATE_IDLE:
                            mPhoneStateListener.onCallStateIDLE();
                            logger.i("Call state is idle.....");
                            break;
                        //来电
                        case TelephonyManager.CALL_STATE_RINGING:
                            logger.i("Call state is ringing.....");
                            String incomingNumber = intent.getStringExtra("incoming_number");
                            mPhoneStateListener.onCallStateRinging(incomingNumber);
                            break;
                        //接听
                        case TelephonyManager.CALL_STATE_OFFHOOK:
                            logger.i("Call state is off hook.....");
                            mPhoneStateListener.onCallStateOFFHOOK();
                            break;
                    }
                }
            }
            else {
                logger.d("Phone broadcast receiver intent return null");
            }
        }
    }


    public interface PhoneStateListener {

        void onCallStateIDLE();

        void onCallStateRinging(String incomingNumber);

        void onCallStateOFFHOOK();
    }
}


