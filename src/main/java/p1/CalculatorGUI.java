package p1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {
    Stage window;
    Scene textScene, buttonScene;
    Calculator calc = new Calculator();
    TextField displayAnswer = new TextField();
    ChoiceBox<String> switchFromButton = new ChoiceBox<>();
    ChoiceBox<String> switchFromText = new ChoiceBox<>();
    String number = "";
    double answer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Calculator - Buttons");

        switchFromButton.getItems().addAll("Button Mode", "Text Input");
        switchFromText.getItems().addAll("Button Mode", "Text Input");
        switchFromButton.setValue("Button Mode");
        switchFromText.setValue("Text Input");
        //Text Scene
        TextField userInput = new TextField();
        userInput.setPromptText("Enter Here!");


        Button enter = new Button("Evaluate");
        enter.setOnAction(e -> {
            answer = calc.evaluate(userInput.getText());
            System.out.println(answer);
        });

        switchFromText.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) -> {
            if(newValue.equals("Button Mode")){
                window.setScene(buttonScene);
                window.setTitle("Calculator - Buttons");
                switchFromButton.setValue("Button Mode");
            }
        });


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(userInput,enter,switchFromText);

        textScene = new Scene(layout, 300,300);

        //Button Scene

        //Number Buttons
        Button button0 = new Button("0");
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");

        button0.setOnAction(e -> {
            calc.problem += '0';
            number += '0';
            displayAnswer.setText(number);
        });
        button1.setOnAction(e -> {
            calc.problem += '1';
            number += '1';
            displayAnswer.setText(number);
        });
        button2.setOnAction(e -> {
            calc.problem += '2';
            number += '2';
            displayAnswer.setText(number);
        });
        button3.setOnAction(e -> {
            calc.problem += '3';
            number += '3';
            displayAnswer.setText(number);
        });
        button4.setOnAction(e -> {
            calc.problem += '4';
            number += '4';
            displayAnswer.setText(number);
        });
        button5.setOnAction(e -> {
            calc.problem += '5';
            number += '5';
            displayAnswer.setText(number);
        });
        button6.setOnAction(e -> {
            calc.problem += '6';
            number += '6';
            displayAnswer.setText(number);
        });
        button7.setOnAction(e -> {
            calc.problem += '7';
            number += '7';
            displayAnswer.setText(number);
        });
        button8.setOnAction(e -> {
            calc.problem += '8';
            number += '8';
            displayAnswer.setText(number);
        });
        button9.setOnAction(e -> {
            calc.problem += '9';
            number += '9';
            displayAnswer.setText(number);
        });

        //Button Operators
        Button equalButton = new Button("=");
        Button addButton = new Button("+");
        Button minusButton = new Button("-");
        Button multButton = new Button("*");
        Button divButton = new Button("/");
        Button powButton = new Button("^");
        Button pointButton = new Button(".");

        equalButton.setOnAction(e -> {
            answer = calc.evaluate(calc.problem);
            calc.operands.push(answer);
            displayAnswer.setText("" + answer);
        });
        addButton.setOnAction(e -> {
            calc.problem += '+';
            number = "";
        });
        minusButton.setOnAction(e -> {
            calc.problem += '-';
            number = "";
        });
        multButton.setOnAction(e -> {
            calc.problem += '*';
            number = "";
        });
        divButton.setOnAction(e -> {
            calc.problem += '/';
            number = "";
        });
        powButton.setOnAction(e -> {
            calc.problem += '^';
            number = "";
        });
        pointButton.setOnAction(e -> {
            calc.problem += '.';
            number += '.';
            displayAnswer.setText(number);
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        GridPane.setConstraints(button7,0,0);
        GridPane.setConstraints(button8,1,0);
        GridPane.setConstraints(button9,2,0);
        GridPane.setConstraints(button4,0,1);
        GridPane.setConstraints(button5,1,1);
        GridPane.setConstraints(button6,2,1);
        GridPane.setConstraints(button1,0,2);
        GridPane.setConstraints(button2,1,2);
        GridPane.setConstraints(button3,2,2);
        GridPane.setConstraints(button0,1,3);

        GridPane.setConstraints(pointButton,0,3);
        GridPane.setConstraints(divButton,3,0);
        GridPane.setConstraints(multButton,3,1);
        GridPane.setConstraints(minusButton,3,2);
        GridPane.setConstraints(addButton,3,3);
        GridPane.setConstraints(equalButton,2,3);

        VBox vBox = new VBox(10);
        vBox.getChildren().add(displayAnswer);
        displayAnswer.setEditable(false);
        grid.getChildren().addAll(button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,equalButton,divButton,multButton,minusButton,addButton,pointButton);
        grid.setAlignment(Pos.CENTER);

        BorderPane bPane = new BorderPane();
        bPane.setPadding(new Insets(20,20,20,20));
        bPane.setCenter(grid);
        bPane.setTop(vBox);

        StackPane sPane = new StackPane();
        sPane.setAlignment(Pos.CENTER);
        sPane.getChildren().addAll(switchFromButton);
        bPane.setBottom(sPane);

        switchFromButton.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue) -> {
            if(newValue.equals("Text Input")){
                window.setScene(textScene);
                window.setTitle("Calculator - Text Input");
                switchFromText.setValue("Text Input");
            }
        });
        buttonScene = new Scene(bPane,300,300);
        window.setScene(textScene);
        window.show();


    }
  }

//TODO
/*
1. Decimal Format
2. Stay in front mode
3. Fix Buttons
 */
