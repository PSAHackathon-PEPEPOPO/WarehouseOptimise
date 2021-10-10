package com.example.warehouseoptimisergui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button addContainer;

    @FXML
    private Button bookingsButton;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Button homeButton;

    public static final Warehouse warehouse1 = new Warehouse(1);
    public static final Warehouse warehouse2 = new Warehouse(2);
    public static final Warehouse warehouse3 = new Warehouse(3);
    public static final Warehouse warehouse4 = new Warehouse(4);
    public static final Warehouse warehouse5 = new Warehouse(5);
    public static final ContainerList containers = new ContainerList();


    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Bookings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public LocalDateTime getDateTime() {
        LocalDate ld = datepicker.getValue();
        LocalDateTime ldt = convertToDateTime(ld);
        return ldt;
    }

    public LocalDateTime convertToDateTime(LocalDate ld) {
        LocalDateTime dateTime = ld.atStartOfDay();
        return dateTime;
    }

    public void initDatabase() {
        LocalDateTime dateTime = getDateTime();
        containers.add(new Container("v1", 1, dateTime, Task.LOAD), warehouse1);
        containers.add(new Container("v2", 1, dateTime, Task.LOAD), warehouse1);
        containers.add(new Container("v3", 1, dateTime, Task.UNLOAD), warehouse1);
        containers.add(new Container("v4", 1, dateTime, Task.LOAD), warehouse1);
        containers.add(new Container("v5", 1, dateTime, Task.UNLOAD), warehouse1);
        containers.add(new Container("v6", 1, dateTime, Task.LOAD), warehouse1);
        containers.add(new Container("v7", 1, dateTime, Task.LOAD), warehouse1);
        containers.add(new Container("v8", 1, dateTime, Task.LOAD), warehouse1);

        containers.add(new Container("v9", 2, dateTime, Task.LOAD), warehouse2);
        containers.add(new Container("v10", 2, dateTime, Task.UNLOAD), warehouse2);
        containers.add(new Container("v11", 2, dateTime, Task.LOAD), warehouse2);
        containers.add(new Container("v12", 2, dateTime, Task.UNLOAD), warehouse2);
        containers.add(new Container("v13", 2, dateTime, Task.LOAD), warehouse2);
        containers.add(new Container("v14", 2, dateTime, Task.LOAD), warehouse2);
        containers.add(new Container("v15", 2, dateTime, Task.UNLOAD), warehouse2);
        containers.add(new Container("v16", 2, dateTime, Task.LOAD), warehouse2);
        warehouse1.sortLoadingsByStartTime();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}