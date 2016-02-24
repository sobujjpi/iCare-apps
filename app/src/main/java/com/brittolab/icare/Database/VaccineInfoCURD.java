package com.brittolab.icare.Database;


        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;

        import java.util.ArrayList;

/**
 * Created by Ruhul_Amin on 1/17/2016.
 */
public class VaccineInfoCURD{
    private DBHandler handler;

    private SQLiteDatabase database;
    private VaccineInfoTable vaccineInfoTable;


    public VaccineInfoCURD(Context context){
       handler=new DBHandler(context);
    }
    private void open(){
        database=handler.getWritableDatabase();
    }
    private void close(){
        handler.close();
    }
    public boolean insert(VaccineInfoTable vaccineInfoTable){

        this.open();

        ContentValues values = new ContentValues();
        values.put(DBHandler.COL_VACCINE_NAME, vaccineInfoTable.getVaccineName());
        values.put(DBHandler.COL_VACCINE_DATE, vaccineInfoTable.getVaccineDate());
        values.put(DBHandler.COL_VACCINE_TIME, vaccineInfoTable.getVaccineTime());
        values.put(DBHandler.COL_VACCINE_DETAILS,vaccineInfoTable.getVaccineDetails());
        values.put(DBHandler.COL_VACCINE_ALERT,vaccineInfoTable.getVaccineAlert());

        long inserted=database.insert(DBHandler.TABLE_VACCINE_INFO,null,values);
        this.close();
        if(inserted>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean update(int vaccineId,VaccineInfoTable vaccineInfoTable){
        this.open();
        ContentValues values=new ContentValues();
        values.put(DBHandler.COL_VACCINE_NAME, vaccineInfoTable.getVaccineName());
        values.put(DBHandler.COL_VACCINE_DATE, vaccineInfoTable.getVaccineDate());
        values.put(DBHandler.COL_VACCINE_TIME, vaccineInfoTable.getVaccineTime());
        values.put(DBHandler.COL_VACCINE_DETAILS,vaccineInfoTable.getVaccineDetails());
        values.put(DBHandler.COL_VACCINE_ALERT,vaccineInfoTable.getVaccineAlert());
        int updated=database.update(DBHandler.TABLE_VACCINE_INFO, values, DBHandler.COL_VACCINE_ID + " = " + vaccineId, null);
        database.close();
        if (updated > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean delete(int vaccineId){
        this.open();
        int deleted=database.delete(DBHandler.TABLE_VACCINE_INFO, DBHandler.COL_VACCINE_ID + " = " + vaccineId, null);
        database.close();
        if(deleted>0){
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<VaccineInfoTable> getAllVaccineInfo(){

        ArrayList<VaccineInfoTable> vaccineList=new ArrayList<>();

        Cursor cursor=database.query(DBHandler.TABLE_VACCINE_INFO, null, null, null, null, null, null);
        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
                int vaccineId=cursor.getInt(cursor.getColumnIndex(DBHandler.COL_VACCINE_ID));
                String vaccineName=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_NAME));
                String vaccineDate=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_DATE));
                String vaccineTime=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_TIME));
                String vaccineDetails=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_DETAILS));
                String vaccineAlert=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_ALERT));
                vaccineInfoTable=new VaccineInfoTable(vaccineId,vaccineName,vaccineDate,vaccineTime,vaccineDetails,vaccineAlert);
                vaccineList.add(vaccineInfoTable);
                cursor.moveToNext();

            }
        }
        database.close();

        return vaccineList;

    }
    public VaccineInfoTable oneVaccineInfo(int vaccineId){
        this.open();

        Cursor cursor=database.query(DBHandler.TABLE_VACCINE_INFO,new String []{DBHandler.COL_VACCINE_ID,DBHandler.COL_VACCINE_NAME,DBHandler.COL_VACCINE_DETAILS},DBHandler.COL_DIET_ID+"= "+vaccineId,null,null,null,null);
        cursor.moveToFirst();

        int mId=cursor.getInt(cursor.getColumnIndex(DBHandler.COL_VACCINE_ID));
        String vaccineName=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_NAME));
        String vaccineDate=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_DATE));
        String vaccineTime=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_TIME));
        String vaccineDetails=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_DETAILS));
        String vaccineAlert=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_ALERT));

        vaccineInfoTable=new VaccineInfoTable(mId,vaccineName,vaccineDate,vaccineTime,vaccineDetails,vaccineAlert) ;
        database.close();
        return vaccineInfoTable;
    }



}
