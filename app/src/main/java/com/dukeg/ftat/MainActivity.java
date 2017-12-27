package com.dukeg.ftat;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dukeg.ftat.LogUtils.logger;
import com.dukeg.ftat.TestResults.TestResultsFragment;
import com.dukeg.ftat.VideoCall.VideoCallMainFragment;
import com.dukeg.ftat.VoiceCall.VoiceCallMainFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private VoiceCallMainFragment voiceCallMainFragment;
    private VideoCallMainFragment videoCallMainFragment;
    private TestResultsFragment testResultsFragment;
    private SettingsFragment settingsFragment;
    private AboutFragment aboutFragment;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setDefaultFragment();
    }

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        aboutFragment = new AboutFragment();
        transaction.replace(R.id.MainActivity_Frame, aboutFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fm = getFragmentManager();

        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();

        int id = item.getItemId();
        switch (id){
            case R.id.nav_voice_call:
                logger.d("This is voice call selection");

                toolbar.setTitle("Voice Call");

                if (voiceCallMainFragment == null)
                {
                    voiceCallMainFragment = new VoiceCallMainFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.MainActivity_Frame, voiceCallMainFragment);
                break;
            case R.id.nav_video_call:
                logger.d("This is video call selection");

                toolbar.setTitle("Video Call");

                if (videoCallMainFragment == null)
                {
                    videoCallMainFragment = new VideoCallMainFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.MainActivity_Frame, videoCallMainFragment);
                break;
            case R.id.nav_test_result:
                logger.d("This is test results selection");

                toolbar.setTitle("Test Results");

                if (testResultsFragment == null)
                {
                    testResultsFragment = new TestResultsFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.MainActivity_Frame, testResultsFragment);
                break;
            case R.id.nav_more:
                logger.d("This is more selection");

                toolbar.setTitle("More functions");

                final AlertDialog.Builder more_diag = new AlertDialog.Builder(this);
                more_diag.setTitle("More functions are on the way...");
                more_diag.setMessage("We are trying to add more functions fore this tools, please keep patient." +
                        "\nIf you have good ideas please contact us.");
                more_diag.setPositiveButton("Fine...", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                more_diag.setNegativeButton("Contact us~~~", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri = Uri.parse("mailto:y3_autotest@gionee.com");
                        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Ideas for FTAT"); // 主题
                        intent.putExtra(Intent.EXTRA_TEXT, "Hi SDET"); // 正文
                        startActivity(Intent.createChooser(intent, "Please choose your email apps"));
                    }
                });
                more_diag.show();
                break;
            case R.id.nav_settings:
                logger.d("This is settings selection");

                toolbar.setTitle("Settings");

                if (settingsFragment == null)
                {
                    settingsFragment = new SettingsFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.MainActivity_Frame, settingsFragment);

                break;
            case R.id.nav_about:
                logger.d("This is about selection");

                toolbar.setTitle("About");

                if (aboutFragment == null)
                {
                    aboutFragment = new AboutFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.MainActivity_Frame, aboutFragment);
                break;
        }

        // 事务提交
        transaction.commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
