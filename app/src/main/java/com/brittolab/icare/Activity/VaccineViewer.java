package com.brittolab.icare.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.brittolab.icare.R;

public class VaccineViewer extends AppCompatActivity {
    private TextView txtPolio;
    private TextView txtDetail;
    private TextView txtTime;
    private TextView txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_viewer);

      init();
    }
    public void init(){
        txtPolio=(TextView)findViewById(R.id.txtPolio);
        txtDetail=(TextView)findViewById(R.id.txtDetail);
        txtTime=(TextView)findViewById(R.id.txtTime);
        txtDate=(TextView)findViewById(R.id.txtDate);

    }

}
