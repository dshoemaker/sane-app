package edu.umkc.dshoemaker.sane_app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class ReportActivity extends FragmentActivity {

    private Firebase myFire;
    private Button buttonSubmit;
    private Button buttonCancel;
    private EditText editID;
    private EditText editPW;
    private EditText editName;
    private EditText editAge;
    private RadioButton rb1;
    private RadioButton rb2;
    private String temp="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        Intent intent = getIntent();
        setContentView(R.layout.join);
    }

    protected void onStart(){
        super.onStart();

        myFire = new Firebase("https://sarahsane.firebaseio.com/android");
        buttonSubmit = (Button)findViewById(R.id.button);
        buttonCancel = (Button)findViewById(R.id.button2);
        editID = (EditText)findViewById(R.id.editText_ID);
        editPW = (EditText)findViewById(R.id.editText_PW);
        editName = (EditText)findViewById(R.id.editText_name);
        editAge = (EditText)findViewById(R.id.editText_age);
        rb1 = (RadioButton)findViewById(R.id.radioButton);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check radiobutton value.
                if(rb1.isChecked()){
                    temp=rb1.getText().toString();
                }else{
                    temp=rb2.getText().toString();

                }

                Account a1 = new Account(editID.getText().toString(), editPW.getText().toString(), editName.getText().toString(), editAge.getText().toString(), temp);
                sendQueryToFirebase(a1);
                initValues();
                Intent intent = new Intent(v.getContext(), RadialActivity.class);
                startActivity(intent);
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RadialActivity.class);
                startActivity(intent);
            }
        });
    }

    //send user information to firebase
    private void sendQueryToFirebase(Account account){
        Firebase ref = myFire.child("account");
        ref.push().setValue(account);
    }

    //after send clear values
    private void initValues(){
        editID.setText("");
        editPW.setText("");
        editName.setText("");
        editAge.setText("");
        temp = "";
    }

}
