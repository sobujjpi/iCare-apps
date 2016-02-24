package com.brittolab.icare.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.brittolab.icare.Database.DBHandler;
import com.brittolab.icare.Database.DietInfoCRUD;
import com.brittolab.icare.Database.DietInfoTable;
import com.brittolab.icare.Database.VaccineInfoCURD;
import com.brittolab.icare.Database.VaccineInfoTable;
import com.brittolab.icare.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddVaccine extends AppCompatActivity {
    private EditText vName;
    private TextView pickDate;
    private TextView pickTime;
    private EditText showDetail;
    private CheckBox setRemainder;
    private int mYear, mMonth, mDay;
    public int year,month,day,mHour,mMinute;

    private VaccineInfoTable vaccineInfoTable;
    private DBHandler handler;
    private VaccineInfoCURD vaccineInfoCURD;

    private Button btnSave;

    static final int DATE_DIALOG_ID=0;
    static final int TIME_DILOG_ID=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__vaccine);
        vName=(EditText)findViewById(R.id.vName);
        pickDate=(TextView)findViewById(R.id.pickDate);
        pickTime= (TextView) findViewById(R.id.pickTime);
        showDetail=(EditText)findViewById(R.id.showDetail);
        setRemainder=(CheckBox)findViewById(R.id.setRemainder);
        btnSave=(Button)findViewById(R.id.btnSave);

        handler=new DBHandler(this);
        vaccineInfoCURD=new VaccineInfoCURD(this);

        Calendar ca=Calendar.getInstance();
        mYear=ca.get(Calendar.YEAR);
        mMonth=ca.get(Calendar.MONTH);
        mDay=ca.get(Calendar.DAY_OF_MONTH);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vaccineName=vName.getText().toString();
                String vaccineDate=pickDate.getText().toString();
                String vaccineTime=pickTime.getText().toString();
                String vaccineDetails=showDetail.getText().toString();
                String vaccineAlert=setRemainder.getText().toString();
                vaccineInfoTable=new VaccineInfoTable(vaccineName,vaccineDate,vaccineTime,vaccineDetails,vaccineAlert);
                boolean inserted=vaccineInfoCURD.insert(vaccineInfoTable);
                if(inserted){
                    Toast.makeText(getApplicationContext(),"data inserted",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"please fill all information",Toast.LENGTH_LONG).show();
                }
            }
        });

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DILOG_ID);
            }
        });
        setRemainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE,"Diet Remainder" );
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My  House");
                GregorianCalendar calDate = new GregorianCalendar(mYear, mMonth,mDay);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        calDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        calDate.getTimeInMillis());

                startActivity(calIntent);

            }
        });
    }
    private DatePickerDialog.OnDateSetListener mDateSetlistener=
            new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    year = year;
                    month = monthOfYear+1;
                    day = dayOfMonth;
                    pickDate.setText(day + "-" + month + "-" + year);
                }
            };
    private TimePickerDialog.OnTimeSetListener onTimeSetListener=
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Calendar calendar= Calendar.getInstance();
                    calendar.set(0,0,0,hourOfDay,minute,0);
                    long timeInMillis=calendar.getTimeInMillis();
                    java.text.DateFormat dateFormat=new SimpleDateFormat("hh:mm a");
                    pickTime.setText(dateFormat.format(timeInMillis));
                }
            };
    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetlistener,mYear,mMonth,mDay);

            case TIME_DILOG_ID:
                return new TimePickerDialog(this,
                        onTimeSetListener,mHour,mMinute,false);
        }
        return null;
    }


}