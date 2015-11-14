package edu.umkc.dshoemaker.sane_app;

import android.support.v4.app.Fragment;

/**
 * Created by Rhonda on 11/13/2015.
 */
public class ResponseListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ResponseListFragment();
    }
}
