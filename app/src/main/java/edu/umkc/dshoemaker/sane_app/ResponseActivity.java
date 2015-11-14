package edu.umkc.dshoemaker.sane_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.UUID;

/**
 * Created by Rhonda on 11/13/2015.
 */
public class ResponseActivity extends SingleFragmentActivity {

    /** Called when the activity is first created */

    private static final String EXTRA_RESPONSE_ID =
            "edu.umkc.dshoemaker.sane_app.response_id";

    public static Intent newIntent(Context packageContext, UUID responseId) {
        Intent intent = new Intent(packageContext, ResponseActivity.class);
        intent.putExtra(EXTRA_RESPONSE_ID, responseId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID responseId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_RESPONSE_ID);
        return ResponseFragment.newInstance(responseId);
    }




}
