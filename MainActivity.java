package com.example.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sqllitedatabase.Database.DatabaseHelper;
import com.example.sqllitedatabase.model.UserModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShow;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertDataActivity.class);
                startActivity(intent);
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, ShowDataActivity.class);
                startActivity(in);
            }
        });

        databaseHelper = new DatabaseHelper(MainActivity.this);



     /*   UserModel userModel = new UserModel();
        userModel.name = "Megha Solanki";
        userModel.email = "megha@gmail.com";
        userModel.password = "123456789";

        databaseHelper.insertData(userModel);
*/
        ArrayList<UserModel> arrayList = new ArrayList<>();
        arrayList.addAll(databaseHelper.getAllUser());
    }
}
