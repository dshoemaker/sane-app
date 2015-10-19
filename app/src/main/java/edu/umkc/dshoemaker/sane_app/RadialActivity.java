package edu.umkc.dshoemaker.sane_app;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class RadialActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText( this, R.string.click_the_button, Toast.LENGTH_LONG).show();
    }
}