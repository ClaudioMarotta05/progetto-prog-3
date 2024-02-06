package MVC;


import COMMAND.BackCommand;
import COMMAND.Command;
import COMMAND.PlayGameCommand;
import OBSERVER.Observable;
import OBSERVER.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene2View extends AnchorPane implements Observer{

   
  
   private int numPLayers = 0;
   private model1 model;
   private Label benvenuto;
   private MenuButton menuButton;
   private ChoiceBox<Integer> choiceBox;
   private Label numeroGiocatori;
   private Button playButton;
   private Button Back;
 
   

    public Scene2View(model1 model) {
        this.model = model;
        this.model.addObserver(this);
        initialize();
    }

    private void initialize() {
       
        
        benvenuto = new Label("Benvenuto " + model.getUsername());
        menuButton = new MenuButton("Seleziona le categorie da inserire:");
        CheckMenuItem cat1Item = new CheckMenuItem("Nome");
        CheckMenuItem cat2Item = new CheckMenuItem("Cose");
        CheckMenuItem cat3Item = new CheckMenuItem("Citta");
        CheckMenuItem cat4Item = new CheckMenuItem("Frutta");
        CheckMenuItem cat5Item = new CheckMenuItem("Verbi");
        CheckMenuItem cat6Item = new CheckMenuItem("Animali");
        CheckMenuItem cat7Item = new CheckMenuItem("Piante");
        CheckMenuItem cat8Item = new CheckMenuItem("Cantanti");
        CheckMenuItem cat9Item = new CheckMenuItem("Nazioni");
        CheckMenuItem cat10Item = new CheckMenuItem("Mestieri");
        CheckMenuItem cat11Item = new CheckMenuItem("Celebritá");

        choiceBox = new ChoiceBox<>();
        ObservableList<Integer> numPlayersList = FXCollections.observableArrayList(1, 2, 3);
        choiceBox.setItems(numPlayersList);
        

        numeroGiocatori = new Label();

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                numPLayers = newValue;
            }
        });

        Back = new Button("<-");

        playButton = new Button("PLAY");

        menuButton.getItems().addAll(cat1Item, cat2Item, cat3Item, cat4Item,cat5Item, cat6Item, cat7Item, cat8Item,cat9Item, cat10Item, cat11Item);

        benvenuto.setLayoutX(268.0);
        benvenuto.setLayoutY(14.0);
        menuButton.setLayoutX(84.0);
        menuButton.setLayoutY(84.0);
        choiceBox.setLayoutX(500.0);
        choiceBox.setLayoutY(84.0);
        numeroGiocatori.setLayoutX(450.0);
        numeroGiocatori.setLayoutY(65.0);
        Back.setLayoutX(0.0);
        Back.setLayoutY(0.0);

        playButton.setLayoutX(362.0);
        playButton.setLayoutY(286.0);

        

        
        Scene2Controller controller = new Scene2Controller(model);
        
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
       

        Back.setOnAction(event -> {Command backcommand = new BackCommand(controller, event);
        backcommand.execute(); 
        });
    
        playButton.setOnAction(event -> {Command playgamecommand = new PlayGameCommand(controller, numPLayers, event);
        playgamecommand.execute(); 
        });

        
        getChildren().addAll(menuButton, playButton,benvenuto,choiceBox,numeroGiocatori,Back);

       
    }

    @Override
    public void update(Observable observable) {
       
        if (observable instanceof model1) {
            updateView();
        }
    }
    private void updateView() {
        benvenuto.setText("Benvenuto " + model.getUsername());
    }

    public void showView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }
}


