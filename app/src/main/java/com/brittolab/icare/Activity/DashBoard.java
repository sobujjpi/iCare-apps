package com.brittolab.icare.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.brittolab.icare.R;

public class DashBoard extends AppCompatActivity {


    TextView tvProfileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        tvProfileName = (TextView) findViewById(R.id.tvUserName);
    }
    public void btnAddVaccineClick(View view){
        Intent intent=new Intent(DashBoard.this,AddVaccine.class);
        startActivity(intent);
    }
    public void btnDietChartClick(View view){
        Intent intent=new Intent(DashBoard.this,AddDiet_Activity.class);
        startActivity(intent);
    }
    public void btnAddDoctorInfoClick(View view){
        Intent intent=new Intent(DashBoard.this,AddDoctor.class);
        startActivity(intent);
    }
}
