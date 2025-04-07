package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class CalculatorController {

    @FXML
    private Label display;  // Label that displays the current input/output

    private String currentInput = "";  // To store the current input string
    private double firstOperand = 0;   // First operand for calculation
    private String operator = "";      // Operator (+, -, *, /)
    private boolean isResultDisplayed = false;  // Flag to check if result is displayed

    // This method handles button clicks (number and operator buttons)
    @FXML
    public void handleButtonClick(javafx.event.ActionEvent event) {
        if (isResultDisplayed) {
            currentInput = "";  // Clear current input if result is displayed
            isResultDisplayed = false;
        }

        Button clickedButton = (Button) event.getSource();
        String buttonValue = clickedButton.getText();

        // If the user presses a number or operator, append it to the current input
        currentInput += buttonValue;
        display.setText(currentInput);
    }

    // This method handles the "CLEAR" button to reset the calculator
    @FXML
    public void handleClear() {
        currentInput = "";
        display.setText("0");
        firstOperand = 0;
        operator = "";
    }

    // This method handles the "BACKSPACE" button to remove the last character
    @FXML
    public void handleBackspace() {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            display.setText(currentInput.isEmpty() ? "0" : currentInput);
        }
    }

    // This method handles the "=" button to calculate the result
    @FXML
    public void handleEqualsClick() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            double result = 0;

            // Perform the calculation based on the selected operator
            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }

            // Display the result and set it as the current input for further operations
            display.setText(String.valueOf(result));
            isResultDisplayed = true;
            currentInput = String.valueOf(result);  // Use result as input for next calculation
        }
    }

    // This method handles operator buttons (+, -, *, /)
    @FXML
    public void handleOperatorClick(javafx.event.ActionEvent event) {
        if (!currentInput.isEmpty()) {
            firstOperand = Double.parseDouble(currentInput);
            operator = ((Button) event.getSource()).getText();  // Store the operator
            currentInput = "";  // Reset input for the second operand
        }
    }
}