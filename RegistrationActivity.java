package com.example.aipexpertsqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aipexpertsqlitedemo.Database.DataBaseHelper;
import com.example.aipexpertsqlitedemo.Models.UserModel;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {
    EditText edtName, edtNumber, edtEmail, edtPassword;
    Button btnSignIn;
    TextView txtRegi;
    DataBaseHelper dataBaseHelper;
    ArrayList<UserModel> userModelsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edtName = findViewById(R.id.RegiName);
        edtNumber = findViewById(R.id.RegiNumber);
        edtEmail = findViewById(R.id.RegiEmail);
        edtPassword = findViewById(R.id.RegiPassword);
        btnSignIn = findViewById(R.id.RegiBtn);
        txtRegi = findViewById(R.id.txtSignIn);

        dataBaseHelper = new DataBaseHelper(RegistrationActivity.this);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel = new UserModel();
                userModel.name = edtName.getText().toString();
                userModel.number = edtNumber.getText().toString();
                userModel.email = edtEmail.getText().toString();
                userModel.password = edtPassword.getText().toString();

                dataBaseHelper.insertDAta(userModel);
                userModelsList.addAll(dataBaseHelper.getAllUsers());

                for (int i = 0; i < userModelsList.size(); i++) {
                    // Log.e("id", " " + userModelsList.get(i).id);
                    Log.e("Name", " " + userModelsList.get(i).name);
                    Log.e("Emailid", " " + userModelsList.get(i).email);
                    Log.e("PWD", " " + userModelsList.get(i).password);
                    Log.e("NUMBER", " " + userModelsList.get(i).number);


                }
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
                //Log.e("", "onClick: ",userModel.name );
            }
        });


    }
}
