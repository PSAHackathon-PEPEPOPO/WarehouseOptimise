module com.example.warehouseoptimisegui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.warehouseoptimisergui to javafx.fxml;
    exports com.example.warehouseoptimisergui;
}