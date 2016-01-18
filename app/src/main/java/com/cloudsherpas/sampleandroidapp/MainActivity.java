package com.cloudsherpas.sampleandroidapp;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupWifiCheckerBtn();
        setupFileMakerBtn();
    }

    private void setupWifiCheckerBtn() {
        final Button btnWifiChecker = (Button) findViewById(R.id.btnStartWifiActivity);
        btnWifiChecker.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startWifiActivity();
            }
        });
    }

    private void startWifiActivity() {
        final Intent intent = new Intent(this, WifiActivity.class);
        startActivity(intent);
    }

    private void setupFileMakerBtn() {
        final Button btnFileMaker = (Button) findViewById(R.id.btnStartFileMakerAct);
        btnFileMaker.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFileActivity();
            }
        });
    }

    private void startFileActivity() {
        final Intent intent = new Intent(this, FileActivity.class);
        startActivity(intent);
    }




}
