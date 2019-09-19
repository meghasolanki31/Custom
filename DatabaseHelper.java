package com.example.sqllitedatabase.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

import com.example.sqllitedatabase.model.UserModel;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static int DATABASE_VERSION = 1;
    public static String DATABASE_NAME = "std_database";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserModel.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(UserModel userModel) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();
       // contentValues.put(UserModel.KEY_USER_ID, userModel.id);
        contentValues.put(UserModel.KEY_NAME, userModel.name);
        contentValues.put(UserModel.KEY_EMAIL_ID, userModel.email);
        contentValues.put(UserModel.KEY_PASSWORD, userModel.password);
        contentValues.put(UserModel.KEY_ADDRESS, userModel.address);
        contentValues.put(UserModel.KEY_NUMBER, userModel.number);
        sqLiteDatabase.insert(UserModel.KEY_USER_TABLE, null, contentValues);

        sqLiteDatabase.close();
    }

    public ArrayList<UserModel> getAllUser() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ArrayList<UserModel> userlist = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + UserModel.KEY_USER_TABLE + "", null);

        if (cursor.moveToFirst()) {

            do {
                UserModel userModel = new UserModel();

                userModel.id = cursor.getInt(cursor.getColumnIndex(UserModel.KEY_USER_ID));
                userModel.name = cursor.getString(cursor.getColumnIndex(UserModel.KEY_NAME));
                userModel.email = cursor.getString(cursor.getColumnIndex(UserModel.KEY_EMAIL_ID));
                userModel.password = cursor.getString(cursor.getColumnIndex(UserModel.KEY_PASSWORD));
                userModel.address = cursor.getString(cursor.getColumnIndex(UserModel.KEY_ADDRESS));
                userModel.number = cursor.getString(cursor.getColumnIndex(UserModel.KEY_NUMBER));
                userlist.add(userModel);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return userlist;
    }

    public int updateNote(UserModel note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserModel.KEY_NUMBER, note.number);

        // updating row
        return db.update(UserModel.KEY_USER_TABLE, values, UserModel.KEY_USER_ID+ " = ?",
                new String[]{String.valueOf(note.id)});
    }


    public void deleteNote(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UserModel.KEY_USER_TABLE, UserModel.KEY_USER_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

}
