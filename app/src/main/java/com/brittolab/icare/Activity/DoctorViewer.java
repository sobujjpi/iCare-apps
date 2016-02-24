package com.brittolab.icare.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.brittolab.icare.R;

public class DoctorViewer extends AppCompatActivity {
    private TextView drName;
    private TextView drDetail;
    private TextView drDate;
    private TextView drPhone;
    private TextView drEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_viewer);

        init();
    }
public void init(){
    drName=(TextView)findViewById(R.id.drName);
    drDetail=(TextView)findViewById(R.id.drDetail);
    drDate=(TextView)findViewById(R.id.drDate);
    drPhone=(TextView)findViewById(R.id.drPhone);
    drEmail=(TextView)findViewById(R.id.drEmail);
}
}
