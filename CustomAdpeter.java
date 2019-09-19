package com.example.sqllitedatabase.adepters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqllitedatabase.R;
import com.example.sqllitedatabase.ShowDataActivity;
import com.example.sqllitedatabase.model.UserModel;

import java.util.ArrayList;

public class CustomAdpeter extends BaseAdapter {

    Context context;
    ArrayList<UserModel> modelArrayList;

    public CustomAdpeter(ShowDataActivity showDataActivity, ArrayList<UserModel> modelArrayList) {

        context = showDataActivity;
        this.modelArrayList = modelArrayList;
    }


    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.raw_activity_datashow,viewGroup,false);
        TextView txt_name = view1.findViewById(R.id.txt_name);
        TextView txt_number = view1.findViewById(R.id.txt_number);
        TextView txt_address = view1.findViewById(R.id.txt_address);
        TextView txt_email = view1.findViewById(R.id.txt_email);
        TextView txt_password = view1.findViewById(R.id.txt_password);

        txt_name.setText(modelArrayList.get(i).name);
        txt_number.setText(modelArrayList.get(i).number);
        txt_address.setText(modelArrayList.get(i).address);
        txt_email.setText(modelArrayList.get(i).email);
        txt_password.setText(modelArrayList.get(i).password);

        return view1;
    }
}
