package com.kk.activityanim.util;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.TypedArray;

/**
 * activity动画辅助类
 * </br>
 * <p>帮助解决同时设置app theme与activity theme时，activity theme退出动画不起作用</p>
 */
public class ActivityAnimOption {

    private int activityCloseEnterAnimation;
    private int activityCloseExitAnimation;

    public ActivityAnimOption(Activity activity){
        Resources.Theme theme = activity.getTheme();

        TypedArray activityStyle = theme.obtainStyledAttributes(new int[] {android.R.attr.windowAnimationStyle});
        int windowAnimationStyleResId = activityStyle.getResourceId(0, 0);
        activityStyle.recycle();

        activityStyle = theme.obtainStyledAttributes(windowAnimationStyleResId, new int[] {android.R.attr.activityCloseEnterAnimation, android.R.attr.activityCloseExitAnimation});
        activityCloseEnterAnimation = activityStyle.getResourceId(0, 0);
        activityCloseExitAnimation = activityStyle.getResourceId(1, 0);
        activityStyle.recycle();
    }

    public void overridePendingTransition(Activity activity){
        activity.overridePendingTransition(activityCloseEnterAnimation, activityCloseExitAnimation);
    }
}
