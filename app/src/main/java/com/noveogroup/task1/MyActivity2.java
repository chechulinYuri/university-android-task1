package com.noveogroup.task1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.noveogroup.task1.R;

public class MyActivity2 extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);

        TextView firstNameView = (TextView) findViewById(R.id.firstNameLabel);
        TextView lastNameView = (TextView) findViewById(R.id.lastNameLabel);
        TextView bdayView = (TextView) findViewById(R.id.bdayLabel);

        firstNameView.setText(MyActivity.firstName);
        lastNameView.setText(MyActivity.lastName);
        bdayView.setText(MyActivity.bdayName);
    }
}
