package com.example.aipexpertsqlitedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aipexpertsqlitedemo.utiles.SessionLoginActivity;

public class DashboardActivty extends AppCompatActivity {
    RecyclerView recyclerView;
    Button logout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_activty);

        recyclerView = findViewById(R.id.recycler_view);
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (logout.isClickable()) {
                    new SessionLoginActivity(DashboardActivty.this).UserLogut();
                    /*Intent intent = new Intent(DashboardActivty.this, MainActivity.class);
                    startActivity(intent);
                    */Intent i = new Intent(DashboardActivty.this, MainActivity.class);
// set the new task and clear flags
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }
                /* SharedPreferences sharedPreferences = getSharedPreferences("Logout", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("")
                editor.commit();
                finish();*/
            }
        });
    }
}
