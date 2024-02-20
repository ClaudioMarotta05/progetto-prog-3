package MVC;

import COMMAND.Back1Command;
import COMMAND.Command;
import COMMAND.SignUp2Command;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Vista per la registrazione degli utenti.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public class Scene3View extends AnchorPane {

    private model1 model; // Modello associato alla vista
    private VBox vbox; // Layout per i campi di input e i bottoni
    private Label usernameLabel; // Etichetta per il campo username
    private TextField username; // Campo di input per l'username
    private Label passwordLabel; // Etichetta per il campo password
    private TextField password; // Campo di input per la password
    private Label mailLabel; // Etichetta per il campo email
    private TextField mail; // Campo di input per l'email
    private Button signupButton; // Bottone per confermare la registrazione
    private Button backButton; // Bottone per tornare alla schermata precedente
    private Scene3controller controller; // Controller associato alla vista

    /**
     * Costruttore della vista.
     *
     * @param model Il modello associato alla vista.
     */
    public Scene3View(model1 model) {
        this.model = model;
        initialize(); // Inizializzazione della vista
    }

    // Metodo per l'inizializzazione della vista
    private void initialize() {

        // Impostazione dello sfondo bianco per la vista
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));

        // Creazione del layout per i campi di input e i bottoni
        vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        // Creazione del bottone per tornare alla schermata precedente
        backButton = new Button("<-");
        backButton.setLayoutX(20);
        backButton.setLayoutY(20);
        backButton.setStyle("-fx-background-color: red; -fx-font-size: 14;");

        // Creazione delle etichette e dei campi di input per l'username, la password e l'email
        usernameLabel = new Label("Username");
        username = new TextField();
        username.setPrefWidth(200);
        username.setMaxWidth(200);

        passwordLabel = new Label("Password");
        password = new TextField();
        password.setPrefWidth(200);
        password.setMaxWidth(200);

        mailLabel = new Label("E-Mail");
        mail = new TextField();
        mail.setPrefWidth(200);
        mail.setMaxWidth(200);

        // Creazione del bottone per confermare la registrazione
        signupButton = new Button("Registrati!");
        signupButton.setStyle("-fx-background-color: lightgreen; -fx-font-size: 18;");

        // Aggiunta delle etichette, dei campi di input e dei bottoni al layout
        vbox.getChildren().addAll(usernameLabel, username, passwordLabel, password, mailLabel, mail, signupButton);
        getChildren().addAll(vbox, backButton);

        // Posizionamento del layout nella vista
        AnchorPane.setTopAnchor(vbox, 100.0);
        AnchorPane.setLeftAnchor(vbox, 0.0);
        AnchorPane.setRightAnchor(vbox, 0.0);

        // Creazione del controller associato alla vista
        controller = new Scene3controller(model);

        // Gestione dell'evento di click sul bottone di registrazione
        signupButton.setOnAction(event -> {
            // Impostazione dei valori dell'username, della password e dell'email nel modello
            model.setUsername(username.getText());
            model.setPassword(password.getText());
            model.setMail(mail.getText());
            // Creazione e esecuzione del comando per la registrazione
            Command signup2command = new SignUp2Command(controller, event);
            signup2command.execute();
        });

        // Gestione dell'evento di click sul bottone per tornare alla schermata precedente
        backButton.setOnAction(event -> {
            // Creazione e esecuzione del comando per tornare indietro
            Command back1command = new Back1Command(controller, event);
            back1command.execute();
        });
    }

    // Metodo per mostrare la vista
    public void showView1() {
        // Creazione e visualizzazione della finestra della vista
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }
}
