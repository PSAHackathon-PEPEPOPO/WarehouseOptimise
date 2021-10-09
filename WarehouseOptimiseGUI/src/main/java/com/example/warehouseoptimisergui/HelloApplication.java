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

    private static final Warehouse warehouse1 = new Warehouse(1);
    private static final Warehouse warehouse2 = new Warehouse(2);
    private static final Warehouse warehouse3 = new Warehouse(3);
    private static final Warehouse warehouse4 = new Warehouse(4);
    private static final Warehouse warehouse5 = new Warehouse(5);
    private static final ContainerList containers = new ContainerList();

    public static void main(String[] args) {
        containers.add(new Container("v1", 1, "8-8-2020 00:00", Task.LOAD), warehouse1);
        containers.add(new Container("v2", 1, "8-8-2020 00:00", Task.LOAD), warehouse1);
        containers.add(new Container("v3", 1, "8-8-2020 00:00", Task.LOAD), warehouse1);
        containers.add(new Container("v4", 1, "8-8-2020 00:00", Task.LOAD), warehouse1);
        containers.add(new Container("v5", 1, "8-8-2020 00:00", Task.LOAD), warehouse1);
        containers.add(new Container("v6", 1, "8-8-2020 00:00", Task.LOAD), warehouse1);
        containers.add(new Container("v7", 1, "8-8-2020 00:00", Task.LOAD), warehouse1);
        containers.add(new Container("v8", 1, "8-8-2020 00:00", Task.LOAD), warehouse1);

        containers.addBookingTime("v1", "8-8-2020 23:00", "8-8-2020 23:50");
        containers.addBookingTime("v2", "8-8-2020 21:00", "8-8-2020 22:00");
        containers.addBookingTime("v3", "8-8-2020 00:00", "8-8-2020 19:00");
        containers.addBookingTime("v4", "8-8-2020 13:00", "8-8-2020 18:00");
        containers.addBookingTime("v5", "8-8-2020 12:00", "8-8-2020 14:00");
        containers.addBookingTime("v6", "8-8-2020 16:00", "8-8-2020 18:00");
        containers.addBookingTime("v7", "8-8-2020 00:00", "8-8-2020 10:00");
        containers.addBookingTime("v8", "8-8-2020 15:00", "8-8-2020 17:00");

        warehouse1.sortLoadingsByStartTime();
//        System.out.println(warehouse1.getLoadings());
//        list();
    }

    public static void list() {
        HashMap<Container, Warehouse> containerList = containers.getContainers();
        for (Map.Entry<Container, Warehouse> container : containerList.entrySet()) {
            Warehouse warehouse = container.getValue();
            System.out.println(container.getKey().toString() + warehouse.getIndex());
        }
    }
}
