package edu.umkc.dshoemaker.sane_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.userapp.client.android.AuthFragment;

/**
* Created by Drew on 10/28/2015.
*/
public class LoginFragment extends AuthFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        // Setup the login form with bindings to UserApp
        super.setupLoginForm(view, R.id.login, R.id.password, R.id.login_button);

        return view;
    }

    @Override
    public Boolean onLoginStart(String login, String password, Boolean isSocialLogin) {
        // Show loader when waiting for server
        getView().findViewById(R.id.login_form).setVisibility(View.GONE);
        getView().findViewById(R.id.login_status).setVisibility(View.VISIBLE);

        // Return true to complete the login
        return true;
    }

    @Override
    public void onLoginCompleted(Boolean authenticated, Exception exception) {
        // Hide the loader
        getView().findViewById(R.id.login_form).setVisibility(View.VISIBLE);
        getView().findViewById(R.id.login_status).setVisibility(View.GONE);

        if (exception != null) {
            // Show an error message
            ((TextView) getView().findViewById(R.id.error_text)).setText(exception.getMessage());
        } else {
            // Clear the message
            ((TextView) getView().findViewById(R.id.error_text)).setText("");
        }
    }
}