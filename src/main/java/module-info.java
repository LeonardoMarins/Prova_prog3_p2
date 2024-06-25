module com.mycompany.provap2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires jakarta.xml.bind; // Requer JAXB (API Jakarta)
    requires org.glassfish.jaxb.runtime; // Requer a implementação do JAXB (GlassFish)
    requires com.fasterxml.jackson.databind; // Requer Jackson (módulo principal)
    requires java.sql; // Requer JDBC

    opens com.mycompany.provap2.Controller to javafx.fxml;
    opens com.mycompany.provap2.EditController to javafx.fxml;
    opens com.mycompany.provap2.ListController to javafx.fxml;
    opens com.mycompany.provap2.backend to javafx.base;
    opens com.mycompany.provap2.Persistencia to jakarta.xml.bind;
    
    exports com.mycompany.provap2;
    exports com.mycompany.provap2.backend;
}
