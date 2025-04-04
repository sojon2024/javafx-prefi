package aclcbukidnon.com.javafxactivity.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CounterController {

    @FXML
    private Label labelCount;


    @FXML
    protected void onPlusClick() {
        var countText = labelCount.getText();
        var countValue = Integer.parseInt(countText);
        countValue = countValue + 1;
        labelCount.setText(countValue + "");
    }

    @FXML
    protected void onMinusClick() {
        var countText = labelCount.getText();
        var countValue = Integer.parseInt(countText);
        countValue = countValue - 1;
        labelCount.setText(countValue + "");
    }


}
