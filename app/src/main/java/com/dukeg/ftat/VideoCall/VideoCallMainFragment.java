package com.dukeg.ftat.VideoCall;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dukeg.ftat.LogUtils.logger;
import com.dukeg.ftat.R;

/**
 * Created by Administrator on 2017/12/19.
 * This is main interface for video call function.
 */

public class VideoCallMainFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        logger.d("This is voice call interface");
        return inflater.inflate(R.layout.voicecall_main_fragment, container, false);
    }
}
