package com.vic3e.app.oktamaterial;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.okta.appauth.android.OktaAppAuth;

import net.openid.appauth.AuthorizationException;

public class OktaLogin extends AppCompatActivity {

    private OktaAppAuth mOktaAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // setContentView(R.layout.activity_okta_login);
        mOktaAuth = OktaAppAuth.getInstance(this);
       //setContentView(R.layout.activity_okta_login);

        // Do any of your own setup of the Activity
    //    findViewById(R.id.start_auth).setOnClickListener((View view) -> onSuccess());
        mOktaAuth.init(
                this,
                new OktaAppAuth.OktaAuthListener() {
                    @Override
                    public void onSuccess() {
                      //  Intent i = new Intent(this, MainActivity.class);
                       // startActivity(i);
                        // Handle a successful initialization (e.g. display login button)
                        Toast.makeText(getApplicationContext(), "Success",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onTokenFailure(@NonNull AuthorizationException ex) {
                        // Handle a failed initialization
                        Toast.makeText(getApplicationContext(), "Fail",
                                Toast.LENGTH_LONG).show();
                    }
                }
        );
        setContentView(R.layout.activity_okta_login);
        findViewById(R.id.start_auth).setOnClickListener((View view) -> onSuccess());
    }
    public void onSuccess() {
        // Handle a successful initialization (e.g. display login button)

        Intent completionIntent = new Intent(this, MainActivity.class);
        Intent cancelIntent = new Intent(this, RandomActivity.class);
        cancelIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        mOktaAuth.login(
                this,
                PendingIntent.getActivity(this, 0, completionIntent, 0),
                PendingIntent.getActivity(this, 0, cancelIntent, 0)
        );
    }
    @TargetApi(Build.VERSION_CODES.M)
    @SuppressWarnings("deprecation")
    private int getColorCompat(@ColorRes int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getColor(color);
        } else {
            return getResources().getColor(color);
        }
    }

}

