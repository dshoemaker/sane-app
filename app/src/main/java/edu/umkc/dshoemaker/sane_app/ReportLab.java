package edu.umkc.dshoemaker.sane_app;

import android.content.Context;

/**
 * Created by Drew on 10/11/2015.
 */
public class ReportLab {
    private static ReportLab sReportLab;

    public static ReportLab get(Context context) {
        if (sReportLab == null) {
            sReportLab = new ReportLab(context);
        }
        return sReportLab;
    }

    private ReportLab(Context context){

    }
}
