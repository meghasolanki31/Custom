package com.example.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.sqllitedatabase.Database.DatabaseHelper;
import com.example.sqllitedatabase.adepters.CustomAdpeter;
import com.example.sqllitedatabase.model.UserModel;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {
ListView listView;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        listView=findViewById(R.id.CusList);
        databaseHelper = new DatabaseHelper(ShowDataActivity.this);
        ArrayList<UserModel> arrayList = new ArrayList<>();
        arrayList.addAll(databaseHelper.getAllUser());

        CustomAdpeter customAdpeter=new CustomAdpeter(ShowDataActivity.this,arrayList);
        listView.setAdapter(customAdpeter);

      //  databaseHelper.deleteNote(1);

        UserModel userModel = new UserModel();
        userModel = arrayList.get(1);

        userModel.number = "0000000000";

        databaseHelper.updateNote(userModel);

    }
}
