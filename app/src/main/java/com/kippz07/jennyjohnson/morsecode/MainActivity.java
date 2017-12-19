package com.kippz07.jennyjohnson.morsecode;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraAccessException;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private TextView hello;
    private TextView helloo;
    private CameraManager camera;
    private String cameraId;
    private boolean isFlashOn;
    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hello = findViewById(R.id.hello);
        helloo = findViewById(R.id.helloo);

        getCamera();


        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(200, 200, 200);
            }
        });
        helloo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(600, 600, 600);
            }
        });
    }

    private void one(int first) {
        flashTimer(0);
        flashTimer(first);
    }

    private void two(int first, int second) {
        flashTimer(0);
        flashTimer(first);
        flashTimer(first + 200);
        flashTimer(first + 200 + second);
    }

    private void three(int first, int second, int third) {
        flashTimer(0);
        flashTimer(first);
        flashTimer(first + 200);
        flashTimer(first + 200 + second);
        flashTimer(first + 200 + second + 200);
        flashTimer(first + 200 + second + 200 + third);
    }

    private void flashTimer(int delay) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isFlashOn) {
                    turnOffFlash();
                } else {
                    turnOnFlash();
                }
            }
        }, delay);
    }

    private void getCamera() {

        if (camera == null) {
            camera = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            try {
                cameraId = camera.getCameraIdList()[0];
            } catch (CameraAccessException e) {
                Log.e("Camera Error. ", e.getMessage());
            }
        }
    }

    private void turnOnFlash() {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    camera.setTorchMode(cameraId, true);
                    isFlashOn = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    private void turnOffFlash() {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    camera.setTorchMode(cameraId, false);
                    isFlashOn = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}