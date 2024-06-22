module com.mycompany.provap2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.mycompany.provap2.Controller to javafx.fxml;
    opens com.mycompany.provap2.EditController to javafx.fxml;
    opens com.mycompany.provap2.ListController to javafx.fxml;
    opens com.mycompany.provap2.backend to javafx.base;
    
    exports com.mycompany.provap2;
    exports com.mycompany.provap2.backend;
}
