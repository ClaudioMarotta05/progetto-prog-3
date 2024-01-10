


import BUILDER.BuilderTabella;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn; 
import javafx.scene.control.TableView;
import javafx.scene.control.TextField; 
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import BUILDER.Tabella;
import PROTOTYPE.CustomTables;
import STRATEGY.LetterStartSequentialFileSearchStrategy;
import STRATEGY.SearchStrategy;



public class MainSceneController implements Initializable{

     @FXML
     private TableView<Tabella> GG;

    @FXML
    private TableView<Tabella> TotCol;

 
    private List<TableView<Tabella>> clonedTableViews = new ArrayList<>();

   
    @FXML
    private HBox Hbox;

    @FXML
    private VBox v1;


    @FXML
    private Label Lettera;

    @FXML
    private Button RL;

    @FXML
    private Button Submit;
   
    @FXML
    private Button Start;

    @FXML
    private Button Back;

    @FXML
    private Button parolaNuova;

    @FXML
    private MenuButton menu1;



    


    

   int cont = 0;
   int punteggio = 0;
   char LetteraCasuale;
   int numTab = 0;
   
   
   boolean ColTot  = false;
   boolean ColNome;
   boolean ColCosa;
   boolean ColCitta;
   boolean ColFrutta;
   boolean RandomCharButton = true;
   TableColumn<Tabella, String> TOT = new TableColumn<>("TOT");
   TableColumn<Tabella, String> Cnome = new TableColumn<>("nome");
   TableColumn<Tabella, String> Ccose = new TableColumn<>("cosa");
   TableColumn<Tabella, String> Ccitta = new TableColumn<>("citta");
   TableColumn<Tabella, String> Cfrutta = new TableColumn<>("frutta");
   Label label1 = new Label("Nome: ");
   Label label2 = new Label("Cose: ");
   Label label3 = new Label("Cittá: ");
   Label label4 = new Label("Frutta: ");
   TextField Campo1 = new TextField();
   TextField Campo2 = new TextField();
   TextField Campo3 = new TextField();
   TextField Campo4 = new TextField();

   

    

   
 
   
     

   
    


    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        RL.setVisible(false);
        //Submit.setVisible(false);
        TotCol.setVisible(false);
        GG.setVisible(false);
        menu1.setVisible(false);


    }

   
        

    public void setColValues(boolean ColNome, boolean ColCosa, boolean ColCitta, boolean ColFrutta) {
        this.ColNome = ColNome;
        this.ColCosa = ColCosa;
        this.ColCitta = ColCitta;
        this.ColFrutta = ColFrutta;
    }


    @FXML
    void addTables(ActionEvent event)
    {
         double nuovaLarghezza = 0.0;
         int numCol = 0;
        
        
        if(numTab<=2)
        {
            if (ColNome){
                numCol++;
            }
            if (ColCosa){
                numCol++;
            }
            if (ColCitta){
                numCol++;
            }
            if (ColFrutta){
                numCol++;
            }
            nuovaLarghezza += (numCol*100.0); 
            numTab += 1;

            CustomTables tableViewCloner = new CustomTables();
            TableView<Tabella> clonedTableView = tableViewCloner.cloneTableViewStructure(GG);

            ObservableList<Tabella> originalData = GG.getItems();
            System.out.println("Dimensione dei dati nella TableView originale: " + originalData.size());
            for (Tabella row : originalData) {
                System.out.println(row.getNome() + " - " + row.getCosa() + " - " + row.getCitta() + " - " + row.getFrutta());
            }

            ObservableList<Tabella> clonedData = clonedTableView.getItems();
            System.out.println("Dimensione dei dati nella TableView clonata: " + clonedData.size());

            for (Tabella row : clonedData) {
                System.out.println(row.getNome() + " - " + row.getCosa() + " - " + row.getCitta() + " - " + row.getFrutta());
            }

            clonedTableView.setId("TableView_" + numTab);
            clonedTableViews.add(clonedTableView);
            v1.getChildren().addAll(clonedTableView);

              v1.setMinWidth(nuovaLarghezza);
              v1.setPrefWidth(nuovaLarghezza);
              v1.setMaxWidth(Double.MAX_VALUE);
           
        }

       


        


        //PlayerThreads playerThreads = new PlayerThreads(clonedTableViews);

        //playerThreads.startThreads(LetteraCasuale);
       
    }

   



        
    @FXML
    void backToSettings(ActionEvent event)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }


    



    @FXML
    void startGame(ActionEvent event) {

        Start.setVisible(false);
        RL.setVisible(true);
        TotCol.setVisible(true);
        GG.setVisible(true);
        menu1.setVisible(true);

         System.out.println("Il valore di numero è: " + ColNome);
          System.out.println("Il valore di numero è: " + ColCosa);
           System.out.println("Il valore di numero è: " + ColCitta);
            System.out.println("Il valore di numero è: " + ColFrutta);

       
        double nuovaLarghezza = 0.0 ;

        if(ColNome == true){
            
            Cnome.setCellValueFactory(new PropertyValueFactory<Tabella, String>("nome"));
    
            GG.getColumns().add(Cnome);
    
            nuovaLarghezza += 100.0; 
            
            Hbox.getChildren().addAll(label1,Campo1);
    
            cont += 1;
    
        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Cnome.setMinWidth(nuovaLarghezza / cont); 
       
            
    
            
              
            
        }
    
            if(ColCosa == true){
             Ccose.setCellValueFactory(new PropertyValueFactory<Tabella, String>("cosa"));
             GG.getColumns().add(Ccose);
    
           nuovaLarghezza += 100.0; 
            Hbox.getChildren().addAll(label2,Campo2);
    
            cont += 1;
    
            GG.setMinWidth(nuovaLarghezza);
            GG.setPrefWidth(nuovaLarghezza);
            GG.setMaxWidth(Double.MAX_VALUE);
            Ccose.setMinWidth(nuovaLarghezza / cont);
        

           
        }
    
    
        if(ColCitta==true){
            Ccitta.setCellValueFactory(new PropertyValueFactory<Tabella, String>("citta"));
             GG.getColumns().add(Ccitta);
    
         nuovaLarghezza += 100.0; 
            Hbox.getChildren().addAll(label3,Campo3);

             cont += 1;
    
              GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
            Ccitta.setMinWidth(nuovaLarghezza / cont);

           

        }
    
    
         if(ColFrutta==true){
             Cfrutta.setCellValueFactory(new PropertyValueFactory<Tabella, String>("frutta"));
             GG.getColumns().add(Cfrutta);
    
            nuovaLarghezza += 100.0; 
            Hbox.getChildren().addAll(label4,Campo4);
    
            cont += 1;
    
            
            GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
            Cfrutta.setMinWidth(nuovaLarghezza / cont);

       

           
        }
    
            
    }

    @FXML
    void colonna1(ActionEvent event) {
    double nuovaLarghezza;
    if(ColNome == false){
        
        Cnome.setCellValueFactory(new PropertyValueFactory<Tabella, String>("nome"));
        GG.getColumns().add(Cnome);
        nuovaLarghezza = GG.getWidth() + 100.0; 
        
        Hbox.getChildren().addAll(label1,Campo1);

        cont += 1;


        
      

        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Cnome.setMinWidth(nuovaLarghezza / cont); 

        
            ColNome = true;

        
        
    }else{
            GG.getColumns().remove(Cnome);
            Hbox.getChildren().removeAll(label1, Campo1);
            nuovaLarghezza = GG.getWidth() - 100.0; 
            GG.setMinWidth(nuovaLarghezza);
            GG.setPrefWidth(nuovaLarghezza);
            GG.setMaxWidth(Double.MAX_VALUE);
            Cnome.setMinWidth(nuovaLarghezza / cont); 
            cont -= 1;
            ColNome = false;

         }

    }

    @FXML
    void colonna2(ActionEvent event) {

    double nuovaLarghezza;
    if(ColCosa == false){
         Ccose.setCellValueFactory(new PropertyValueFactory<Tabella, String>("cosa"));
         GG.getColumns().add(Ccose);

         nuovaLarghezza = GG.getWidth() + 100.0; 
        

        
        
        Hbox.getChildren().addAll(label2,Campo2);

        cont += 1;


        
        

        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Ccose.setMinWidth(nuovaLarghezza / cont);
        ColCosa = true;
    }else{
            GG.getColumns().remove(Ccose);
            Hbox.getChildren().removeAll(label2, Campo2);
            nuovaLarghezza = GG.getWidth() - 100.0; 
            GG.setMinWidth(nuovaLarghezza);
            GG.setPrefWidth(nuovaLarghezza);
            GG.setMaxWidth(Double.MAX_VALUE);
            Ccose.setMinWidth(nuovaLarghezza / cont); 
            cont -= 1;
            ColCosa = false;
    }
  
        

         
    }

    @FXML
    void colonna3(ActionEvent event) {
    double nuovaLarghezza;
    if(ColCitta==false){
        Ccitta.setCellValueFactory(new PropertyValueFactory<Tabella, String>("citta"));
         GG.getColumns().add(Ccitta);

        nuovaLarghezza = GG.getWidth() + 100.0; 
        

       
        
        Hbox.getChildren().addAll(label3,Campo3);

        
        cont += 1; 

       
       

        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);
        Ccitta.setMinWidth(nuovaLarghezza / cont);
        ColCitta = true;
    }else{
            GG.getColumns().remove(Ccitta);
            Hbox.getChildren().removeAll(label3, Campo3);
            nuovaLarghezza = GG.getWidth() - 100.0; 
            GG.setMinWidth(nuovaLarghezza);
            GG.setPrefWidth(nuovaLarghezza);
            GG.setMaxWidth(Double.MAX_VALUE);
            Ccitta.setMinWidth(nuovaLarghezza / cont);
            cont -= 1; 
            ColCitta = false;
    }
    
         

        

        

    }

    @FXML
    void colonna4(ActionEvent event) {
    double nuovaLarghezza;
    if(ColFrutta==false){
         Cfrutta.setCellValueFactory(new PropertyValueFactory<Tabella, String>("frutta"));
         GG.getColumns().add(Cfrutta);

         nuovaLarghezza = GG.getWidth() + 100.0; 
        

        
       
        Hbox.getChildren().addAll(label4,Campo4);

        cont += 1;

        GG.setMinWidth(nuovaLarghezza);
        GG.setPrefWidth(nuovaLarghezza);
        GG.setMaxWidth(Double.MAX_VALUE);

        Cfrutta.setMinWidth(nuovaLarghezza / cont);
        ColFrutta = true;
    }else{
            GG.getColumns().remove(Cfrutta);
            Hbox.getChildren().removeAll(label4, Campo4);
            nuovaLarghezza = GG.getWidth() - 100.0; 
            GG.setMinWidth(nuovaLarghezza);
            GG.setPrefWidth(nuovaLarghezza);
            GG.setMaxWidth(Double.MAX_VALUE);
            Cfrutta.setMinWidth(nuovaLarghezza / cont); 
            cont -= 1;
            ColFrutta = false;
    }
}
    
    
@FXML
void randomChar(ActionEvent event) {
    Random random = new Random();
    int randomInt = random.nextInt(26);
    char randomLetter = (char) ('A' + randomInt);
    this.LetteraCasuale = randomLetter;
   
    Lettera.setText(String.valueOf(randomLetter));
    RL.setVisible(false);
    RandomCharButton = false; 
}


    

    @FXML
    void submit(ActionEvent event) {

        
    double nuovaLarghezza;
       if(ColTot==false){
          TOT.setCellValueFactory(new PropertyValueFactory<Tabella, String>("tot"));
          TotCol.getColumns().add(TOT);

         nuovaLarghezza = TotCol.getWidth();   

        TOT.setMinWidth(nuovaLarghezza);
        ColTot = true;
    }
           

        ObservableList<Tabella> TT = GG.getItems();
      
        BuilderTabella builder = new BuilderTabella();
        
 
        if (ColNome) {
             builder.setNome(Campo1.getText());

            if (Campo1.getText().length() > 0) {

                char primaLetteraInserita = Campo1.getText().charAt(0);

                SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                boolean wordExists = sequentialSearch.searchWord(Campo1.getText(), "nomi.txt");

                if(wordExists && primaLetteraInserita == LetteraCasuale){
                    punteggio += 10;
                    builder.setTot(punteggio);
                }
                
               

            
        }
    }
    

        if (ColCosa) {
             builder.setCosa(Campo2.getText());
             if (Campo2.getText().length() > 0) {

                char primaLetteraInserita = Campo2.getText().charAt(0);
                
                SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                boolean wordExists = sequentialSearch.searchWord(Campo2.getText(), "cose.txt");

                if(wordExists && primaLetteraInserita == LetteraCasuale){
                    punteggio += 10;
                    builder.setTot(punteggio);
                }
        }
    }
    
    if (ColCitta) {
             builder.setCitta(Campo3.getText());
             if (Campo3.getText().length() > 0) {

                char primaLetteraInserita = Campo3.getText().charAt(0);
                
                SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                boolean wordExists = sequentialSearch.searchWord(Campo3.getText(), "citta.txt");

                if(wordExists && primaLetteraInserita == LetteraCasuale){
                    punteggio += 10;
                    builder.setTot(punteggio);
                }
        }
    }
    
    if (ColFrutta) {
             builder.setFrutta(Campo4.getText());
             if (Campo4.getText().length() > 0) {

                char primaLetteraInserita = Campo4.getText().charAt(0);
                
                SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                boolean wordExists = sequentialSearch.searchWord(Campo4.getText(), "frutta.txt");

                if(wordExists && primaLetteraInserita == LetteraCasuale){
                    punteggio += 10;
                    builder.setTot(punteggio);
                }


        }
    }

    punteggio = 0;

        

       
        Tabella row = builder.build();
        TT.add(row);

        GG.setItems(TT); 
        GG.refresh();

        TotCol.setItems(TT);  
        TotCol.refresh();

        if(!RandomCharButton){
             RL.setVisible(true);
        }
        
    }

}
    



