module com.orbix
{
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;
    requires aparapi;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;

    opens com.orbix.gui to javafx.graphics;
    opens com.orbix.gui.Controllers to javafx.fxml, aparapi;
    opens com.orbix.bench to aparapi;
    opens com.orbix.logging to com.fasterxml.jackson.databind;
    exports com.orbix;
}
