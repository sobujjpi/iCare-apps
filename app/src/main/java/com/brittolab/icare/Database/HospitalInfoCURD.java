package com.brittolab.icare.Database;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class HospitalInfoCURD extends DBHandler {

    private SQLiteDatabase db;
    private SQLiteDatabase writableDatabase;

    public HospitalInfoCURD(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    public long insertIntoHospitalInfo(HospitalInfoTable hospitalInfoTable) {

        ContentValues values = new ContentValues();
        values.put(COL_HOSPITAL_ID, hospitalInfoTable.getHospitalID());
        values.put(COL_HOSPITAL_NAME, hospitalInfoTable.getHospitalName());
        values.put(COL_HOSPITAL_ADDRESS, hospitalInfoTable.getHospitalAddress());
        values.put(COL_HOS_PHONE, hospitalInfoTable.getHospitalPhone());
        db.insert(COL_HOS_REF_USER_ID, null, values);
        long result = db.insert(TABLE_HOSPITAL_INFO, null, values);
        return result;
    }
}

