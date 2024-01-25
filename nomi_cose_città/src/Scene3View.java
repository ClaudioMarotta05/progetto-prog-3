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

   
    Scene3controller controller = new Scene3controller(username, password,mail,maschio,femmina,altro);

    public Scene3View() {
      
        initialize();
    }

    private void initialize() {
        vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setLayoutX(132);
        vbox.setLayoutY(100);

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

        Scene3controller controller = new Scene3controller(username, password,mail,maschio,femmina,altro);

        signupButton.setOnAction(controller::signup);

        vbox.getChildren().addAll(usernameLabel, username, passwordLabel, password, mailLabel, mail, sessoLabel, maschio, femmina, altro, signupButton);

        getChildren().add(vbox);

    }


     public void showView1() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }

    
}
