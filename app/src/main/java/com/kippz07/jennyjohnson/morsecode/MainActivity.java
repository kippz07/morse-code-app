package com.kippz07.jennyjohnson.morsecode;

import android.content.Context;
import android.content.Intent;
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

    private TextView mAlphabet;
    private TextView mSos;
    private CameraManager camera;
    private String cameraId;
    private boolean isFlashOn;
    private Timer timer = new Timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAlphabet = findViewById(R.id.alphabet);
        mSos = findViewById(R.id.sos);

        getCamera();

        mAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlphabetActivity.class);
                startActivity(intent);
            }
        });

        mSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashTimer(0); //.
                flashTimer(200);
                flashTimer(400); //.
                flashTimer(600);
                flashTimer(800); //.
                flashTimer(1000);
                flashTimer(1600); //-
                flashTimer(2200);
                flashTimer(2400); //-
                flashTimer(3000);
                flashTimer(3200); //-
                flashTimer(3800);
                flashTimer(4400); //.
                flashTimer(4600);
                flashTimer(4800); //.
                flashTimer(5000);
                flashTimer(5200); //.
                flashTimer(5400);
            }
        });
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
