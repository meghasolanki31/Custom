package com.example.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqllitedatabase.Database.DatabaseHelper;
import com.example.sqllitedatabase.model.UserModel;

import java.util.ArrayList;


public class InsertDataActivity extends AppCompatActivity {

    ArrayList<UserModel> studetnlist = new ArrayList<>();
    EditText ed_name, ed_number, ed_address, ed_email, ed_password;
    DatabaseHelper databaseHelper;


    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);


        ed_name = findViewById(R.id.edt_name);
        ed_number = findViewById(R.id.edt_number);
        ed_address = findViewById(R.id.edt_address);
        ed_email = findViewById(R.id.edt_email);
        ed_password = findViewById(R.id.edt_password);
        btnSubmit = findViewById(R.id.btnClick);

        databaseHelper = new DatabaseHelper(InsertDataActivity.this);
        studetnlist = databaseHelper.getAllUser();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserModel userModel = new UserModel();
                userModel.name = ed_name.getText().toString();
                userModel.email = ed_email.getText().toString();
                userModel.password = ed_password.getText().toString();
                userModel.number = ed_number.getText().toString();
                userModel.address = ed_address.getText().toString();


                databaseHelper.insertData(userModel);
            }
        });


    }
}
