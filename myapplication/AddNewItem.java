package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewItem extends AppCompatActivity {
    EditText name ,amount , price , detail , dealerName;
    Button button ;
    SqlLiteClass db = new SqlLiteClass(this);
    String str ;
    AddNewItem obj ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name=(EditText) findViewById(R.id.itemNameValue);
        amount=(EditText) findViewById(R.id.itemAmountValue);
        price=(EditText) findViewById(R.id.itemPriceValue);
        detail=(EditText) findViewById(R.id.itemDetailValue);
        dealerName=(EditText) findViewById(R.id.itemDealerValue);
        button=(Button) findViewById(R.id.addButton);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.viewAll( AddNewItem.this );
            }
        });
    }

    public void addItem(View view) {

        boolean isInserted = db.insert(name.getText().toString(),amount.getText().toString(), price.getText().toString() ,detail.getText().toString(),dealerName.getText().toString());
        if(isInserted)
        {
            //str = db.view(name.getText().toString());
            //obj.showMessage("Item Added:",str);
            Toast.makeText(this,"Item Inserted" , Toast.LENGTH_LONG).show();
            //db.viewAll(this);
            resetButton();
            Intent intent = new Intent(AddNewItem.this ,MainActivity.class );
            startActivity(intent);

        }
        else
            Toast.makeText(this,"Item Not Inserted" , Toast.LENGTH_LONG).show();
    }

    private void resetButton() {

        name.setText(null);
        amount.setText(null);
        price.setText(null);
        detail.setText(null);
        dealerName.setText(null);
    }


    public void showMessage(String title , String message) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setCancelable(true);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.show();
    }
}
