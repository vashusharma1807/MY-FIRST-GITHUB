package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UpdateStock extends AppCompatActivity {

    String[] name ;
    String[] price ;
    ListView listView;

    SqlLiteClass db = new SqlLiteClass(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_stock);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         listView = (ListView) findViewById(R.id.orderlist);


        fillList();

        MyListAdapter adapter=new MyListAdapter(this, name,price);

        listView.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Toast.makeText(UpdateStock.this,"List Of id:="+id,Toast.LENGTH_LONG).show();


            }
        });


    }

    private void fillList() {

        Cursor res = db.viewName();
        ArrayList<String> nameA = new ArrayList<String>();
        ArrayList<String> priceA = new ArrayList<String>();


        if (res == null)
            Toast.makeText(this, "No Item To Show", Toast.LENGTH_SHORT).show();
        else {
            while (res.moveToNext()) {
                nameA.add(res.getString(1));
                priceA.add(res.getString(3));
            }
        }
        int size = nameA.size();
        name = new String[size];
        price = new String[size];


        for (int j = 0; j < nameA.size(); j++) {
            name[j] = nameA.get(j);
            price[j] = priceA.get(j);

        }
    }


}
