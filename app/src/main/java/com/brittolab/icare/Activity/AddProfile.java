package com.brittolab.icare.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.brittolab.icare.Database.UserProfileCRUD;
import com.brittolab.icare.Database.UserProfileTable;
import com.brittolab.icare.R;

public class AddProfile extends AppCompatActivity {


    EditText etName;
    EditText etAge;
    EditText etHeight;
    EditText etWeight;
    Spinner spnBloodGroup;
    RadioGroup mRadioGroup;
    RadioButton radioMale;
    RadioButton radiofeMale;
    //ImageView pickImage;


    String[] bloodGroupList = {"None","O-","O+","A-","A+","B-","B+","AB-","AB+"};
    ArrayAdapter<String> adapter;


    UserProfileTable userProfileTable;
    UserProfileCRUD userProfileCRUD;


    private String gender = "Male";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        initialize();
        userProfileCRUD = new UserProfileCRUD(getApplicationContext());
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bloodGroupList);
        spnBloodGroup.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioMale)
                    gender = "Male";
                else if(checkedId == R.id.radioFeMale)
                    gender = "Female";
            }
        });
    }

    private void initialize() {

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);
        mRadioGroup =(RadioGroup) findViewById(R.id.mRadioGroup);
        radioMale =(RadioButton) findViewById(R.id.radioMale);
        radiofeMale =(RadioButton) findViewById(R.id.radioFeMale);
        spnBloodGroup = (Spinner) findViewById(R.id.spnBloodGroup);
        //pickImage = (ImageView) findViewById(R.id.pickImage);

    }

    public void btnSaveClick(View v){

        if (!TextUtils.isEmpty(etName.getText()) && !TextUtils.isEmpty(etAge.getText()) && !TextUtils.isEmpty(etHeight.getText())
                && !TextUtils.isEmpty(etWeight.getText())){
                userProfileTable = new UserProfileTable(
                etName.getText().toString(),gender,
                Double.parseDouble(etAge.getText().toString()),
                Double.parseDouble(etHeight.getText().toString()),
                Double.parseDouble(etWeight.getText().toString()),
                spnBloodGroup.getSelectedItem().toString());

                long result = userProfileCRUD.insertIntoUserProfile(userProfileTable);

            if (result>0){
                Toast.makeText(getApplicationContext(),"Profile Successfully created",Toast.LENGTH_LONG).show();
                etName.setText("");
                etAge.setText("");
                etHeight.setText("");
                etWeight.setText("");
            }

        }else
            Toast.makeText(getApplicationContext(),"Please fill all field appropritely",Toast.LENGTH_LONG).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
