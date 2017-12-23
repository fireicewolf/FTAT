package com.dukeg.ftat.VideoCall;

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
import com.dukeg.ftat.VoiceCall.VoiceCallReceiveFragment;
import com.dukeg.ftat.VoiceCall.VoiceCallSendFragment;

/**
 * Created by Administrator on 2017/12/19.
 * This is main interface for video call function.
 */

public class VideoCallMainFragment extends Fragment {
    
    private VideoCallSendFragment videoCallSendFragment;
    private VideoCallReceiveFragment videoCallReceiveFragment;
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        logger.d("This is video call interface");
        
        View video_call_view = inflater.inflate(R.layout.videocall_main_fragment,container,false);

        TabLayout video_call_tabLayout = video_call_view.findViewById(R.id.Video_Call_TabLayout);

        video_call_tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                FragmentManager fm = getFragmentManager();

                // 开启Fragment事务
                FragmentTransaction transaction = fm.beginTransaction();

                int pos = tab.getPosition();
                switch (pos){
                    case 0:
                        if (videoCallSendFragment == null)
                        {
                            videoCallSendFragment = new VideoCallSendFragment();
                        }
                        // 使用当前Fragment的布局替代id_content的控件
                        transaction.replace(R.id.Video_Call_Main_Frame, videoCallSendFragment);
                        break;
                    case 1:
                        if (videoCallReceiveFragment == null)
                        {
                            videoCallReceiveFragment = new VideoCallReceiveFragment();
                        }
                        // 使用当前Fragment的布局替代id_content的控件
                        transaction.replace(R.id.Video_Call_Main_Frame, videoCallReceiveFragment);
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

        setDefaultFragment();


        return inflater.inflate(R.layout.videocall_main_fragment, container, false);
    }

    public void setDefaultFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        videoCallSendFragment = new VideoCallSendFragment();
        transaction.replace(R.id.Video_Call_Main_Frame, videoCallSendFragment);
        transaction.commit();
    }
}
