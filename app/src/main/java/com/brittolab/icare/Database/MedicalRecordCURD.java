package com.brittolab.icare.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MedicalRecordCURD extends DBHandler {

    private SQLiteDatabase db;

    public MedicalRecordCURD(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    public void insertIntoMedicalRecord(MedicalRecordTable medicalRecordTable) {

        ContentValues values = new ContentValues();
        values.put(COL_MED_RECORD_ID, medicalRecordTable.getMedRecId());
        values.put(COL_VISIT_DATE, medicalRecordTable.getVisitDate());
        values.put(COL_PROBLEM_SUMMARY, medicalRecordTable.getProblemSummary());
        values.put(COL_PRESCRIPTION_PHOTO, String.valueOf(medicalRecordTable.getPrescriptionPhoto()));
        values.put(COL_MED_REF_USER_ID, medicalRecordTable.getRefUserId());
        db.insert(COL_DI_REF_USER_ID, null, values);
    }
}
