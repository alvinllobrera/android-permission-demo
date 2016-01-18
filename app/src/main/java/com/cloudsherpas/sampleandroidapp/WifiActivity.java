package com.cloudsherpas.sampleandroidapp;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class WifiActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        setupCheckWifiStateButton();
    }

    private void setupCheckWifiStateButton() {
        final Button btnCheckWifi = (Button) findViewById(R.id.btnCheckWifi);
        btnCheckWifi.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView wifiState = (TextView) findViewById(R.id.txtWifiState);
                wifiState.setText(getWifiCurrentState());
            }
        });
    }

    private String getWifiCurrentState() {
        final WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        final WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        final SupplicantState supState = wifiInfo.getSupplicantState();
        return supState.name();
    }
}
