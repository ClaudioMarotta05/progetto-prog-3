package MVC;


import COMMAND.Command;
import COMMAND.LoginCommand;

import COMMAND.SignUpCommand;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene1View extends AnchorPane{
    private model1 model;
    private SceneController controller;
    Label usernameLabel;
    TextField usernameTextField;
    Label passwordLabel;
    PasswordField passwordField;
    Button loginButton;
    Button signUpButton;
    VBox vBox;
    AnchorPane root;

   

    public Scene1View(model1 model) {
        this.model = model;
        initialize();
    }

     private void initialize() {
       
         usernameLabel = new Label("USERNAME");
        usernameTextField = new TextField();
        passwordLabel = new Label("PASSWORD");
        passwordField = new PasswordField();
        loginButton = new Button("Login");
        signUpButton = new Button("Sign Up");

        // Set up the layout
        vBox = new VBox(10);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordField, loginButton, signUpButton);

        getChildren().add(vBox);

        controller = new SceneController(model);

        loginButton.setOnAction(event -> {
            model.setUsername(usernameTextField.getText());
            model.setPassword(passwordField.getText());

            Command loginCommand = new LoginCommand(controller, event);
            loginCommand.execute();
        });

        signUpButton.setOnAction(event -> {
            model.setUsername(usernameTextField.getText());
            model.setPassword(passwordField.getText());

            Command signupCommand = new SignUpCommand(controller, event);
            signupCommand.execute();
        });
       
       
    }

      public void showView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }

   
}
