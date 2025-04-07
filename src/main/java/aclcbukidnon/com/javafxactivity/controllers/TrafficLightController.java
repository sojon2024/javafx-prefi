package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class TrafficLightController {

    private enum TrafficLightColor {
        STOP,
        HOLD,
        GO,
    }

    private TrafficLightColor currentColor = TrafficLightColor.STOP;
    private Timeline timeline;

    @FXML
    private Button stopButton;

    @FXML
    private Button holdButton;

    @FXML
    private Button goButton;

    @FXML
    public void initialize() {
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);

        updateUI();  // Initial visual state
    }

    @FXML
    public void onStartClick() {
        timeline.play();
    }

    @FXML
    public void onStopClick() {
        timeline.stop();
    }

    public void onTimerChange() {
        switch (currentColor) {
            case STOP:
                currentColor = TrafficLightColor.HOLD;
                break;
            case HOLD:
                currentColor = TrafficLightColor.GO;
                break;
            case GO:
                currentColor = TrafficLightColor.STOP;
                break;
        }

        updateUI();
    }

    private void updateUI() {
        // Reset colors
        stopButton.setStyle("-fx-background-color: grey;");
        holdButton.setStyle("-fx-background-color: grey;");
        goButton.setStyle("-fx-background-color: grey;");

        // Highlight the active light
        switch (currentColor) {
            case STOP:
                stopButton.setStyle("-fx-background-color: red;");
                break;
            case HOLD:
                holdButton.setStyle("-fx-background-color: yellow;");
                break;
            case GO:
                goButton.setStyle("-fx-background-color: green;");
                break;
        }
    }
} 