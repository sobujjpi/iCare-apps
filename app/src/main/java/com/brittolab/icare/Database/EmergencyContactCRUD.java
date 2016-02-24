

package com.brittolab.icare.Database;
        import android.content.ContentValues;
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;

public class EmergencyContactCRUD extends DBHandler {

    private SQLiteDatabase db;
    private SQLiteDatabase writableDatabase;

    public EmergencyContactCRUD(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    public long insertIntoEmegrencyContact(EmergencyContactTable emergencyContactTable) {

        ContentValues values = new ContentValues();
        values.put(COL_EMRG_ID, emergencyContactTable.getEmrgId());
        values.put(COL_EMRG_NAME, emergencyContactTable.getEmrgName());
        values.put(COL_RELATION, emergencyContactTable.getContactNo());
        values.put(COL_CONTACT_NO, emergencyContactTable.getRelation());
        db.insert(COL_EMRG_REF_USER_ID, null, values);
        long result = db.insert(TABLE_EMERGENCY_CONTACT, null, values);
        return result;
    }
}