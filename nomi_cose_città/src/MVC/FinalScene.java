package MVC;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//import java.util.List;

public class FinalScene extends AnchorPane {

    private Label classifica;
    private Label giocatori;
    private Label punteggio;
    private Button ancora;
    private VBox vb1;
    private VBox vb2;
    //private List<String> giocatoriList;
    //private List<Integer> punteggiList;
    private TextField nome;
    private TextField puntitotale;
    private String Nominativo;
   // private String nominativo;

    FinalSceneController controller = new FinalSceneController();

    public FinalScene(String Nominativo) {
        this.Nominativo = Nominativo;
       
        initialize();
    }

    private void initialize() {

        classifica = new Label("CLASSIFICA FINALE");
        classifica.setLayoutX(268.0);
        classifica.setLayoutY(14.0);
        classifica.setFont(new Font("Bell MT Bold", 30));

        giocatori = new Label("             Nome Giocatore ");
        giocatori.setLayoutX(127.0);
        giocatori.setLayoutY(62.0);
        giocatori.setFont(new Font("Bell MT Bold", 16));

        punteggio = new Label("                Punteggio");
        punteggio.setLayoutX(428.0);
        punteggio.setLayoutY(62.0);
        punteggio.setFont(new Font("Bell MT Bold", 16));

        ancora = new Button("Gioca Ancora!");
        ancora.setLayoutX(293.0);
        ancora.setLayoutY(489.0);
        ancora.setPrefHeight(59.0);
        ancora.setPrefWidth(199.0);

        nome=new TextField();
        nome.setText(Nominativo);
        nome.setLayoutX(59.0);
        nome.setLayoutY(247.0);
    
        puntitotale=new TextField();
        puntitotale.setLayoutX(56.0);
        puntitotale.setLayoutY(234.0);

        vb1 = new VBox();
        vb1.setLayoutX(127.0);
        vb1.setLayoutY(62.0);
        vb1.setPrefHeight(378.0);
        vb1.setPrefWidth(234.0);
        vb1.getChildren().addAll(giocatori,nome);
/* 
        for (String giocatore : giocatoriList) {
            Label giocatoreLabel = new Label(giocatore);
            vb1.getChildren().add(giocatoreLabel);
        }
*/
        vb2 = new VBox();
        vb2.setLayoutX(428.0);
        vb2.setLayoutY(62.0);
        vb2.setPrefHeight(378.0);
        vb2.setPrefWidth(234.0);
        vb2.getChildren().addAll(punteggio,puntitotale);
/* 
        for (Integer punteggio : punteggiList) {
            Label punteggioLabel = new Label(String.valueOf(punteggio));
            vb2.getChildren().add(punteggioLabel);
        }

        
*/


        

       

        getChildren().addAll(classifica, ancora, vb1, vb2);
        ancora.setOnAction(controller::giocancora);
    }

    public void showView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }
}