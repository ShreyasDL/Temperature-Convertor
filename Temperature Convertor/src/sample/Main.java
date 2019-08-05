package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        MenuBar menuBar = createMenu();
        root.getChildren().add(0, menuBar);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private MenuBar createMenu() {
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        newItem.setOnAction(event -> System.out.println("New Item Clicked"));
        MenuItem quitItem = new MenuItem("Quit");
        quitItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        SeparatorMenuItem separator = new SeparatorMenuItem();
        fileMenu.getItems().addAll(newItem,separator, quitItem);
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        aboutApp.setOnAction(event -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutApp() {
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Controller");
        alert.setHeaderText("Temperature Controller");
        alert.setContentText("This App is used to convert temperature from the Celsius to Fahrenheit and vice versa");
        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alert.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickedBtn = alert.showAndWait();
        if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("Yes Button clicked ! ");
        }else{
            System.out.println("No Button clicked !");
        }
    }
}