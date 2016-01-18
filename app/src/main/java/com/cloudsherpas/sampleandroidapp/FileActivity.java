package com.cloudsherpas.sampleandroidapp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class FileActivity extends Activity {

    private static final int PERMISSION_ACCEPTED_INDICATOR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        requestRequiredPermission();
        setupWriteToFileButton();
        registerReceiver(null, null);
    }

    private void setupWriteToFileButton() {
        final Button btnWriteToFile = (Button) findViewById(R.id.btnWriteToFile);
        btnWriteToFile.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeContentToFile();
            }
        });
    }

    private void writeContentToFile() {
        final EditText editText = (EditText) findViewById(R.id.txtFileContent);

        String response = "File successfully created!";
        try {
            File file = new File("/sdcard/test.txt");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(editText.getText().toString().getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
            response = "Unable to create file";
        }

        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }

    private void requestRequiredPermission() {
        final String[] requiredPermission = new String[] {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        DangerousPermissionDemoUtil.showAccessToPermission(this, requiredPermission, PERMISSION_ACCEPTED_INDICATOR);
    }

}
