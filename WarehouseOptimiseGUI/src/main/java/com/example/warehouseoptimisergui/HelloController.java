package com.example.warehouseoptimisergui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Button booking;

    @FXML
    private Button viewSchedule;

    @FXML
    protected void navigateBooking() {
        booking.setText("hi");
    }

    @FXML
    protected void navigateSchedule() {
        viewSchedule.setText("bye");
    }


}