import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
public class MainSceneController implements Initializable{

    @FXML
    private TableView<Tabella> GG;
/* 
    @FXML
    private TableColumn<Tabella, String> Cnome;

    @FXML
    private TableColumn<Tabella, String> Ccose;

    @FXML
    private TableColumn<Tabella, String> Ccitta;

*/




    @FXML
    private TextField InputNome;

    @FXML
    private TextField InputCose;

    @FXML
    private TextField InputCitta;

    @FXML
    private TextField InputFrutta;

     @FXML
    private Label Lettera;

    @FXML
    private Button Nome;

    @FXML
    private Button Cose;

    @FXML
    private Button Citta;

    @FXML
    private Button Frutta;

    

   int cont = 0;

    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       
       // Cnome.setCellValueFactory(new PropertyValueFactory<Tabella, String>("nome"));
        //Ccose.setCellValueFactory(new PropertyValueFactory<Tabella, String>("cose"));
        //Ccitta.setCellValueFactory(new PropertyValueFactory<Tabella, String>("citta"));
        GG.getItems();
        GG.setVisible(false);
    }

    
    @FXML
    void colonna1(ActionEvent event) {

        String nomeColonna = "Nome";
         TableColumn<Tabella, String> Cnome = new TableColumn<>(nomeColonna);
        Cnome.setCellValueFactory(new PropertyValueFactory<Tabella, String>("nome"));
         GG.getColumns().add(Cnome);

        double nuovaLarghezza = GG.getWidth() + 137.0; 
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);

        cont += 1;

        if (cont >= 2) {
            
            GG.setVisible(true);
        }

        Cnome.setMinWidth(nuovaLarghezza / cont); 
       
        Nome.setVisible(false);

    }

    @FXML
    void colonna2(ActionEvent event) {

        String nomeColonna = "Cosa";
         TableColumn<Tabella, String> Ccose = new TableColumn<>(nomeColonna);
         Ccose.setCellValueFactory(new PropertyValueFactory<Tabella, String>("cosa"));
         GG.getColumns().add(Ccose);

         double nuovaLarghezza = GG.getWidth() + 150.0; 
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);

        cont += 1;

        if (cont >= 2) {
            
            GG.setVisible(true);
        }
        
        Ccose.setMinWidth(nuovaLarghezza / cont);
        

         Cose.setVisible(false);

    }

    @FXML
    void colonna3(ActionEvent event) {

        String nomeColonna = "Cittá";
         TableColumn<Tabella, String> Ccitta = new TableColumn<>(nomeColonna);
         Ccitta.setCellValueFactory(new PropertyValueFactory<Tabella, String>("citta"));
         GG.getColumns().add(Ccitta);

         double nuovaLarghezza = GG.getWidth() + 150.0; // Aumenta la larghezza di 100 pixel (puoi personalizzare la dimensione)
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);

        
        cont += 1; 
        
        if (cont >= 2) {
            
            GG.setVisible(true);
        }
        Ccitta.setMinWidth(nuovaLarghezza / cont);

         Citta.setVisible(false);

        

    }

    @FXML
    void colonna4(ActionEvent event) {

        String nomeColonna = "Frutta";
         TableColumn<Tabella, String> Cfrutta = new TableColumn<>(nomeColonna);
         Cfrutta.setCellValueFactory(new PropertyValueFactory<Tabella, String>("frutta"));
         GG.getColumns().add(Cfrutta);

         double nuovaLarghezza = GG.getWidth() + 150.0; 
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);

        cont += 1;

        if (cont >= 2) {
            
            GG.setVisible(true);
        }

        Cfrutta.setMinWidth(nuovaLarghezza / cont);
       

        Frutta.setVisible(false);

         

    }

    @FXML
    void submit(ActionEvent event) {
        ObservableList<Tabella> TT = GG.getItems();
      

        Tabella row = new Builder().setNome(InputNome.getText()).setCosa(InputCose.getText()).setCitta(InputCitta.getText()).setFrutta(InputFrutta.getText()).build();
                TT.add(row);

                GG.setItems(TT);
                GG.refresh();
        
    }

  


    @FXML
    void randomChar(ActionEvent event) {
        Random random = new Random();
        int randomInt = random.nextInt(26);
        char randomLetter = (char) ('A' + randomInt);
       
        Lettera.setText(String.valueOf(randomLetter));
    
    }
    
}
