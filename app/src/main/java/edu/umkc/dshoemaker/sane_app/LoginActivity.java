package edu.umkc.dshoemaker.sane_app;

/**
 * Created by Drew on 10/28/2015.
 */

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
    // User name
    private EditText et_Username;
    // Password
    private EditText et_Password;
    // Sign In
    private Button bt_SignIn;

    // Message
    private TextView tv_Message;

    // PIN Number
    private EditText et_PinNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialization
        //et_Username = (EditText) findViewById(R.id.et_Username);
        et_PinNumber = (EditText) findViewById(R.id.et_PinNumber);
        bt_SignIn = (Button) findViewById(R.id.bt_SignIn);
        tv_Message = (TextView) findViewById(R.id.tv_Message);

        bt_SignIn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                // Stores User name
                //String username = String.valueOf(et_Username.getText());
                // Stores Password
                String password = String.valueOf(et_PinNumber.getText());

                // Validates the User name and Password for admin, admin
                if (password.equals("1234")) {
                    tv_Message.setText("Login Successful!");
                } else {
                    tv_Message.setText("Login Unsuccessful!");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the login; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

}