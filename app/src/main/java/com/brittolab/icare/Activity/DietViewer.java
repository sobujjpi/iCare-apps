package com.brittolab.icare.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.brittolab.icare.Adapter.DietAdapter;
import com.brittolab.icare.Database.DBHandler;
import com.brittolab.icare.Database.DietInfoCRUD;
import com.brittolab.icare.Database.DietInfoTable;
import com.brittolab.icare.R;

import java.util.List;

public class DietViewer extends AppCompatActivity {

    ListView dietList;
    DietInfoCRUD dietInfoCRUD;
    private List<DietInfoTable> dietInfoTable;
    private DietAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_viewer);
        dietList = (ListView) findViewById(R.id.dietList);

        dietInfoCRUD= new DietInfoCRUD(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

        dietInfoTable = dietInfoCRUD.getAllDietInfo(this);

        if (!dietInfoTable.isEmpty()) {

            mAdapter = new DietAdapter(getApplicationContext(), dietInfoTable);
            dietList.setAdapter(mAdapter);
        }

        dietList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AddDiet_Activity.class);
                intent.putExtra("diet_id", dietInfoTable.get(position).getDietId());
                intent.putExtra("breakfast", dietInfoTable.get(position).getDietType());
                intent.putExtra("food_menu", dietInfoTable.get(position).getFoodMenu());
                intent.putExtra("time", dietInfoTable.get(position).getAlermTime());
                intent.putExtra("date", dietInfoTable.get(position).getAlermDate());
                startActivity(intent);
            }
        });


    }

}
