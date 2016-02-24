package com.brittolab.icare.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Mobile App Develop on 7-1-16.
 */
public class UserProfileCRUD extends DBHandler {

    private SQLiteDatabase db;

    public UserProfileCRUD(Context context) {
        super(context);
        db = getWritableDatabase();
    }

    public long insertIntoUserProfile(UserProfileTable userProfileTable){

        ContentValues values = new ContentValues();
        values.put(COL_USER_NAME, userProfileTable.getUserName());
        values.put(COL_GENDER, userProfileTable.getGender());
        //values.put(COL_DOB, userProfileTable.getDateOfBirth());
        values.put(COL_AGE, userProfileTable.getAge());
        values.put(COL_BLOOD_GROUP, userProfileTable.getBloodGroup());
        values.put(COL_HEIGHT_CM, userProfileTable.getHeight());
        values.put(COL_WEIGHT_KG, userProfileTable.getWeight());
        long result = db.insert(TABLE_USER_PROFILE, null, values);
        return result;
    }

    public ArrayList<UserProfileTable> getAllUserNameAndId(Context context){


        ArrayList<UserProfileTable> userProfileList = new ArrayList<>();
        UserProfileTable userProfileTable ;

        String sql = "select * from " + TABLE_USER_PROFILE;
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                userProfileTable = new UserProfileTable(
                        cursor.getInt(cursor.getColumnIndex(COL_USER_ID)),
                        cursor.getString(cursor.getColumnIndex(COL_USER_NAME)),
                        cursor.getString(cursor.getColumnIndex(COL_GENDER)),
                        cursor.getDouble(cursor.getColumnIndex(COL_AGE)),
                        cursor.getString(cursor.getColumnIndex(COL_BLOOD_GROUP)),
                        cursor.getInt(cursor.getColumnIndex(COL_HEIGHT_CM)),
                        cursor.getInt(cursor.getColumnIndex(COL_WEIGHT_KG))
                );
                userProfileList.add(userProfileTable);
            }while (cursor.moveToNext());


        }

        return userProfileList;

    }
}
