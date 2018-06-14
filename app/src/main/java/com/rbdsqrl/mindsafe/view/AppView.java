package com.rbdsqrl.mindsafe.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class AppView {
    private static void startActivity(Intent intent, Context context){
        context.startActivity(intent);
    }

    private static void startActivity(Context context, Class<?> activityClass){
        Intent intent = new Intent(context,activityClass);
        startActivity(intent,context);
    }

    public static void setWindowDimens(Dialog dialog, Double widthFactor, int gravity) throws Exception {
        Window window = dialog.getWindow();
        Point size = new Point();
        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        window.setLayout((int) (width * widthFactor), (int) (0.7 * height));
        window.setGravity(gravity);
    }

    public static void setWindowProps(Dialog dialog, Boolean isCancelable, int windowFeature) throws Exception {
        Window window = dialog.getWindow();
        window.requestFeature(windowFeature);
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        dialog.setCanceledOnTouchOutside(isCancelable);
    }
}
