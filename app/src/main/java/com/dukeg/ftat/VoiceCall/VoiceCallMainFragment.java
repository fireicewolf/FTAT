package com.dukeg.ftat.VoiceCall;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dukeg.ftat.LogUtils.logger;
import com.dukeg.ftat.R;

/**
 * Created by Administrator on 2017/12/19.
 * This is main interface for voice call function.
 */

public class VoiceCallMainFragment extends Fragment {

    private TabLayout voice_call_TabLayout;
    private TabItem send_voice_call_Tab;
    private TabItem receive_voice_call_Tab;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View voice_call_view = inflater.inflate(R.layout.voicecall_main_fragment, container, false);

        logger.d("This is voice call interface");
        voice_call_TabLayout = voice_call_view.findViewById(R.id.Voice_Call_TabLayout);
        send_voice_call_Tab = voice_call_view.findViewById(R.id.Send_Voice_Call_Tab);
        receive_voice_call_Tab = voice_call_view.findViewById(R.id.Receive_Voice_Call_Tab);
        voice_call_TabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return voice_call_view;
    }
}
