package com.example.aipexpertsqlitedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aipexpertsqlitedemo.Database.DataBaseHelper;
import com.example.aipexpertsqlitedemo.Models.UserModel;
import com.example.aipexpertsqlitedemo.utiles.SessionLoginActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtLoginemail, edtLoginPassword;
    TextView txtLogin;
    Button btn_Login, btnNext;
    DataBaseHelper dataBaseHelper;
    Cursor cursor;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtLoginemail = findViewById(R.id.LoginEmail);
        edtLoginPassword = findViewById(R.id.LoginPassword);
        btn_Login = findViewById(R.id.LoginBtn);
        btnNext = findViewById(R.id.btnNext);

        txtLogin = findViewById(R.id.txtSignIn);
        dataBaseHelper = new DataBaseHelper(MainActivity.this);
        sqLiteDatabase = dataBaseHelper.getReadableDatabase();

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Patterns.EMAIL_ADDRESS.matcher(edtLoginemail.getText().toString()).matches() && !(edtLoginPassword.getText().toString().isEmpty())) {
                    String email = edtLoginemail.getText().toString();
                    String pwd = edtLoginPassword.getText().toString();
                    cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + UserModel.KEY_USER_TABLE +
                            " WHERE " + UserModel.KEY_EMAIL_ID + " =? AND " + UserModel.KEY_PASSWORD + "=?",
                            new String[]{email, pwd});
                    if (cursor != null) {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            String email_ = cursor.getString(cursor.getColumnIndex(UserModel.KEY_EMAIL_ID));
                            String pwds = cursor.getString(cursor.getColumnIndex(UserModel.KEY_PASSWORD));
                            new SessionLoginActivity(MainActivity.this).setIsLogin(true);

                            Toast.makeText(MainActivity.this, "Login SuccessFully ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, DashboardActivty.class);
                            startActivity(intent);

                        } else {
                            aletrDialog();
                            /*//I am showing Alert Dialog Box here for alerting user about wrong credentials
                            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Alert");
                            builder.show();
                            builder.setMessage("Username or Password is wrong.");
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    dialogInterface.dismiss();

                                }
                            });
*/
                        }
                    }
                }


            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);

            }
        });
    }

    void aletrDialog() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setMessage("Username or Password is wrong.");

        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                // Toast.makeText(MainActivity.this, "Test Passed", Toast.LENGTH_SHORT).show();
            }
        });
       /* dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });*/
        dialog.show();
        dialog.setTitle("Test");

    }

}
