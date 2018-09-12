package com.kk.activityanim.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kk.activityanim.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OverridePendingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OverridePendingStyleActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation(MainActivity.this, R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                Intent intent = new Intent(MainActivity.this, AppcompatCustomAnimationActivity.class);
                startActivity(intent, activityOptionsCompat.toBundle());
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(v, v.getWidth()/2, v.getHeight()/2, 0, 0);
                Intent intent = new Intent(MainActivity.this, AppcompatScaleUpAnimationActivity.class);
                startActivity(intent, activityOptionsCompat.toBundle());
            }
        });

        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //顺序显示不同的Transition
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this);
                int x = i++%3;

                Intent intent = new Intent(MainActivity.this, AppcompatSceneTransitionAnimationActivity.class);
                switch(x){
                    case 0:
                        intent.putExtra("transition", "explode");
                        break;

                    case 1:
                        intent.putExtra("transition", "slide");
                        break;

                    case 2:
                        intent.putExtra("transition", "fade");
                        break;
                }
                startActivity(intent, activityOptionsCompat.toBundle());
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //显示Transition(主题样式配置)
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this);

                Intent intent = new Intent(MainActivity.this, AppcompatSceneTransitionAnimationStyleActivity.class);
                startActivity(intent, activityOptionsCompat.toBundle());
            }
        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //显示ShareElement Transition
                Pair sharePair = Pair.create(findViewById(R.id.share), "share");
                Pair sharePair1 = Pair.create(findViewById(R.id.share1), "share1");
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, sharePair, sharePair1);

                Intent intent = new Intent(MainActivity.this, AppcompatShareElementAnimationActivity.class);
                startActivity(intent, activityOptionsCompat.toBundle());
            }
        });
    }

    int i=0;
}
