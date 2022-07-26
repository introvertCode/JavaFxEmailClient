package com.barosanu.controller;

import com.barosanu.EmailManager;
import com.barosanu.view.ColorTheme;
import com.barosanu.view.FontSize;
import com.barosanu.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {

    public OptionsWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;



    @FXML
    void applyButtonAction() {

    }

    @FXML
    void cancelButtonAction() {

    }

    //przypisywanie wartości do slidera i wyboru motywu
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpThemePicker();
        setUpSizePicker();
    }

    private void setUpSizePicker() {
        fontSizePicker.setMin(0);
        fontSizePicker.setMax(FontSize.values().length-1);//maks wartość na sliderze to długość enum - 1
        fontSizePicker.setValue(viewFactory.getFontSize().ordinal());//ordinal zwraca numer porządkowy
        fontSizePicker.setMajorTickUnit(1);
        fontSizePicker.setMinorTickCount(0);
        fontSizePicker.setBlockIncrement(1);
        fontSizePicker.setSnapToTicks(true);
        fontSizePicker.setShowTickMarks(true);
        fontSizePicker.setShowTickLabels(true);

        fontSizePicker.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return  FontSize.values()[i].toString(); //wywołuje metodę toString od enum, nie tej przysłoniętej
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });

        fontSizePicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            fontSizePicker.setValue(newVal.intValue());
        });

    }

    private void setUpThemePicker() {
        //argument w setitems musi być typu observable arraylist
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(viewFactory.getColorTheme());
    }
}