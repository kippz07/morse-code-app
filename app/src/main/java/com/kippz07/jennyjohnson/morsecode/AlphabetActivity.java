package com.kippz07.jennyjohnson.morsecode;

import android.content.Context;
import android.hardware.Camera;
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
    private Camera cameraOld;
    private Camera.Parameters parameter;
    private boolean inProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        TextView mA = findViewById(R.id.a);
        TextView mB = findViewById(R.id.b);
        TextView mC = findViewById(R.id.c);
        TextView mD = findViewById(R.id.d);
        TextView mE = findViewById(R.id.e);
        TextView mF = findViewById(R.id.f);
        TextView mG = findViewById(R.id.g);
        TextView mH = findViewById(R.id.h);
        TextView mI = findViewById(R.id.i);
        TextView mJ = findViewById(R.id.j);
        TextView mK = findViewById(R.id.k);
        TextView mL = findViewById(R.id.l);
        TextView mM = findViewById(R.id.m);
        TextView mN = findViewById(R.id.n);
        TextView mO = findViewById(R.id.o);
        TextView mP = findViewById(R.id.p);
        TextView mQ = findViewById(R.id.q);
        TextView mR = findViewById(R.id.r);
        TextView mS = findViewById(R.id.s);
        TextView mT = findViewById(R.id.t);
        TextView mU = findViewById(R.id.u);
        TextView mV = findViewById(R.id.v);
        TextView mW = findViewById(R.id.w);
        TextView mX = findViewById(R.id.x);
        TextView mY = findViewById(R.id.y);
        TextView mZ = findViewById(R.id.z);

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
        if (!inProgress) {
            inProgress = true;
            flashTimer(0);
            flashTimer(first);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    inProgress = false;
                }
            }, first + 400);
        }
    }

    private void two(int first, int second) {
        if (!inProgress) {
            inProgress = true;
            flashTimer(0);
            flashTimer(first);
            flashTimer(first + 200);
            flashTimer(first + 200 + second);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    inProgress = false;
                }
            }, first + 200 + second + 400);
        }
    }

    private void three(int first, int second, int third) {
        if (!inProgress) {
            inProgress = true;
            flashTimer(0);
            flashTimer(first);
            flashTimer(first + 200);
            flashTimer(first + 200 + second);
            flashTimer(first + 200 + second + 200);
            flashTimer(first + 200 + second + 200 + third);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    inProgress = false;
                }
            }, first + 200 + second + 200 + third + 400);
        }
    }

    private void four(int first, int second, int third, int fourth) {
        if (!inProgress) {
            inProgress = true;
            flashTimer(0);
            flashTimer(first);
            flashTimer(first + 200);
            flashTimer(first + 200 + second);
            flashTimer(first + 200 + second + 200);
            flashTimer(first + 200 + second + 200 + third);
            flashTimer(first + 200 + second + 200 + third + 200);
            flashTimer(first + 200 + second + 200 + third + 200 + fourth);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    inProgress = false;
                }
            }, first + 200 + second + 200 + third + 200 + fourth + 400);
        }
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

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                camera = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                try {
                    cameraId = camera.getCameraIdList()[0];
                } catch (CameraAccessException e) {
                    Log.e("Camera Error. ", e.getMessage());
                }
            } else {
                try {
                    cameraOld = Camera.open();
                    parameter = cameraOld.getParameters();
                } catch (RuntimeException e) {
                    System.out.println("Error: Failed to Open: " + e.getMessage());
                }
            }
        }
    }

    private void turnOnFlash() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                camera.setTorchMode(cameraId, true);
                isFlashOn = true;
            } else {
                parameter = cameraOld.getParameters();
                parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                cameraOld.setParameters(parameter);
                cameraOld.startPreview();
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
            } else {
                parameter.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                cameraOld.setParameters(parameter);
                cameraOld.stopPreview();
                isFlashOn = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
