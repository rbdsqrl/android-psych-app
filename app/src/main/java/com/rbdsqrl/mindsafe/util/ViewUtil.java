package com.rbdsqrl.mindsafe.util;

import android.util.Log;
import android.widget.TextView;

public class ViewUtil {
    private static final String EMPTY_ALERT = "This field can't be empty";

    public static boolean isEmptyText(TextView...textViews){
        for(TextView t: textViews){
            if(t.getText().toString().isEmpty()){
                Log.i("view", "isEmpty");
                t.setError(EMPTY_ALERT);
                return true;
            }
        }
        return false;
    }
}
