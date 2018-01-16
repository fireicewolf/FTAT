package com.dukeg.ftat.UI.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dukeg.ftat.R;
import com.dukeg.ftat.Utils.Log.logger;

/**
 * Created by DukeG on 2017/12/19.
 * This is a fragment for settings selection.
 */

public class SettingsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        logger.d("This is settings interface");
        return inflater.inflate(R.layout.settings_fragment, container, false);
    }
}
