module prog.javadekom {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires junit;
    requires java.datatransfer;

    exports prog.javadekom.tests to junit;
    exports prog.javadekom.cal;
    opens prog.javadekom.cal to javafx.fxml;
    exports prog.javadekom;
    opens prog.javadekom to javafx.fxml;
}