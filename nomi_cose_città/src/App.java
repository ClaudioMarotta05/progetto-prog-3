

import MVC.AppController;
import MVC.model1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class App extends Application {
    private model1 model;
    private AppController controller;
    private Button Next;
  
    AnchorPane root;


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Nomi, Cose, Citta e altro");

    
        root = new AnchorPane();
       

        Next = new Button("Next");
        
        Scene scene = new Scene(root, 785, 570);
        primaryStage.setScene(scene);

        Next.setLayoutX(362.0);
        Next.setLayoutY(286.0);

        root.getChildren().add(Next);

       
        model = new model1();
        controller = new AppController(model);

        Next.setOnAction(controller::Next);


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
