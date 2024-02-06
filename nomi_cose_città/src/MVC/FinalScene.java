package MVC;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import COMMAND.Back3Command;
import COMMAND.Command;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FinalScene extends AnchorPane {

    private model1 model;
    private Label classifica;
    private Label classificaFinale;
    private Label giocatori;
    private Label punteggio;
    private VBox vb1;
    private VBox vb2;
    private ListView<String> listView;
    private List<String> giocatoriList;
    private List<Integer> punteggiList;
   
    private String Nominativo;
    private int[] arrayPunteggi;
    private int[] arrayPosizioni;
    private Button Back3;

    public FinalScene(model1 model) {
        this.model = model;
        initialize();
    }

    FinalSceneController controller = new FinalSceneController(model);

    private void initialize() {

        Nominativo = model.getUsername();
        arrayPunteggi = model.getPunteggi();
        arrayPosizioni = model.getPosizioni();

        Back3 = new Button("<-");
        Back3.setLayoutX(0.0);
        Back3.setLayoutY(0.0);

        classifica = new Label("CLASSIFICA PARZIALE");
        classifica.setLayoutX(265.0);
        classifica.setLayoutY(14.0);
        classifica.setFont(new Font("Bell MT Bold", 30));

        classificaFinale = new Label("CLASSIFICA FINALE");
        classificaFinale.setLayoutX(285.0);
        classificaFinale.setLayoutY(200.0);
        classificaFinale.setFont(new Font("Bell MT Bold", 30));

        giocatori = new Label("Nomi Giocatori ");
        giocatori.setLayoutX(200.0);
        giocatori.setLayoutY(50.0);
        giocatori.setFont(new Font("Bell MT Bold", 16));

        punteggio = new Label("Punteggio");
        punteggio.setLayoutX(500.0);
        punteggio.setLayoutY(50.0);
        punteggio.setFont(new Font("Bell MT Bold", 16));


        vb1 = new VBox();
        vb1.setLayoutX(200.0);
        vb1.setLayoutY(80.0);
        for (int i = 0; i < arrayPosizioni.length; i++) {
            Label labelC;
            
            if(arrayPosizioni[i] == 0){
                labelC = new Label(Nominativo);
                labelC.setFont(new Font("Bell MT Bold", 16));
            }else{
                labelC = new Label("Player " + arrayPosizioni[i]);
                labelC.setFont(new Font("Bell MT Bold", 16));
            }
            vb1.getChildren().addAll(labelC);
        }

        listView = new ListView<>();
        listView.setLayoutX(200.0);
        listView.setLayoutY(250.0);
        listView.setPrefSize(300, 300);

        try (BufferedReader br = new BufferedReader(
            new FileReader("nomi_cose_città/src/dizionario/classifica.txt"))){
            giocatoriList = new ArrayList<>();
            punteggiList = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    giocatoriList.add(parts[0]);
                    punteggiList.add(Integer.parseInt(parts[1]));
                }
            }

            int punteggioParziale = calcolaPunteggioParziale();
            aggiornaPunteggio(punteggioParziale);

        } catch (IOException e) {
            e.printStackTrace();
        }

          List<Integer> sortedIndexes = getSortedIndexes(punteggiList);

           ObservableList<String> items = FXCollections.observableArrayList();
        for (int i = 0; i < sortedIndexes.size(); i++) {
            items.add(giocatoriList.get(sortedIndexes.get(i)) + " - " + punteggiList.get(sortedIndexes.get(i)) + " punti");
        }

        listView.setItems(items);


        vb2 = new VBox();
        vb2.setLayoutX(500.0);
        vb2.setLayoutY(80.0);
        for (int i = 0; i < arrayPunteggi.length; i++) {
            Label labelB = new Label(arrayPunteggi[i] + " punti");
            labelB.setFont(new Font("Bell MT Bold", 16));
            vb2.getChildren().addAll(labelB);
        }

      
      
        Back3.setOnAction(event -> {Command backcommand = new Back3Command(controller, event);
        backcommand.execute(); 
        });



        getChildren().addAll(classifica, vb1, vb2, classificaFinale, giocatori, punteggio,listView);
    }

    public void showView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }

    private int calcolaPunteggioParziale() {
       
        return arrayPunteggi[arrayPosizioni[0]]; 
    }

    private void aggiornaPunteggio(int punteggioParziale) {
        int indiceGiocatore = giocatoriList.indexOf(Nominativo);
        if (indiceGiocatore >= 0) {
            int nuovoPunteggio = punteggiList.get(indiceGiocatore) + punteggioParziale;
            punteggiList.set(indiceGiocatore, nuovoPunteggio);
            try (FileWriter writer = new FileWriter("nomi_cose_città/src/dizionario/classifica.txt")) {
                for (int i = 0; i < giocatoriList.size(); i++) {
                    writer.write(giocatoriList.get(i) + " " + punteggiList.get(i) + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
           
            giocatoriList.add(Nominativo);
            punteggiList.add(punteggioParziale);

            try (FileWriter writer = new FileWriter("nomi_cose_città/src/dizionario/classifica.txt", true)) {
                writer.write(Nominativo + " " + punteggioParziale + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Integer> getSortedIndexes(List<Integer> punteggi) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < punteggi.size(); i++) {
            indexes.add(i);
        }

        // Ordina gli indici in base ai punteggi
        indexes.sort((i1, i2) -> punteggi.get(i2).compareTo(punteggi.get(i1)));

        return indexes;
    }
}
