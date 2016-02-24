package com.brittolab.icare.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.brittolab.icare.Database.DBHandler;
import com.brittolab.icare.Database.DoctorInfoCURD;
import com.brittolab.icare.Database.DoctorInfoTable;
import com.brittolab.icare.Database.VaccineInfoCURD;
import com.brittolab.icare.Database.VaccineInfoTable;
import com.brittolab.icare.R;

import java.util.Calendar;

public class AddDoctor extends AppCompatActivity {

    private EditText editName;
    private EditText editDetails;
    private TextView txtAppointment;
    private EditText editPhone;
    private EditText editEmail;

    private DoctorInfoTable doctorInfoTable;
    private DBHandler handler;
    private DoctorInfoCURD doctorInfoCURD;

    static final int DATE_DIALOG_ID=0;
    public int year,month,day,hour,minute, mHour,mMinute;
    private int mYear, mMonth, mDay;

    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);
        editName=(EditText)findViewById(R.id.editName);
        editDetails=(EditText)findViewById(R.id.editDetails);
        txtAppointment=(TextView)findViewById(R.id.txtAppointment);
        editPhone=(EditText)findViewById(R.id.editPhone);
        editEmail=(EditText)findViewById(R.id.editEmail);
        btnSave=(Button)findViewById(R.id.btnSave);

        handler=new DBHandler(this);
        doctorInfoCURD=new DoctorInfoCURD(this);

        Calendar ca=Calendar.getInstance();
        mYear=ca.get(Calendar.YEAR);
        mMonth=ca.get(Calendar.MONTH);
        mDay=ca.get(Calendar.DAY_OF_MONTH);



        btnSave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String drName=editName.getText().toString();
                 String drDetails=editDetails.getText().toString();
                 String drAppointment=txtAppointment.getText().toString();
                 String drPhone=editPhone.getText().toString();
                 String drEmail=editEmail.getText().toString();
                 doctorInfoTable=new DoctorInfoTable(drName,drDetails,drAppointment,drPhone,drEmail);
                 boolean inserted=doctorInfoCURD.insert(doctorInfoTable);

                 if(inserted){
                     Toast.makeText(getApplicationContext(), "data inserted", Toast.LENGTH_LONG).show();
                 }else {
                     Toast.makeText(getApplicationContext(),"please fill all information",Toast.LENGTH_LONG).show();
                 }

             }
         });
        txtAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(DATE_DIALOG_ID);
            }
        });

    }
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {


                public void onDateSet(DatePicker view, int yearSelected,
                                      int monthOfYear, int dayOfMonth) {
                    year = yearSelected;
                    month = monthOfYear+1;
                    day = dayOfMonth;

                    txtAppointment.setText(day + "-" + month + "-" + year);
                }
            };
    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,mYear,mMonth,mDay);
        }
        return null;
    }

}
