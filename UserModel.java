package com.example.sqllitedatabase.model;

public class UserModel {

    public static String KEY_USER_ID = "user_id";
    public static String KEY_NAME = "user_name";
    public static String KEY_EMAIL_ID = "user_email";
    public static String KEY_PASSWORD = "user_password";
    public static String KEY_NUMBER = "user_number";
    public static String KEY_ADDRESS = "user_address";


    public static String KEY_USER_TABLE = "user_tbl";

    public static String CREATE_TABLE = "create table " + KEY_USER_TABLE +
             " (" + KEY_USER_ID + " integer primary key autoincrement," +
            "" + KEY_NAME + " text," +
            "" + KEY_ADDRESS + " text," +
            "" + KEY_NUMBER + " text," +
            "" + KEY_EMAIL_ID + " text," +
            "" + KEY_PASSWORD + " text)";


    public int id;
    public String name;
    public String email;
    public String password;
    public String address;
    public String number;
}
