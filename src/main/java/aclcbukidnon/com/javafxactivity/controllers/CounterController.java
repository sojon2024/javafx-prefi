package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CounterController {

    @FXML
    private Label labelCount;  // This will reference the Label in your FXML file

    private int count = 0;  // This will hold the current count value

    // This method will be called when the "+" button is clicked
    @FXML
    protected void onPlusClick() {
        count++;  // Increment the count
        labelCount.setText(String.valueOf(count));  // Update the label with the new count
    }

    // This method will be called when the "-" button is clicked
    @FXML
    protected void onMinusClick() {
        count--;  // Decrement the count
        labelCount.setText(String.valueOf(count));  // Update the label with the new count
    }
}