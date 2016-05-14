package com.example.sayyanag.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view){
        //Find the User's Name
        EditText name = (EditText) findViewById(R.id.name);
        String customerName = name.getText().toString();

        //Figure out whether User wants the Whipped Cream Topping
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_Cream);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        //Figure out whether User wants the Chocolate Topping
        CheckBox chocolateToppingsCheckbox = (CheckBox) findViewById(R.id.chocolate_toppings);
        boolean hasChocolate = chocolateToppingsCheckbox.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage = createOrderSummary(customerName, price, hasWhippedCream, hasChocolate);
        //displayMessage(priceMessage);

        composeEmail(null,customerName,priceMessage);

    }

    public void composeEmail(String[] addresses, String subject,String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for "+subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /* Calculates the price of the Order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants Chocolate topping
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate){
        int basePrice =5;
        if(addWhippedCream){
            basePrice +=1;
        }
        if(addChocolate){
            basePrice +=1;
        }
        //Calculates the totalOrder by multiplying the BasePrice with Quantity
        return quantity * basePrice;
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * @param name is name of the user as input
     * @param price of order as input
     * @param hasWhippedCream boolean variable to specify checkbox status as input
     * @param hasChocolate boolean variable to specify checkbox status as input
     * @return order summary as string
     */
    private String createOrderSummary(String name, int price, boolean hasWhippedCream, boolean hasChocolate){
        String orderSummary = "Name: "+name;
        if(hasWhippedCream)
            orderSummary+= "\nAdd whipped cream? true";
        else
            orderSummary+="\nAdd whipped cream? false";
        if(hasChocolate)
            orderSummary+="\nAdd Chocolate? true";
        else
            orderSummary+="\nAdd Chocolate? false";
        orderSummary+="\nQuantity: "+quantity;
        orderSummary+="\nTotal $"+price+"\nThank You!";
        return orderSummary;
    }

    private String getWhippedCreamIsChecked(){
        String isCheckedMessage = null;
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_Cream);
        if(whippedCreamCheckbox.isChecked())
            isCheckedMessage = "Add whipped cream? true";
        else
            isCheckedMessage = "Add whipped cream? false";
        //Log.v("MainActivity","WhippedCream is checked "+whippedCreamCheckbox.isChecked());
        return isCheckedMessage;
    }
    private String getChocolateToppingsIsChecked(){
        String isCheckedMessage =null;
        CheckBox chocolateToppingsCheckbox = (CheckBox) findViewById(R.id.chocolate_toppings);
        if(chocolateToppingsCheckbox.isChecked())
            isCheckedMessage = "Add Chocolate? true";
        else
            isCheckedMessage= "Add chocolate? false";
        return isCheckedMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number){
        TextView quantityTextView= (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    /**
     * This method increments the quantity
     */
    public void incrementQuantity(View view){
        if(quantity==100){
            Toast.makeText(this,"Cups of Coffee cannot exceed 100 per Order", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity +1;
        display(quantity);
    }
    /**
     * This method decrements the quantity
     */
    public void decrementQuantity(View view){
        if(quantity==1){
            Toast.makeText(this,"Cups of Coffee cannot be below 1 per Order", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }
}
