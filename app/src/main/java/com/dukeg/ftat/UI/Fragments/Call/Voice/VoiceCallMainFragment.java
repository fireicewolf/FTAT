package com.dukeg.ftat.UI.Fragments.Call.Voice;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dukeg.ftat.Utils.PauseResumeDialog.ProcessDialog;
import com.dukeg.ftat.Utils.Log.logger;
import com.dukeg.ftat.R;

/**
 * Created by DukeG on 2017/12/19.
 * This is main interface for voice call function.
 */

public class VoiceCallMainFragment extends Fragment {

    Context context;

    VoiceCallSendFragment voiceCallSendFragment;
    VoiceCallReceiveFragment voiceCallReceiveFragment;

    ProcessDialog processDialog;

    Button startButton;

    Toast pause;
    Toast resume;
    Toast stop;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        this.context = activity;
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        logger.d("This is voice call interface");

        View voice_call_view = inflater.inflate(R.layout.call_main_fragment, container, false);

        TabLayout voice_call_tabLayout = voice_call_view.findViewById(R.id.Call_TabLayout);

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
                        transaction.replace(R.id.Call_Main_Frame, voiceCallSendFragment);
                        break;
                    case 1:
                        if (voiceCallReceiveFragment == null)
                        {
                            voiceCallReceiveFragment = new VoiceCallReceiveFragment();
                        }
                        // 使用当前Fragment的布局替代id_content的控件
                        transaction.replace(R.id.Call_Main_Frame, voiceCallReceiveFragment);
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

        pause = Toast.makeText(context,"pause",Toast.LENGTH_SHORT);
        resume = Toast.makeText(context,"resume",Toast.LENGTH_SHORT);
        stop = Toast.makeText(context, "stop button", Toast.LENGTH_SHORT);

        startButton = voice_call_view.findViewById(R.id.Start_button);

        processDialog = new ProcessDialog(context);
        processDialog.setTitle("Test is running");
        processDialog.setPauseResumeButtonOnCheckedListener(new ProcessDialog.onPauseResumeToggleButtonOnCheckedListener() {
            @Override
            public void onPauseResumeToggleButtonOnChecked(boolean isChecked) {
                if (isChecked){
                    processDialog.setTitle("Test is paused");
                    pause.show();
                }
                else {
                    resume.show();
                    processDialog.setTitle("Test is running");
                }
            }
        });

        processDialog.setStopButtonOnClickListener(new ProcessDialog.onStopButtonOnClickListener() {
            @Override
            public void onStopButtonOnClick() {
                stop.show();

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setTitle("Are you sure to stop test?");
                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        processDialog.dismiss();
                    }
                });
                alertDialog.setNegativeButton("Cancel", null);
                alertDialog.show();
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDialog.show();
            }
        });

        return voice_call_view;
    }

    public void setDefaultFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        voiceCallSendFragment = new VoiceCallSendFragment();
        transaction.replace(R.id.Call_Main_Frame, voiceCallSendFragment);
        transaction.commit();
    }
}
