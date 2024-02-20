package MVC;

import COMMAND.BackCommand;
import COMMAND.Command;
import COMMAND.PlayGameCommand;
import OBSERVER.Observable;
import OBSERVER.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Questa classe rappresenta la vista per la seconda scena dell'applicazione.
 * La vista permette agli utenti di selezionare categorie e il numero di giocatori
 * prima di avviare il gioco.
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */

public class Scene2View extends AnchorPane implements Observer {

    private int numPlayers = 0; // Numero di giocatori
    private model1 model; // Modello dell'applicazione
    private Label benvenuto; // Etichetta di benvenuto
    private MenuButton menuButton; // MenuButton per la selezione delle categorie
    private ChoiceBox<Integer> choiceBox; // ChoiceBox per la selezione del numero di giocatori
    private Label numeroGiocatori; // Etichetta per il numero di giocatori
    private Button playButton; // Bottone per avviare il gioco
    private Button backButton; // Bottone per tornare indietro

    // Costruttore della classe
    public Scene2View(model1 model) {
        this.model = model; // Inizializza il modello
        this.model.addObserver(this); // Aggiunge questa vista come osservatore del modello
        initialize(); // Inizializza la vista
    }

    // Metodo per l'inizializzazione della vista
    private void initialize() {
        // Imposta lo sfondo della vista
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        setPrefSize(800, 600);

        // VBox per contenere gli elementi della vista
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);

        // Etichetta di benvenuto
        benvenuto = new Label("Ciao " + model.getUsername()+" !");
        benvenuto.setStyle("-fx-font-size: 24; -fx-text-fill: #000000;");

        // Bottone per tornare indietro
        backButton = new Button("<-");
        backButton.setStyle("-fx-background-color: red; -fx-font-size: 14;");

        // MenuButton per la selezione delle categorie
        menuButton = new MenuButton("Seleziona le categorie:");
        menuButton.setStyle("-fx-font-size: 16;");

        // CheckMenuItem per ogni categoria
        CheckMenuItem cat1Item = new CheckMenuItem("Nome");
        CheckMenuItem cat2Item = new CheckMenuItem("Cose");
        CheckMenuItem cat3Item = new CheckMenuItem("Città");
        CheckMenuItem cat4Item = new CheckMenuItem("Frutta");
        CheckMenuItem cat5Item = new CheckMenuItem("Verbi");
        CheckMenuItem cat6Item = new CheckMenuItem("Animali");
        CheckMenuItem cat7Item = new CheckMenuItem("Piante");
        CheckMenuItem cat8Item = new CheckMenuItem("Cantanti");
        CheckMenuItem cat9Item = new CheckMenuItem("Nazioni");
        CheckMenuItem cat10Item = new CheckMenuItem("Mestieri");
        CheckMenuItem cat11Item = new CheckMenuItem("Celebrità");

        // ChoiceBox per la selezione del numero di giocatori
        choiceBox = new ChoiceBox<>();
        ObservableList<Integer> numPlayersList = FXCollections.observableArrayList(1, 2, 3);
        choiceBox.setItems(numPlayersList);

        // Etichetta per il numero di giocatori
        numeroGiocatori = new Label("Numero di Giocatori Avversari:");
        numeroGiocatori.setStyle("-fx-font-size: 16;");

        // Listener per il cambio di selezione nella ChoiceBox
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                numPlayers = newValue;
            }
        });

        // Bottone per avviare il gioco
        playButton = new Button("PLAY");
        playButton.setStyle("-fx-background-color: #2ECC71; -fx-font-size: 18;");
        VBox.setMargin(playButton, new Insets(100, 0, 0, 0));

        // Aggiunge gli elementi al MenuButton
        menuButton.getItems().addAll(cat1Item, cat2Item, cat3Item, cat4Item, cat5Item, cat6Item, cat7Item, cat8Item, cat9Item, cat10Item, cat11Item);

        // Aggiunge gli elementi al VBox
        vbox.getChildren().addAll(benvenuto, menuButton, numeroGiocatori, choiceBox, playButton);
        AnchorPane.setTopAnchor(vbox, 0.0);
        AnchorPane.setBottomAnchor(vbox, 0.0);
        AnchorPane.setLeftAnchor(vbox, 0.0);
        AnchorPane.setRightAnchor(vbox, 0.0);
        getChildren().add(vbox);

        // Posiziona il bottone "Indietro" nell'angolo in alto a sinistra
        AnchorPane.setTopAnchor(backButton, 10.0);
        AnchorPane.setLeftAnchor(backButton, 10.0);
        getChildren().add(backButton);

        // Crea un nuovo controller per gestire le azioni della vista
        Scene2Controller controller = new Scene2Controller(model);

        // Associa gli eventi ai relativi metodi del controller
        cat1Item.setOnAction(controller::setCat1);
        cat2Item.setOnAction(controller::setCat2);
        cat3Item.setOnAction(controller::setCat3);
        cat4Item.setOnAction(controller::setCat4);
        cat5Item.setOnAction(controller::setCat5);
        cat6Item.setOnAction(controller::setCat6);
        cat7Item.setOnAction(controller::setCat7);
        cat8Item.setOnAction(controller::setCat8);
        cat9Item.setOnAction(controller::setCat9);
        cat10Item.setOnAction(controller::setCat10);
        cat11Item.setOnAction(controller::setCat11);

        // Evento per tornare alla schermata precedente
        backButton.setOnAction(event -> {
            Command backcommand = new BackCommand(controller, event);
            backcommand.execute();
        });

        // Evento per avviare il gioco
        playButton.setOnAction(event -> {
            Command playgamecommand = new PlayGameCommand(controller, numPlayers, event);
            playgamecommand.execute();
        });
    }

    // Metodo chiamato quando il modello viene aggiornato
    @Override
    public void update(Observable observable) {
        if (observable instanceof model1) {
            updateView(); // Aggiorna la vista
        }
    }

    // Metodo per aggiornare la vista con il nome utente
    private void updateView() {
        benvenuto.setText("Benvenuto " + model.getUsername());
    }

    // Metodo per mostrare la vista
    public void showView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this));
        stage.show();
    }
}
