package com.example.warehouseoptimisergui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Homepage.fxml"));
            Parent root = loader.load();
            Scene scene1 = new Scene(root, 600, 600);
            stage.setScene(scene1);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final ContainerList containers = new ContainerList();

    public static void main(String[] args) {
        launch(args);
    }

    public static void list() {
        HashMap<Container, Warehouse> containerList = containers.getContainers();
        for (Map.Entry<Container, Warehouse> container : containerList.entrySet()) {
            Warehouse warehouse = container.getValue();
            System.out.println(container.getKey().toString() + warehouse.getIndex());
        }
    }
}
