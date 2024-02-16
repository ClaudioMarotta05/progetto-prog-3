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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Questa classe rappresenta la vista della scena di accesso dell'applicazione
public class Scene1View {
    private model1 model; // Modello dell'applicazione
    private SceneController controller; // Controller associato alla vista
    Label usernameLabel; // Etichetta per l'input dell'username
    TextField usernameTextField; // Campo di testo per l'username
    Label passwordLabel; // Etichetta per l'input della password
    PasswordField passwordField; // Campo di testo per la password
    Button loginButton; // Pulsante per accedere
    Button signUpButton; // Pulsante per registrarsi
    VBox vBox; // Layout principale della scena

    // Costruttore della classe
    public Scene1View(model1 model) {
        this.model = model; // Inizializza il modello
        initialize(); // Inizializza la vista
    }

    // Metodo per inizializzare la vista
    private void initialize() {
        // Impostazione dello sfondo per il VBox
        vBox = new VBox(10);
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setPadding(new Insets(20));

        // Inizializzazione degli elementi dell'interfaccia utente
        usernameLabel = new Label("USERNAME");
        usernameTextField = new TextField();
        passwordLabel = new Label("PASSWORD");
        passwordField = new PasswordField();
        loginButton = new Button("Accedi!");
        signUpButton = new Button("Registrati!");
        usernameTextField.setPrefWidth(200); // Imposta la larghezza desiderata
        usernameTextField.setMaxWidth(200); // Imposta la larghezza massima
        usernameTextField.setMinHeight(30); // Imposta l'altezza minima
        passwordField.setPrefWidth(200); // Imposta la larghezza desiderata
        passwordField.setMaxWidth(200); // Imposta la larghezza massima
        passwordField.setMinHeight(30); // Imposta l'altezza minima

        // Set up the layout
        vBox.getChildren().addAll(usernameLabel, usernameTextField, passwordLabel, passwordField, loginButton,
                signUpButton);

        // Inizializzazione del controller associato alla vista
        controller = new SceneController(model);

        // Evento associato al pulsante di accesso
        loginButton.setOnAction(event -> {
            // Imposta l'username e la password nel modello
            model.setUsername(usernameTextField.getText());
            model.setPassword(passwordField.getText());

            // Crea un comando di accesso e lo esegue
            Command loginCommand = new LoginCommand(controller, event);
            loginCommand.execute();
        });

        // Evento associato al pulsante di registrazione
        signUpButton.setOnAction(event -> {
            // Imposta l'username e la password nel modello
            model.setUsername(usernameTextField.getText());
            model.setPassword(passwordField.getText());

            // Crea un comando di registrazione e lo esegue
            Command signupCommand = new SignUpCommand(controller, event);
            signupCommand.execute();
        });

        // Stile degli elementi dell'interfaccia utente
        usernameLabel.setStyle("-fx-font-size: 14px;");
        passwordLabel.setStyle("-fx-font-size: 14px;");
        loginButton.setStyle("-fx-font-size: 14px; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        signUpButton.setStyle("-fx-font-size: 14px; -fx-background-color: #008CBA; -fx-text-fill: white;");
        vBox.setStyle("-fx-background-color: #ADD8E6; -fx-border-color: #ccc; -fx-border-width: 1px;");
        vBox.setMinWidth(300);
        vBox.setSpacing(15);
    }

    // Metodo per visualizzare la vista
    public void showView() {
        Stage stage = new Stage();
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        stage.setScene(new Scene(vBox, 800, 600));
        stage.show();
    }
}
