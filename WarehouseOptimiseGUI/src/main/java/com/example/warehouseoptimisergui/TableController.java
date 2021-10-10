package com.example.warehouseoptimisergui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML
    private TableColumn<GenerateTable, String> availability;

    @FXML
    private TableView<GenerateTable> table;

    @FXML
    private TableColumn<GenerateTable, String> avail1;

    @FXML
    private TableColumn<GenerateTable, String> avail2;

    @FXML
    private TableColumn<GenerateTable, String> avail3;

    @FXML
    private TableColumn<GenerateTable, String> avail4;

    @FXML
    private TableColumn<GenerateTable, String> avail5;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Button confirmBooking;

    @FXML
    private ChoiceBox<String> hourStart, hourEnd, chooseContainer;

    public static final ContainerList containers = new ContainerList();


    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/Homepage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene3(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/MySchedule.fxml"));
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

    public void addContainer(ActionEvent event) {
        LocalDateTime ldt = getDateTime();
        String startHourString = hourStart.getValue();
        String endHourString = hourEnd.getValue();
        String containerString = chooseContainer.getValue();

        int startHourInt = Integer.parseInt(startHourString.split(":", 2)[0]);
        System.out.println(startHourInt);

        LocalDateTime startHour = Parser.getHour(startHourString, ldt);
        LocalDateTime endHour = Parser.getHour(endHourString, ldt);

        HashMap<Container, Warehouse> containerList = containers.getContainers();
        for (Map.Entry<Container, Warehouse> container : containerList.entrySet()) {
            if (container.getKey().toInfoString().equals(containerString)) {
                containers.addBookingTime(container.getKey().getContainerSerial(), startHour, endHour);
                GenerateTable.setAvail1(startHourInt / 9 - 1);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<GenerateTable> items = FXCollections.observableArrayList();
        items.add(new GenerateTable("8-8-2020 09:00"));
        items.add(new GenerateTable("8-8-2020 10:00"));
        items.add(new GenerateTable("8-8-2020 11:00"));
        items.add(new GenerateTable("8-8-2020 12:00"));
        items.add(new GenerateTable("8-8-2020 13:00"));
        items.add(new GenerateTable("8-8-2020 14:00"));
        items.add(new GenerateTable("8-8-2020 15:00"));
        items.add(new GenerateTable("8-8-2020 16:00"));
        items.add(new GenerateTable("8-8-2020 17:00"));
        items.add(new GenerateTable("8-8-2020 18:00"));
        items.add(new GenerateTable("8-8-2020 19:00"));
        items.add(new GenerateTable("8-8-2020 20:00"));
        items.add(new GenerateTable("8-8-2020 21:00"));
        items.add(new GenerateTable("8-8-2020 22:00"));

        table.setItems(items);
        avail1.setCellValueFactory(new PropertyValueFactory<GenerateTable, String>("availability"));
        avail2.setCellValueFactory(new PropertyValueFactory<GenerateTable, String>("availability"));
        avail3.setCellValueFactory(new PropertyValueFactory<GenerateTable, String>("availability"));
        avail4.setCellValueFactory(new PropertyValueFactory<GenerateTable, String>("availability"));
        avail5.setCellValueFactory(new PropertyValueFactory<GenerateTable, String>("availability"));

        ObservableList<String> choiceBoxItems = FXCollections.observableArrayList();
        choiceBoxItems.add("09:00");
        choiceBoxItems.add("10:00");
        choiceBoxItems.add("11:00");
        choiceBoxItems.add("12:00");
        choiceBoxItems.add("13:00");
        choiceBoxItems.add("14:00");
        choiceBoxItems.add("15:00");

        hourStart.setItems(choiceBoxItems);
        hourEnd.setItems(choiceBoxItems);

        ObservableList<String> choiceBoxContainer = FXCollections.observableArrayList();
        HashMap<Container, Warehouse> containerList = containers.getContainers();
        for (Map.Entry<Container, Warehouse> container : containerList.entrySet()) {
            choiceBoxContainer.add(container.getKey().toInfoString());
        }

        chooseContainer.setItems(choiceBoxContainer);
    }
}