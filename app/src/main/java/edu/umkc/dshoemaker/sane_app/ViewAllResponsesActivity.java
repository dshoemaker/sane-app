package edu.umkc.dshoemaker.sane_app;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Drew on 10/11/2015.
 */
public class ViewAllResponsesActivity {
    private ArrayList<Response> mResponses;

    private static ViewAllResponsesActivity sViewAllReportsActivity;
    private Context mAppContext;

    private ViewAllResponsesActivity(Context appContext){
        mAppContext = appContext;
        mResponses = new ArrayList<Response>();
        for (int i = 0; i < 100; i++) {
            Response r = new Response();
            r.setTitle("Response #" + i);
            r.setReported(i % 2 == 0);
            mResponses.add(r);
        }
    }


    public static ViewAllResponsesActivity get(Context context) {
        if (sViewAllReportsActivity == null) {
            sViewAllReportsActivity = new ViewAllResponsesActivity(context);
        }
        return sViewAllReportsActivity;
    }

    public ArrayList<Response> getResponses() {
        return mResponses;
    }

    public Response getResponse(UUID id) {
        for (Response r : mResponses) {
            if (r.getId().equals(id))
                return r;
        }
        return null;
    }
}
