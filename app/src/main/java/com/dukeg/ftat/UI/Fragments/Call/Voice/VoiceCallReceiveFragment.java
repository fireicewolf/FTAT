package com.dukeg.ftat.UI.Fragments.Call.Voice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dukeg.ftat.Utils.Log.logger;
import com.dukeg.ftat.R;

/**
 * Created by DukeG on 2017/12/19.
 * This is voice call receive fragment.
 */

public class VoiceCallReceiveFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View voice_call_send_view = inflater.inflate(R.layout.voicecall_receive_fragment, container, false);

        logger.d("This is voice call receive interface");

        return voice_call_send_view;
    }
}
