package com.dukeg.ftat.Utils.PauseResumeDialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.dukeg.ftat.R;

public class ProcessDialog extends Dialog {

    private ToggleButton pauseResumeToggleButton;
    private Button stopButton;
    private TextView titleTextView;
    private String titleStr;

    private onPauseResumeToggleButtonOnCheckedListener onPauseResumeToggleButtonOnCheckedListener;
    private onStopButtonOnClickListener onStopButtonOnClickListener;

    public void setPauseResumeButtonOnCheckedListener(onPauseResumeToggleButtonOnCheckedListener onPauseResumeToggleButtonOnCheckedListener) {
        this.onPauseResumeToggleButtonOnCheckedListener = onPauseResumeToggleButtonOnCheckedListener;
    }

    public void setStopButtonOnClickListener(onStopButtonOnClickListener onStopButtonOnClickListener) {
        this.onStopButtonOnClickListener = onStopButtonOnClickListener;
    }

    public ProcessDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process_dialog);

        pauseResumeToggleButton = findViewById(R.id.pause_resume_toggleButton);

        pauseResumeToggleButton.setChecked(false);

        setCanceledOnTouchOutside(false);

        initView();

        initData();

        initEvent();

    }
    private void initEvent() {
        pauseResumeToggleButton.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (onPauseResumeToggleButtonOnCheckedListener != null) {
                    Drawable pauseDrawable = getContext().getResources().getDrawable(R.drawable.ic_button_pause);
                    Drawable resumeDrawable = getContext().getResources().getDrawable(R.drawable.ic_button_play);
                    pauseResumeToggleButton.setCompoundDrawablesWithIntrinsicBounds(null,isChecked? resumeDrawable:pauseDrawable, null, null);
                    onPauseResumeToggleButtonOnCheckedListener.onPauseResumeToggleButtonOnChecked(isChecked);
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onStopButtonOnClickListener != null) {
                    onStopButtonOnClickListener.onStopButtonOnClick();
                }
            }
        });
    }

    private void initData() {
        if (titleStr != null) {
            titleTextView.setText(titleStr);
        }
    }

    private void initView() {
        pauseResumeToggleButton = findViewById(R.id.pause_resume_toggleButton);
        stopButton = findViewById(R.id.stop_button);
        titleTextView = findViewById(R.id.title);
    }

    public void setTitle(String title) {
        titleStr = title;
    }


    public interface onPauseResumeToggleButtonOnCheckedListener {
        void onPauseResumeToggleButtonOnChecked(boolean isChecked);
    }

    public interface onStopButtonOnClickListener {
        void onStopButtonOnClick();
    }


}