package com.dukeg.ftat.VoiceCall;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
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

    private VoiceCallSendFragment voiceCallSendFragment;
    private VoiceCallReceiveFragment voiceCallReceiveFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        logger.d("This is voice call interface");

        View voice_call_view = inflater.inflate(R.layout.voicecall_main_fragment, container, false);

        TabLayout voice_call_tabLayout = voice_call_view.findViewById(R.id.Voice_Call_TabLayout);

        setDefaultFragment();

        voice_call_tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                FragmentManager fm = getFragmentManager();

                // 开启Fragment事务
                FragmentTransaction transaction = fm.beginTransaction();

                int pos = tab.getPosition();
                switch (pos){
                    case 0:
                        if (voiceCallSendFragment == null)
                        {
                            voiceCallSendFragment = new VoiceCallSendFragment();
                        }
                        // 使用当前Fragment的布局替代id_content的控件
                        transaction.replace(R.id.Voice_Call_Main_Frame, voiceCallSendFragment);
                        break;
                    case 1:
                        if (voiceCallReceiveFragment == null)
                        {
                            voiceCallReceiveFragment = new VoiceCallReceiveFragment();
                        }
                        // 使用当前Fragment的布局替代id_content的控件
                        transaction.replace(R.id.Voice_Call_Main_Frame, voiceCallReceiveFragment);
                        break;
                }

                // 事务提交
                transaction.commit();
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

    public void setDefaultFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        voiceCallSendFragment = new VoiceCallSendFragment();
        transaction.replace(R.id.Voice_Call_Main_Frame, voiceCallSendFragment);
        transaction.commit();
    }
}
