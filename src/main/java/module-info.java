module com.example.wallet {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires javafx.graphics;
    requires javafx.base;

    opens com.example.wallet.entity; // Ajoutez cette ligne
    opens com.example.wallet to javafx.fxml;
    exports com.example.wallet.entity;
    exports com.example.wallet;
    exports com.example.wallet.controller;
    opens com.example.wallet.controller to javafx.fxml;
    exports com.example.wallet.controller.home;
    opens com.example.wallet.controller.home to javafx.fxml;
    exports com.example.wallet.services;
    opens com.example.wallet.services to javafx.fxml;
    exports com.example.wallet.api;
    opens com.example.wallet.api to javafx.fxml;
    exports com.example.wallet.controller.home.popup;
    opens com.example.wallet.controller.home.popup to javafx.fxml;

}