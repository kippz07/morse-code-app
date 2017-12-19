package com.kippz07.jennyjohnson.morsecode;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class AlphabetActivity extends AppCompatActivity {

    private CameraManager camera;
    private String cameraId;
    private boolean isFlashOn;
    private Timer timer = new Timer();
    private TextView mA;
    private TextView mB;
    private TextView mC;
    private TextView mD;
    private TextView mE;
    private TextView mF;
    private TextView mG;
    private TextView mH;
    private TextView mI;
    private TextView mJ;
    private TextView mK;
    private TextView mL;
    private TextView mM;
    private TextView mN;
    private TextView mO;
    private TextView mP;
    private TextView mQ;
    private TextView mR;
    private TextView mS;
    private TextView mT;
    private TextView mU;
    private TextView mV;
    private TextView mW;
    private TextView mX;
    private TextView mY;
    private TextView mZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        mA = findViewById(R.id.a);
        mB = findViewById(R.id.b);
        mC = findViewById(R.id.c);
        mD = findViewById(R.id.d);
        mE = findViewById(R.id.e);
        mF = findViewById(R.id.f);
        mG = findViewById(R.id.g);
        mH = findViewById(R.id.h);
        mI = findViewById(R.id.i);
        mJ = findViewById(R.id.j);
        mK = findViewById(R.id.k);
        mL = findViewById(R.id.l);
        mM = findViewById(R.id.m);
        mN = findViewById(R.id.n);
        mO = findViewById(R.id.o);
        mP = findViewById(R.id.p);
        mQ = findViewById(R.id.q);
        mR = findViewById(R.id.r);
        mS = findViewById(R.id.s);
        mT = findViewById(R.id.t);
        mU = findViewById(R.id.u);
        mV = findViewById(R.id.v);
        mW = findViewById(R.id.w);
        mX = findViewById(R.id.x);
        mY = findViewById(R.id.y);
        mZ = findViewById(R.id.z);

        getCamera();

        mA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                two(200, 600);
            }
        });
        mB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(600, 200, 200, 200);
            }
        });
        mC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(600, 200, 600, 200);
            }
        });
        mD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(600, 200, 200);
            }
        });
        mE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one(200);
            }
        });
        mF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(200, 200, 600, 200);
            }
        });
        mG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(600, 600, 200);
            }
        });
        mH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(200, 200, 200, 200);
            }
        });
        mI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                two(200, 200);
            }
        });
        mJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(200, 600, 600, 600);
            }
        });
        mK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(600, 200, 600);
            }
        });
        mL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(200, 600, 200, 200);
            }
        });
        mM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                two(600, 600);
            }
        });
        mN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                two(600, 200);
            }
        });
        mO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(600, 600, 600);
            }
        });
        mP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(200, 600, 600, 200);
            }
        });
        mQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(600, 600, 200, 600);
            }
        });
        mR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(200, 600, 200);
            }
        });
        mS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(200, 200,200);
            }
        });
        mT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one(600);
            }
        });
        mU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(200, 200,600);
            }
        });
        mV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(200, 200, 200,600);
            }
        });
        mW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three(200, 600, 600);
            }
        });
        mX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(600, 200, 200, 600);
            }
        });
        mY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(600, 200, 600, 600);
            }
        });
        mZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                four(600, 600, 200,200);
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

    private void four(int first, int second, int third, int fourth) {
        flashTimer(0);
        flashTimer(first);
        flashTimer(first + 200);
        flashTimer(first + 200 + second);
        flashTimer(first + 200 + second + 200);
        flashTimer(first + 200 + second + 200 + third);
        flashTimer(first + 200 + second + 200 + third + 200);
        flashTimer(first + 200 + second + 200 + third + 200 + fourth);
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
