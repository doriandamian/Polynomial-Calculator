module com.example.assignment_1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.assignment_1 to javafx.fxml;
    exports com.example.assignment_1;
}