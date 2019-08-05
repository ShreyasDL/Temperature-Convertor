package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    public Label label;
    @FXML
    public ChoiceBox <String> choiceBox;
    @FXML
    public TextField textField;
    @FXML
    public Button button;
    private static final String C_F_TEXT = "Celsius to Fahrenheit";
    private static final String F_C_TEXT = "Fahrenheit to Celsius";
    private Boolean isC_F=true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().add(C_F_TEXT);
        choiceBox.getItems().add(F_C_TEXT);
        choiceBox.setValue(C_F_TEXT);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(C_F_TEXT)){
                isC_F=true;
            }else{
                isC_F=false;
            }
        });

        button.setOnAction(event -> {
            convert();
        });

    }

    private void convert() {
        String input=textField.getText();
        float enteredTemp;
        try  {
            enteredTemp = Float.parseFloat(input);
        }catch(Exception ex){
            warnUser();
            return;
        }
        float newtemp = 0.0f;
        if(isC_F){
            newtemp =((enteredTemp*9/5)+32);
        }else{
            newtemp = ((enteredTemp-32)*5/9);
        }
        display(newtemp);
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error !");
        alert.setHeaderText("Invalid Temperature");
        alert.setContentText("Enter a valid temperature");
        alert.show();
    }

    private void display(float newtemp) {
        String unit = isC_F ? "F":"C";
        System.out.println("The converted Temp is : "+ newtemp + unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Converted Temperature");
        alert.setContentText("The converted Temp is : "+ newtemp + unit);
        alert.show();
    }
}
