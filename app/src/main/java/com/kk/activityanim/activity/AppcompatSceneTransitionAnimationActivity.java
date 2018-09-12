package com.kk.activityanim.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;

import com.kk.activityanim.R;
import com.kk.activityanim.util.ActivityAnimOption;

public class AppcompatSceneTransitionAnimationActivity extends AppCompatActivity {

    protected ActivityAnimOption activityAnimOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String transition = getIntent().getStringExtra("transition");
        if(!TextUtils.isEmpty(transition)){
            getWindow().setAllowEnterTransitionOverlap(false);
            getWindow().setAllowReturnTransitionOverlap(false);
            long duration = 500l;
            switch (transition) {
                case "explode":
                    Explode explode = new Explode();
                    explode.setDuration(duration);
                    explode.excludeChildren(android.R.id.statusBarBackground, true);
                    explode.excludeChildren(android.R.id.navigationBarBackground, true);
                    getWindow().setEnterTransition(explode);
                    getWindow().setReenterTransition(explode);
                    break;
                case "slide":
                    Slide slide = new Slide(Gravity.BOTTOM);
                    slide.setDuration(duration);
                    slide.excludeChildren(android.R.id.statusBarBackground, true);
                    slide.excludeChildren(android.R.id.navigationBarBackground, true);
                    getWindow().setEnterTransition(slide);
                    getWindow().setReenterTransition(slide);
                    break;
                case "fade":
                    Fade fade = new Fade();
                    fade.setDuration(duration);
                    fade.excludeChildren(android.R.id.statusBarBackground, true);
                    fade.excludeChildren(android.R.id.navigationBarBackground, true);
                    getWindow().setEnterTransition(fade);
                    getWindow().setReenterTransition(fade);
                    break;
            }
        }

        setContentView(R.layout.layout_a5);
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
