package com.dukeg.ftat.TestResultsUtils;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dukeg.ftat.Utils.Log.logger;
import com.dukeg.ftat.R;

/**
 * Created by DukeG on 2017/12/19.
 * This is a fragment for test results selection.
 */

public class TestResultsFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        logger.d("This is test results interface");
        return inflater.inflate(R.layout.test_result_fragment, container, false);
    }
}
