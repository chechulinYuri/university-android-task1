package com.noveogroup.task1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;

public class LoginForm extends ActionBarActivity {

    public static final String FNAME = "FNAME";
    public static final String LNAME = "LNAME";
    public static final String BDDATE = "BDDATE";
    public static final String BDMONTH = "BDMONTH";
    public static final String BDYEAR = "BDYEAR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);

        // Set max date for datepicker
        Button loginButton = (Button) findViewById(R.id.loginBtn);
        DatePicker dp = (DatePicker) findViewById(R.id.bday);
        dp.setMaxDate(new Date().getTime());


        // Hide keyboard
        final EditText editText = (EditText) findViewById(R.id.lastNameView);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                }
            }
        });


        // Button handler
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
                mBundle.putString(FNAME, firstName);
                mBundle.putString(LNAME, lastName);
                mBundle.putInt(BDDATE, bDayDate);
                mBundle.putInt(BDMONTH, bDayMonth);
                mBundle.putInt(BDYEAR, bDayYear);

                myIntent.putExtras(mBundle);

                LoginForm.this.startActivity(myIntent);
            }
        });
    }
}
