package com.brittolab.icare.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.brittolab.icare.Adapter.ArrayAdapterForUserList;
import com.brittolab.icare.Adapter.DietAdapter;
import com.brittolab.icare.Database.DBHandler;
import com.brittolab.icare.Database.DietInfoCRUD;
import com.brittolab.icare.Database.DietInfoTable;
import com.brittolab.icare.Database.UserProfileTable;
import com.brittolab.icare.R;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.brittolab.icare.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class AddDiet_Activity extends AppCompatActivity  {

    private TextView pickDate,pickTime;
    private EditText editMenu;
    private Spinner dietSpinner;
    private CheckBox setAlarm;
    private Button btnSave;
    private int UserId;

    AlarmManager am;
    DBHandler handler;
    DietInfoTable dietInfoTable;
    private DietInfoCRUD dietInfoCRUD;




    String diets[]= {"Select diet type", "Breakfast","Lunch","Dinner"};

    static final int DATE_DIALOG_ID=0;
    static final int TIME_DILOG_ID=1;
    public int year,month,day,hour,minute, mHour,mMinute;
    private int mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_diet_activity);

        initialize();

        dietInfoCRUD=new DietInfoCRUD(this);
        handler=new DBHandler(this);




        am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);

        ArrayAdapter<String> spinnerArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,diets);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dietSpinner.setAdapter(spinnerArrayAdapter);



        Calendar ca=Calendar.getInstance();
        mYear=ca.get(Calendar.YEAR);
        mMonth=ca.get(Calendar.MONTH);
        mDay=ca.get(Calendar.DAY_OF_MONTH);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty((CharSequence) dietSpinner.getSelectedItem()) && !TextUtils.isEmpty(editMenu.getText()) && !TextUtils.isEmpty(pickTime.getText())
                        && !TextUtils.isEmpty(pickDate.getText())){
                    dietInfoTable = new DietInfoTable(
                            dietSpinner.getSelectedItem().toString(),
                            editMenu.getText().toString(),
                            pickTime.getText().toString(),
                            pickDate.getText().toString());


                    long inserted = dietInfoCRUD.insert(dietInfoTable);

                    if (inserted>0){
                        Toast.makeText(getApplicationContext(),"Profile Successfully created",Toast.LENGTH_LONG).show();
                        dietSpinner.setSelection(Integer.parseInt("char"));
                        editMenu.setText("");
                        pickTime.setText("");
                        pickDate.setText("");
                    }

                }else
                    Toast.makeText(getApplicationContext(),"Diet information inserted",Toast.LENGTH_LONG).show();


            }



        });

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "Diet Remainder");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My  House");
                calIntent.putExtra(CalendarContract.Events.DESCRIPTION, dietSpinner + " with " + editMenu);

                GregorianCalendar calDate = new GregorianCalendar(mYear, mMonth, mDay);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        calDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        calDate.getTimeInMillis());

                startActivity(calIntent);

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


    }
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {


                public void onDateSet(DatePicker view, int yearSelected,
                                      int monthOfYear, int dayOfMonth) {
                    year = yearSelected;
                    month = monthOfYear+1;
                    day = dayOfMonth;

                    pickDate.setText(day + "-" + month + "-" + year);
                }
            };
    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener() {

                public void onTimeSet(TimePicker view, int hourOfDay, int min) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(0, 0, 0, hourOfDay, min, 0);
                    long timeInMillis = calendar.getTimeInMillis();
                    java.text.DateFormat dateFormatter = new SimpleDateFormat("hh:mm a");

                    pickTime.setText(dateFormatter.format(timeInMillis));


                }
            };

    protected Dialog onCreateDialog(int id){
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,mYear,mMonth,mDay);

            case TIME_DILOG_ID:
                return new TimePickerDialog(this,
                        mTimeSetListener,mHour,mMinute,false);
        }
        return null;
    }

    public void initialize(){
        pickDate=(TextView)findViewById(R.id.pickDate);
        pickTime=(TextView)findViewById(R.id.pickTime);
        dietSpinner=(Spinner)findViewById(R.id.dietSpinner);
        editMenu=(EditText)findViewById(R.id.editMenu);
        setAlarm=(CheckBox)findViewById(R.id.setAlarm);
        btnSave=(Button)findViewById(R.id.btnSave);

    }




}