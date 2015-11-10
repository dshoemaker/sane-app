package edu.umkc.dshoemaker.sane_app;

import android.content.Context;

/**
 * Created by Drew on 10/11/2015.
 */
public class ViewAllReportsActivity {
    private static ViewAllReportsActivity sViewAllReportsActivity;

    public static ViewAllReportsActivity get(Context context) {
        if (sViewAllReportsActivity == null) {
            sViewAllReportsActivity = new ViewAllReportsActivity(context);
        }
        return sViewAllReportsActivity;
    }

    private ViewAllReportsActivity(Context context){

    }
}
