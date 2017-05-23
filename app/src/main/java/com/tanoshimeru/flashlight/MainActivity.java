package com.tanoshimeru.flashlight;

import android.app.ActionBar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private boolean turningOn = true;
    private Button btnSetting, btnSwitch;
    private RelativeLayout layoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else{
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(uiOptions);
//            ActionBar actionBar = getActionBar();
//            actionBar.hide();
        }
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        layoutMain = (RelativeLayout) findViewById(R.id.layoutMain);
        btnSetting = (Button) findViewById(R.id.btnSetting);
        btnSwitch = (Button) findViewById(R.id.btnSwitch);

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnSwitch.setOnClickListener(view->turnOn());
    }

    private void turnOn() {
        if(turningOn){
            turningOn = false;
            layoutMain.setBackgroundResource(R.drawable.background_off);
            //TODO tắt đèn
        }else{
            turningOn = true;
            layoutMain.setBackgroundResource(R.drawable.background_on);
            //TODO bật đèn
        }
    }
}
