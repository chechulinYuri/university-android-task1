package com.noveogroup.task1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class OutputForm extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output_form);

        Intent mIntent = getIntent();
        Bundle extras = mIntent.getExtras();

        TextView firstNameView = (TextView) findViewById(R.id.firstNameLabel);
        TextView lastNameView = (TextView) findViewById(R.id.lastNameLabel);
        TextView bdayView = (TextView) findViewById(R.id.bdayLabel);
        Integer age = getAge(extras.getInt(LoginForm.BDYEAR), extras.getInt(LoginForm.BDMONTH), extras.getInt(LoginForm.BDDATE));

        firstNameView.setText(extras.getString(LoginForm.FNAME));
        lastNameView.setText(extras.getString(LoginForm.LNAME));
        bdayView.setText(age.toString());
    }

    private Integer getAge(int year, int month, int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        return age;
    }
}
