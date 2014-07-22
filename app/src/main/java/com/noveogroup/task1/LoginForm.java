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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        Button loginButton = (Button) findViewById(R.id.loginBtn);
        DatePicker dp = (DatePicker) findViewById(R.id.bday);
        dp.setMaxDate(new Date().getTime());

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView firstNameView = (TextView) findViewById(R.id.firstNameView);
                TextView lastNameView = (TextView) findViewById(R.id.lastNameView);
                DatePicker datePicker = (DatePicker) findViewById(R.id.bday);

                int bDayDate = datePicker.getDayOfMonth();
                int bDayMonth = datePicker.getMonth();
                int bDayYear =  datePicker.getYear();
                String firstName = firstNameView.getText().toString();
                String lastName = lastNameView.getText().toString();

                Intent myIntent = new Intent(LoginForm.this, OutputForm.class);

                Bundle mBundle = new Bundle();
                mBundle.putString("firstName", firstName);
                mBundle.putString("lastName", lastName);
                mBundle.putInt("bDayDate", bDayDate);
                mBundle.putInt("bDayMonth", bDayMonth);
                mBundle.putInt("bDayYear", bDayYear);

                myIntent.putExtras(mBundle);

                LoginForm.this.startActivity(myIntent);
            }
        });
    }
}
