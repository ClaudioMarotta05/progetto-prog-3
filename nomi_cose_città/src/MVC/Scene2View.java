package MVC;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Scene2View extends AnchorPane {

   
   private model1 model;
   //private model3 modello;
   

    public Scene2View(model1 model) {
        this.model = model;
        
        initialize();
    }

/*
    public Scene2View(model3 modello) {
        this.modello = modello;
        
        initialize();
    }


    public Scene2View() {
        
        
        initialize();
    }
 */
    

    private void initialize() {
        // Create UI elements
        Label benvenuto = new Label("Benvenuto " + model.getUsername());
        //Label benvenuto1 = new Label("Benvenuto " + modello.getName());
        MenuButton menuButton = new MenuButton("Menu");
        CheckMenuItem cat1Item = new CheckMenuItem("Nome");
        CheckMenuItem cat2Item = new CheckMenuItem("Cose");
        CheckMenuItem cat3Item = new CheckMenuItem("Citta");
        CheckMenuItem cat4Item = new CheckMenuItem("Frutta");

        Button playButton = new Button("PLAY");

       
        menuButton.getItems().addAll(cat1Item, cat2Item, cat3Item, cat4Item);

        benvenuto.setLayoutX(268.0);
        benvenuto.setLayoutY(14.0);
        //benvenuto1.setLayoutX(268.0);
        //benvenuto1.setLayoutY(14.0);
        menuButton.setLayoutX(84.0);
        menuButton.setLayoutY(317.0);
        playButton.setLayoutX(362.0);
        playButton.setLayoutY(286.0);

        
        Scene2Controller controller = new Scene2Controller(model.getUsername());
        
        cat1Item.setOnAction(controller::setCat1);
        cat2Item.setOnAction(controller::setCat2);
        cat3Item.setOnAction(controller::setCat3);
        cat4Item.setOnAction(controller::setCat4);
        playButton.setOnAction(controller::playGame);

        
        getChildren().addAll(menuButton, playButton,benvenuto);

       
    }

    public void showView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }
}
