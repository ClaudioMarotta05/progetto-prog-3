




import MVC.SceneController;
import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
       
   primaryStage.setTitle("Nomi,Cose,Citta e altro");

        // Create UI elements
        Label usernameLabel = new Label("USERNAME");
        TextField usernameTextField = new TextField();
        Label passwordLabel = new Label("PASSWORD");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button signUpButton = new Button("Sign Up");

        // Set up the layout
        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordField, loginButton, signUpButton);

        // Set up the root layout
        AnchorPane root = new AnchorPane();
        AnchorPane.setTopAnchor(vBox, 85.0);
        AnchorPane.setLeftAnchor(vBox, 279.0);
        root.getChildren().add(vBox);

        // Create the scene
        Scene scene = new Scene(root, 785, 570);
        primaryStage.setScene(scene);

        // Set up the controller
        SceneController controller = new SceneController(usernameTextField, passwordField);
        loginButton.setOnAction(controller::handleLoginAction);
        signUpButton.setOnAction(controller::handleSignUpAction);

        // Show the stage
        primaryStage.show();
  
    }
 

    
 public static void main(String[] args) {
        launch(args);
    }

    
}
