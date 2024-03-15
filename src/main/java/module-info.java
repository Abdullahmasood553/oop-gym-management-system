module com.example.gms {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.example.gms to javafx.fxml;
    opens com.example.gms.models to javafx.base;
    exports com.example.gms;
}