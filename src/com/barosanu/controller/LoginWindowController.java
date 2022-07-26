package com.barosanu.controller;
import com.barosanu.EmailManager;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {


    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName); //wywołuje konstruktor klasy z której dziediczymy
    }

    @FXML
    void loginButtonAction() {
        System.out.println("clicked login button");
        viewFactory.showMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();//w taki sposób dostajemy stage- za pomocą get wykonanym na jakimś polu z tego okna.
        viewFactory.closeStage(stage);// zamyka okno logowania

    }


}
