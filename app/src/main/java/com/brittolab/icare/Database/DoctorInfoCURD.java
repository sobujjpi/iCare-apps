package com.brittolab.icare.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DoctorInfoCURD {

    private DBHandler handler;

    private SQLiteDatabase database;
    private DoctorInfoTable doctorInfoTable;


    public DoctorInfoCURD(Context context){
        handler=new DBHandler(context);
    }
    private void open(){
        database=handler.getWritableDatabase();
    }
    private void close(){
        handler.close();
    }
    public boolean insert(DoctorInfoTable doctorInfoTable){

        this.open();

        ContentValues values = new ContentValues();
        values.put(DBHandler.COL_DOCTOR_ID,doctorInfoTable.getDoctorId());
        values.put(DBHandler.COL_DR_NAME, doctorInfoTable.getDrName());
        values.put(DBHandler.COL_DR_SPECIALITY, doctorInfoTable.getDrSpeciality());
        values.put(DBHandler.COL_DR_CONTACT_NO, doctorInfoTable.getDrContactNo());
        values.put(DBHandler.COL_DR_APPOINTMENT_DATE, doctorInfoTable.getDrAppointmentDate());
        values.put(DBHandler.COL_DR_EMAIL, doctorInfoTable.getDrEmail());

        long inserted=database.insert(DBHandler.TABLE_DOCTOR_INFO,null,values);
        this.close();
        if(inserted>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean update(int doctorId,DoctorInfoTable doctorInfoTable){
        this.open();
        ContentValues values=new ContentValues();
        values.put(DBHandler.COL_DR_NAME, doctorInfoTable.getDrName());
        values.put(DBHandler.COL_DR_SPECIALITY, doctorInfoTable.getDrSpeciality());
        values.put(DBHandler.COL_DR_CONTACT_NO, doctorInfoTable.getDrContactNo());
        values.put(DBHandler.COL_DR_APPOINTMENT_DATE, doctorInfoTable.getDrAppointmentDate());
        values.put(DBHandler.COL_DR_EMAIL, doctorInfoTable.getDrEmail());
        int updated=database.update(DBHandler.TABLE_DOCTOR_INFO, values, DBHandler.COL_DOCTOR_ID + " = " + doctorId, null);
        database.close();
        if (updated > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean delete(int doctorId){
        this.open();
        int deleted=database.delete(DBHandler.TABLE_DOCTOR_INFO, DBHandler.COL_DOCTOR_ID + " = " + doctorId, null);
        database.close();
        if(deleted>0){
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<DoctorInfoTable> getAllDoctorInfo(){

        ArrayList<DoctorInfoTable> doctorList=new ArrayList<>();

        Cursor cursor=database.query(DBHandler.TABLE_DOCTOR_INFO, null, null, null, null, null, null);
        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            for(int i=0;i<cursor.getCount();i++){
                int doctorId=cursor.getInt(cursor.getColumnIndex(DBHandler.COL_DOCTOR_ID));
                String drName=cursor.getString(cursor.getColumnIndex(DBHandler.COL_DR_NAME));
                String drDetails=cursor.getString(cursor.getColumnIndex(DBHandler.COL_DR_SPECIALITY));
                String drAppointment=cursor.getString(cursor.getColumnIndex(DBHandler.COL_DR_APPOINTMENT_DATE));
                String drPhone=cursor.getString(cursor.getColumnIndex(DBHandler.COL_DR_CONTACT_NO));
                String drEmail=cursor.getString(cursor.getColumnIndex(DBHandler.COL_VACCINE_ALERT));
                doctorInfoTable=new DoctorInfoTable(doctorId,drName,drDetails,drAppointment,drPhone,drEmail);
                doctorList.add(doctorInfoTable);
                cursor.moveToNext();

            }
        }
        database.close();

        return doctorList;

    }
    public DoctorInfoTable oneDoctorInfo(int doctorId){
        this.open();

        Cursor cursor=database.query(DBHandler.TABLE_DOCTOR_INFO, new String[]{DBHandler.COL_DOCTOR_ID,
                        DBHandler.COL_DR_NAME, DBHandler.COL_DR_SPECIALITY, DBHandler.COL_DR_CONTACT_NO,
                        DBHandler.COL_DR_APPOINTMENT_DATE, DBHandler.COL_DR_EMAIL},
                DBHandler.COL_DIET_ID + "= " + doctorId, null, null, null, null);
        cursor.moveToFirst();

        int mId=cursor.getInt(cursor.getColumnIndex(DBHandler.COL_DOCTOR_ID));
        String drName=cursor.getString(cursor.getColumnIndex(DBHandler.COL_DR_NAME));
        String drDetails=cursor.getString(cursor.getColumnIndex(DBHandler.COL_DR_SPECIALITY));
        String drAppointment=cursor.getString(cursor.getColumnIndex(DBHandler.COL_DR_APPOINTMENT_DATE));
        String drPhone=cursor.getString(cursor.getColumnIndex(DBHandler.COL_DR_CONTACT_NO));
        String drEmail=cursor.getString(cursor.getColumnIndex(DBHandler.COL_DR_EMAIL));

        doctorInfoTable=new DoctorInfoTable(mId,drName,drDetails,drAppointment,drPhone,drEmail) ;
        database.close();
        return doctorInfoTable;
    }



}

