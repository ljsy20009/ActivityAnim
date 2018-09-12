package com.kk.activityanim.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kk.activityanim.R;
import com.kk.activityanim.util.ActivityAnimOption;

public class OverridePendingStyleActivity extends AppCompatActivity {

    protected ActivityAnimOption activityAnimOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_a2);
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

//    public void onBackPressed(){
//        super.onBackPressed();
//        overridePendingTransition(R.anim.translate_in_right_to_left, R.anim.translate_out_right_to_left);
//    }
}
