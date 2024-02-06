package MVC;

import COMMAND.Back1Command;
import COMMAND.Command;
import COMMAND.SignUp2Command;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene3View extends AnchorPane{

    private model1 model;

    private VBox vbox;
    private Label usernameLabel;
    private TextField username;
    private Label passwordLabel;
    private TextField password;
    private Label mailLabel;
    private TextField mail;
    private Label sessoLabel;
    private RadioButton maschio;
    private RadioButton femmina;
    private RadioButton altro;
    private Button signupButton;
    private Button Back1;

   
    Scene3controller controller;

    public Scene3View(model1 model) {
        this.model = model;
      
        initialize();
    }

    private void initialize() {



        vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(132);
        vbox.setLayoutY(100);

        Back1 = new Button("<-");
        Back1.setLayoutX(0.0);
        Back1.setLayoutY(0.0);



       

        usernameLabel = new Label("Username");
        username = new TextField();

        passwordLabel = new Label("Password");
        password = new TextField();

        mailLabel = new Label("E-Mail");
        mail = new TextField();

        sessoLabel = new Label("Sesso");
        maschio = new RadioButton("Maschio");
        femmina = new RadioButton("Femmina");
        altro = new RadioButton("Altro");

        signupButton = new Button("Registrati!");

        vbox.getChildren().addAll(usernameLabel, username, passwordLabel, password, mailLabel, mail, sessoLabel, maschio, femmina, altro, signupButton,Back1);

        controller = new Scene3controller(model);

        signupButton.setOnAction(event -> {Command signup2command = new SignUp2Command(controller, event);
        signup2command.execute();
        });

        Back1.setOnAction(event -> {Command back1command = new Back1Command(controller, event);
        back1command.execute(); 
        });


        

        getChildren().add(vbox);

    }


     public void showView1() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }

    
}
