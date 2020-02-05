package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addItemClick(View view) {

       // Intent intent = new Intent(MainActivity.this , AddNewItem.class);startActivity(intent);
    }


    public void deleteItem(View view) {

        Intent intent = new Intent(MainActivity.this , DeleteItem.class);
        startActivity(intent);
    }

    public void viewAllItem(View view) {
        Intent intent = new Intent(MainActivity.this , ToView.class);
        startActivity(intent);
    }

    public void createDemand(View view) {
    }

    public void updateItem(View view) {
        Intent intent = new Intent(MainActivity.this , UpdateStock.class);
        startActivity(intent);
    }
}













