package com.dukeg.ftat.VoiceCall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;

/**
 * Created by johnyu on 28/12/2017.
 * This is a broadcast listener for voice call.
 */

public class VoiceCallListener {
//
//    private Context mContext;
//    private WLANBroadcastReceiver receiver;
//    private WLANStateListener mWLANStateListener;
//
//    public VoiceCallListener(Context context) {
//        mContext = context;
//        receiver = new WLANBroadcastReceiver();
//    }
//
//    public void register(WLANStateListener listener) {
//        mWLANStateListener = listener;
//        if (receiver != null) {
//            IntentFilter filter = new IntentFilter();
//            filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
//            mContext.registerReceiver(receiver, filter);
//        }
//    }
//
//    public void unregister() {
//        if (receiver != null) {
//            mContext.unregisterReceiver(receiver);
//        }
//    }
//
////    private class WLANBroadcastReceiver extends BroadcastReceiver {
////
////        @Override
////        public void onReceive(Context context, Intent intent) {
////            if (intent != null) {
////                String action = intent.getAction();
////
////                int switchState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, 0);
////                switch (switchState) {
////                    case WifiManager.WIFI_STATE_DISABLED:
////                        if (mWLANStateListener != null) {
////                            logger.d("Wi-Fi开关关闭");
////                            mWLANStateListener.onStateDisabled();
////                        }
////                        break;
////                    case WifiManager.WIFI_STATE_ENABLED:
////                        if (mWLANStateListener != null) {
////                            logger.d("Wi-Fi开关打开");
////                            mWLANStateListener.onStateEnabled();
////                        }
////                        break;
////                    default:
////                        break;
////                }
////            }
////        }
////
////    }
//
//    public interface WLANStateListener {
//
//        void onStateDisabled();
//
//        void onStateEnabled();
//
//        void onStateDisconnected();
//
//        void onStateConnected();
//    }
}


