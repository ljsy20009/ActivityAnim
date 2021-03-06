package com.kk.activityanim.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.kk.activityanim.R;
import com.kk.activityanim.util.ActivityAnimOption;

public class AppcompatCustomAnimationActivity extends AppCompatActivity {

    protected ActivityAnimOption activityAnimOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_a3);
        getAnim();
    }

    private void getAnim(){
        activityAnimOption = new ActivityAnimOption(this);
    }

    @Override
    public void finish() {
        super.finish();
        activityAnimOption.overridePendingTransition(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAfterTransition(this);
    }
}
