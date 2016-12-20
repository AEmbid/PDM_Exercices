package com.pdm.p_76_hilos;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SeekBar sb;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = (SeekBar) findViewById(R.id.sbar);
        pb = (ProgressBar) findViewById(R.id.pbar);

        findViewById(R.id.btnsbar).setOnClickListener(this);
        findViewById(R.id.btndiabar).setOnClickListener(this);
        findViewById(R.id.btnpbar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnsbar:
                sbarpost();
                break;
            case R.id.btndiabar:
                miprogressdialog(view);
                break;
            case R.id.btnpbar:
                pbhandler();
                break;
        }
    }

    public void pbhandler() {
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                pb.incrementProgressBy(10);
            }
        };

        pb.setProgress(0);
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    handler.sendMessage(handler.obtainMessage());
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(MainActivity.this,"Tarea finalizada!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

    public void sbarpost() {
        new Thread(new Runnable() {
            public void run() {
                sb.post(new Runnable() {
                    public void run() {
                        sb.setProgress(0);
                    }
                });
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    sb.post(new Runnable() {
                        public void run() {
                            sb.incrementProgressBy(10);
                        }
                    });
                }
                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(MainActivity.this, "Tarea finalizada!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

    public void miprogressdialog(View view) {
        final ProgressDialog progressdialog = new ProgressDialog(view.getContext());
        progressdialog.setCancelable(true);
        progressdialog.setMessage("Pasando el rato ...");
        progressdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressdialog.setProgress(0);
        progressdialog.setMax(100);
        progressdialog.show();
        final Handler progressBarHandler = new Handler();

        new Thread(new Runnable() {
            public void run() {
                int progressBarStatus = 0;
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(500);
                        progressBarStatus = progressBarStatus + 10;
                        final int finalProgressBarStatus = progressBarStatus;
                        progressBarHandler.post(new Runnable() {
                            public void run() {
                                progressdialog.setProgress(finalProgressBarStatus);
                            }
                        });
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                if (progressBarStatus >= 100) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressdialog.dismiss();
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(MainActivity.this, "Tarea finalizada!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }
}