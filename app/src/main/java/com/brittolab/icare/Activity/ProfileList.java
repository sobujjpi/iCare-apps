package com.brittolab.icare.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import com.brittolab.icare.Adapter.ArrayAdapterForUserList;
import com.brittolab.icare.Database.UserProfileCRUD;
import com.brittolab.icare.Database.UserProfileTable;
import com.brittolab.icare.R;

public class ProfileList extends AppCompatActivity {

    private ListView profileList;
    ArrayList<UserProfileTable> userProfileList;
    ArrayAdapterForUserList adapterForUserList;
    UserProfileCRUD userProfileCRUD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);
        initialize();
        userProfileCRUD = new UserProfileCRUD(getApplicationContext());

    }

    @Override
    protected void onResume() {
        super.onResume();

        userProfileList = userProfileCRUD.getAllUserNameAndId(getApplicationContext());

        if (!userProfileList.isEmpty()){

            adapterForUserList = new ArrayAdapterForUserList(getApplicationContext(),userProfileList);
            profileList.setAdapter(adapterForUserList);
        }

        profileList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DashBoard.class);
                intent.putExtra("user_id", userProfileList.get(position).getUserId());
                intent.putExtra("user_name", userProfileList.get(position).getUserName());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile_list, menu);
        return true;
    }

    public void btnAddClick(View v){
        Intent intent = new Intent(getApplicationContext(), AddProfile.class);
        startActivity(intent);
    }

    public void initialize(){
        profileList = (ListView) findViewById(R.id.profileList);
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
        }else if (id == R.id.action_add_profile){
            Intent intent = new Intent(getApplicationContext(), AddProfile.class);
            startActivity(intent);
            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

}
