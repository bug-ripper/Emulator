package com.denisbondd111;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class StageController implements Initializable {

    @FXML
    private Button compileButton;

    @FXML
    private Label current;

    @FXML
    private ChoiceBox<String> lampChoise;

    @FXML
    private Label lampPower;

    @FXML
    private Label lampResistance;

    @FXML
    private Label temperature;

    @FXML
    private TextField voltage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("[1-9]*?([1-9][0-9]*)?")) {
                return change;
            }
            return null;
        };

        lampChoise.getItems().addAll("Лампа 1", "Лампа 2", "Лампа 3", "Лампа 4", "Лампа 5");
        lampChoise.setValue("Лампа 1");
        lampChoise.setOnAction(actionEvent -> {
            if (lampChoise.getValue() == "Лампа 1"){
                lampPower.setText("25");
                lampResistance.setText("155");
            }if (lampChoise.getValue() == "Лампа 2"){
                lampPower.setText("40");
                lampResistance.setText("103");
            }if (lampChoise.getValue() == "Лампа 3"){
                lampPower.setText("60");
                lampResistance.setText("61");
            }if (lampChoise.getValue() == "Лампа 4"){
                lampPower.setText("75");
                lampResistance.setText("51");
            }if (lampChoise.getValue() == "Лампа 5"){
                lampPower.setText("100");
                lampResistance.setText("40");
            }
        });
        voltage.setTextFormatter(new TextFormatter<Integer>(integerFilter));

        compileButton.setOnMouseClicked(mouseEvent -> {
            System.out.println(lampPower.getText());
            Map<String, Double> params;
            params = LampTemperatureSimulation.calculateTemperatureAndResistance(Double.parseDouble(voltage.getText()), Double.parseDouble(lampPower.getText()), Double.parseDouble(lampResistance.getText()));
            temperature.setText(String.valueOf(Math.round(params.get("temperature"))));
            current.setText(String.valueOf(params.get("current")));
        });
    }
}
