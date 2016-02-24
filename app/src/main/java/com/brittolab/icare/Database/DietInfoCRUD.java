package com.brittolab.icare.Database;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;


public class DietInfoCRUD extends DBHandler  {


    private SQLiteDatabase database;
    private DietInfoTable dietInfoTable;

    public DietInfoCRUD(Context context) {
        super(context);
        database = getWritableDatabase();
    }

    public long insert(DietInfoTable dietInfoTable){

            ContentValues values = new ContentValues();
            values.put(COL_DIET_ID, dietInfoTable.getDietId());
            values.put(COL_DIET_TYPE, dietInfoTable.getDietType());
            values.put(COL_FOOD_MENU, dietInfoTable.getFoodMenu());
            values.put(COL_ALERM_TIME, dietInfoTable.getAlermTime());
            values.put(COL_ALERM_DATE, dietInfoTable.getAlermDate());

            long inserted = database.insert(TABLE_DIET_INFO, null, values);
            return inserted;
        }


    public boolean update(int dietId,DietInfoTable dietInfoTable){

        ContentValues values=new ContentValues();
        values.put(DBHandler.COL_DIET_ID, dietInfoTable.getUserId());
        values.put(DBHandler.COL_DIET_TYPE,dietInfoTable.getDietType());
        values.put(DBHandler.COL_FOOD_MENU,dietInfoTable.getFoodMenu());
        values.put(DBHandler.COL_ALERM_DATE,dietInfoTable.getAlermDate());
        values.put(DBHandler.COL_ALERM_TIME,dietInfoTable.getAlermTime());
        int updated=database.update(DBHandler.TABLE_DIET_INFO, values, DBHandler.COL_DIET_ID + " = " + dietId, null);
        database.close();
        if (updated > 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean delete(int dietId){

        int deleted=database.delete(DBHandler.TABLE_DIET_INFO, DBHandler.COL_DIET_ID + " = " + dietId, null);
        database.close();
        if(deleted>0){
            return true;
        }else{
            return false;
        }
    }
    public ArrayList<DietInfoTable> getAllDietInfo(Context context){

        ArrayList<DietInfoTable> dietList=new ArrayList<>();


        String sql = "select * from " + TABLE_DIET_INFO;
        Cursor cursor = database.rawQuery(sql,null);
        if (cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                dietInfoTable = new DietInfoTable(
                        cursor.getInt(cursor.getColumnIndex(COL_DIET_ID)),
                        cursor.getString(cursor.getColumnIndex(COL_DIET_TYPE)),
                        cursor.getString(cursor.getColumnIndex(COL_FOOD_MENU)),
                        cursor.getString(cursor.getColumnIndex(COL_ALERM_DATE)),
                        cursor.getString(cursor.getColumnIndex(COL_ALERM_TIME))

                );
                dietList.add(dietInfoTable);
            }while (cursor.moveToNext());


        }

        return dietList;
    }

}
