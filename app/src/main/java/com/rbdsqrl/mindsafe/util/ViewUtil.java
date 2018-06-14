package com.rbdsqrl.mindsafe.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

public class ViewUtil {
    private static final String EMPTY_ALERT = "This field can't be empty";

    public static boolean isEmptyText(TextView...textViews){
        for(TextView t : textViews){
            if(t.getText().toString().isEmpty()){
                Log.i("view", "isEmpty");
                t.setError(EMPTY_ALERT);
                return true;
            }
        }
        return false;
    }

    public static void setVisibility(int visibility, View... views) {
        for(View view : views){
            view.setVisibility(visibility);
        }
    }

    public static void rotateView(float fromDegree, float toDegree, View v){
        RotateAnimation rotateAnimation = new RotateAnimation(fromDegree, toDegree,Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setRepeatCount(0);
        rotateAnimation.setDuration(800L);
        rotateAnimation.setFillAfter(true);
        v.startAnimation(rotateAnimation);
    }

    /*public static void animateView(final View v, float distance, final int visibility){
        v.animate()
                .setDuration(1000L)
                .translationY(distance)
                .alpha(1.0f)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        setVisibility(visibility, v);
                    }
                });
    }*/

}
