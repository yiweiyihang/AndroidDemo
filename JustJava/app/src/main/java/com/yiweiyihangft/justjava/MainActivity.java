package com.yiweiyihangft.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

     int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whippedCream_checkBox);
        CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.Chocolate_checkBox);
        boolean hasWippedCream = whippedCreamCheckBox.isChecked();
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int priceEach = getPriceEach(hasWippedCream,hasChocolate) ;
        int price = calculatePrice(quantity,priceEach);
        String name="";
        EditText nameEditText =(EditText)findViewById(R.id.name_EditText);
        name=nameEditText.getText().toString();
        String priceMessage = creatOrderSummary(hasWippedCream,hasChocolate,name,price);
        displayMessage(priceMessage);
    }

    public void increment(View view){
        quantity ++;
        display(quantity);
    }


    public void decrement(View view){
        if(quantity == 1){
            Toast.makeText(this,"You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity --;
        display(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public int getPriceEach(boolean addWippedCream,boolean addChocolate){
        int priceEach = 5;
        if(addWippedCream){
            priceEach +=1;
        }
        if(addChocolate){
            priceEach +=2;
        }
        return priceEach;
    }
    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     * @return total price
     */
    private int calculatePrice(int quantity,int priceEach) {
        int price = quantity * priceEach;
        return price;
    }

    /**
     * Creat Order Summary
     * @return
     */
    private String creatOrderSummary(boolean addWhippedCream,boolean addChocolate,String name,int price){
        String priceMessage ="Welcome  " + name + "!";
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nAdd Whipped Cream?" + addWhippedCream;
        priceMessage += "\nAdd Chocolate?" + addChocolate;
        priceMessage += "\nTotal $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

}