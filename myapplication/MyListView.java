package com.example.myapplication;


import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] name;
    private final String[] priceValue;


    public MyListAdapter(Activity context, String[] name, String[] priceValue) {
        super(context, R.layout.orderlist, name);
        this.context = context;
        this.name = name;
        this.priceValue = priceValue;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.orderlist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.name);
        TextView priceText = (TextView) rowView.findViewById(R.id.priceValue);

        titleText.setText(name[position]);
        priceText.setText("Rs. "+priceValue[position]);

        TextView name = (TextView) rowView.findViewById(R.id.name);

        Button minusButton = (Button)rowView.findViewById(R.id.button_Dec);
        final EditText quantity = (EditText) rowView.findViewById(R.id.current_quantity) ;
        Button plusButton = (Button)rowView.findViewById(R.id.button_Inc);
        final TextView price = (TextView) rowView.findViewById(R.id.price);
        TextView pricevalue = (TextView) rowView.findViewById(R.id.priceValue);


        final float priceValue=Float.parseFloat(pricevalue.getText().toString());
        //float Price=Float.parseFloat(price.getText().toString());
        final float Quantity =Float.parseFloat(quantity.getText().toString());

        price.setText(Float.toString(priceValue*Quantity));


        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity.setText(Float.toString(Quantity+1));

            }
        });
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity.setText(Float.toString(Quantity-1));

            }
        });
        return rowView;

    };

}