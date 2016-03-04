package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    int numberOfCoffees=0;

    public void increment(View view){

        displayQuantity(++numberOfCoffees);
    }

    public void decrement(View view){
        if (numberOfCoffees <= 0) return;
        displayQuantity(--numberOfCoffees);
    }

    public void submitOrder(View view) {
        displayQuantity(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
        Toast.makeText(MainActivity.this,"Thank You!", Toast.LENGTH_LONG).show();
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);;
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}