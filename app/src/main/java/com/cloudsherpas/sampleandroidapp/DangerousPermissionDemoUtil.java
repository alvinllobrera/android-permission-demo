package com.cloudsherpas.sampleandroidapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class DangerousPermissionDemoUtil {

    public static void showAccessToPermission(final Activity activity, final String[] permissions,
                                              final int isPermissionAccepted) {
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(activity, permissions, isPermissionAccepted);
        }
    }
}