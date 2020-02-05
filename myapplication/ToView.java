package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToView extends AppCompatActivity {
    ListView listView ;
    SqlLiteClass db = new SqlLiteClass(this) ;


  /*  String[] maintitle ;
    String[] amount ;
    String[] price ;
    String[] detail;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      /*  listView = (ListView) findViewById(R.id.listView);


        fillList();

        MyListAdapter adapter=new MyListAdapter(this, maintitle, amount,price,detail);
        //listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

   /*private void fillList() {
        Cursor res = db.viewName();
        ArrayList<String> nameA = new ArrayList<String>();
        ArrayList<String> amountA = new ArrayList<String>();
        ArrayList<String> priceA = new ArrayList<String>();
        ArrayList<String> detailA = new ArrayList<String>();


       if (res==null)
            Toast.makeText(this,"No Item To Show",Toast.LENGTH_SHORT).show();
        else {
            while (res.moveToNext()) {
                nameA.add(res.getString(1));
                amountA.add(res.getString(2));
                priceA.add(res.getString(3));
                detailA.add("By: "+res.getString(5));

            }
        }
        int size = nameA.size();
        maintitle = new String[size];
        amount = new String[size];
        price = new String[size];
        detail = new String[size];


       for(int j =0;j<nameA.size();j++){
           maintitle[j] = nameA.get(j);
           amount[j] = amountA.get(j);
           price[j] = priceA.get(j);
           detail[j] = detailA.get(j);

       }
    }*/

}
