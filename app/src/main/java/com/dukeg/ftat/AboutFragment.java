package com.dukeg.ftat;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dukeg.ftat.LogUtils.logger;

/**
 * Created by Administrator on 2017/12/19.
 * This is a fragment for about selection.
 */

public class AboutFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        logger.d("This is about interface");
        return inflater.inflate(R.layout.about_fragment, container, false);
    }

}
