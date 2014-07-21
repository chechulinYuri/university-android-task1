package com.noveogroup.task1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.noveogroup.task1.R;

public class MyActivity extends ActionBarActivity {

    public static String firstName;
    public static String lastName;
    public static String bdayName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button loginButton = (Button) findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView firstNameView = (TextView) findViewById(R.id.firstNameView);
                TextView lastNameView = (TextView) findViewById(R.id.lastNameView);
                TextView bdayView = (TextView) findViewById(R.id.bdayView);

                firstName = firstNameView.getText().toString();
                lastName = lastNameView.getText().toString();
                bdayName = bdayView.getText().toString();

                Intent myIntent = new Intent(MyActivity.this, MyActivity2.class);
                MyActivity.this.startActivity(myIntent);
            }
        });
    }
}
