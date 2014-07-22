package com.noveogroup.task1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class LoginForm extends ActionBarActivity {

    public static String firstName;
    public static String lastName;
    public static int bDayDate;
    public static int bDayMonth;
    public static int bDayYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        Button loginButton = (Button) findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView firstNameView = (TextView) findViewById(R.id.firstNameView);
                TextView lastNameView = (TextView) findViewById(R.id.lastNameView);
                DatePicker datePicker = (DatePicker) findViewById(R.id.bday);

                bDayDate = datePicker.getDayOfMonth();
                bDayMonth = datePicker.getMonth();
                bDayYear =  datePicker.getYear();

                firstName = firstNameView.getText().toString();
                lastName = lastNameView.getText().toString();

                Intent myIntent = new Intent(LoginForm.this, OutputForm.class);
                LoginForm.this.startActivity(myIntent);
            }
        });
    }
}
