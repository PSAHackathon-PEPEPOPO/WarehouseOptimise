package com.example.warehouseoptimisergui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private static Warehouse warehouse1 = new Warehouse(1);
    private static Warehouse warehouse2 = new Warehouse(2);
    private static Warehouse warehouse3 = new Warehouse(3);
    private static Warehouse warehouse4 = new Warehouse(4);
    private static Warehouse warehouse5 = new Warehouse(5);
    private static ContainerList containers = new ContainerList();

    public static void main(String[] args) {
        containers.add(new Container("A123", 1));
        containers.add(new Container("babylove", 1));
        list();
    }

    public static void list() {
        HashMap<Container, Integer> containerList = containers.getContainers();
        for (Map.Entry<Container, Integer> container : containerList.entrySet()) {
            Integer warehouseIndex = container.getValue();

            System.out.println(container.getKey() + warehouseIndex.toString());
        }
    }
}
