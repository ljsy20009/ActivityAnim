package com.kk.activityanim.activity;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.kk.activityanim.R;
import com.kk.activityanim.util.ActivityAnimOption;

public class AppcompatShareElementAnimationActivity extends AppCompatActivity {

    private View rootView;
    private View revealView;
    private View tv;

    protected ActivityAnimOption activityAnimOption;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_a7);
        getAnim();

        rootView = findViewById(R.id.a7_root);
        revealView = findViewById(R.id.a7_reveal);
        tv = findViewById(R.id.a7_tv);
        revealView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    float finalRadius = (float) Math.hypot(rootView.getWidth(), rootView.getHeight());
                    Animator anim = ViewAnimationUtils.createCircularReveal(tv, (int) motionEvent.getRawX(), (int) motionEvent.getRawY(), 0, finalRadius);
                    anim.setDuration(1000L);
                    anim.setInterpolator(new AccelerateDecelerateInterpolator());
                    anim.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {
                            tv.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            //textView.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
                    anim.start();
                }
                return false;
            }
        });
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
