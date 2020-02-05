package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteItem extends AppCompatActivity {
    EditText del_edittext2;
    Button del_button;
    SqlLiteClass db = new SqlLiteClass(this);
    String str ;
    DeleteItem obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        del_edittext2=(EditText)findViewById(R.id.del_editText2);
        del_button=(Button)findViewById(R.id.del_button);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    int count;
    public  void delitem(View view){
        count=db.deleteRow(del_edittext2.getText().toString());
        if(count!=0){
            Toast.makeText(this,"item deleted"+count,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(DeleteItem.this ,MainActivity.class );
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"no item found",Toast.LENGTH_LONG).show();
        }
    }


}
