


import BUILDER.BuilderTabella;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.scene.text.Text;
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
import javafx.util.Duration;




public class MainSceneController implements Initializable{

     @FXML
     private TableView<Tabella> GG;


 
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


    @FXML
    private Text TR;



    


    

   int cont = 0;
   
   char LetteraCasuale;
   int numTab = 0;
   
   
   boolean ColTot  = true;
   boolean ColNome;
   boolean ColCosa;
   boolean ColCitta;
   boolean ColFrutta;
   boolean RandomCharButton = true;
   TableColumn<Tabella, String> TOT = new TableColumn<>("tot");
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


   private int countdown = 2;


   private Timeline timeline;

   
   

    

   
 
   
     

   
    


    

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        RL.setVisible(false);
        //Submit.setVisible(false);
        GG.setVisible(false);
        menu1.setVisible(false);
        TR.setVisible(false);



        timeline = new Timeline(new KeyFrame(Duration.seconds(1.0), this::updateTimer));
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Imposta il testo iniziale del label
        TR.setText(String.valueOf(countdown));


        
        


    }


    


    @FXML
       public void updateTimer(ActionEvent event) {
        countdown--;
        TR.setText(String.valueOf(countdown));
    
        if(countdown==0){
            timeline.stop();
           
            PunteggioTabella();
            
           
           


        }
    }



    public void PunteggioTabella() {
     int punteggioTotale = 0;
     int punteggioNome =0;
     int punteggioCosa =0;
     int punteggioCitta=0;
     int punteggioFrutta=0;
    

clonedTableViews.add(0,GG);


   
  for (int i = 0; i < clonedTableViews.size(); i++) {
     TableView<Tabella> currentTableView = clonedTableViews.get(i);
     ObservableList<Tabella> currentTableData = currentTableView.getItems();
    Tabella lastRow1 = currentTableData.get(currentTableData.size() - 1);

    System.out.println("TABELLA: " + i);
    
    

     for (int j = 0; j < clonedTableViews.size() ; j++) {

        if(i!=j){
         
        
        
         TableView<Tabella> nextTableView = clonedTableViews.get(j);
         ObservableList<Tabella> nextTableData = nextTableView.getItems();
         Tabella lastRow2 = nextTableData.get(nextTableData.size() - 1);

         System.out.println("TABELLA: " + i +' '+ j);

        
       
                

        if (ColNome) {
        
        if(lastRow1.getNome().length() > 0 && lastRow2.getNome().length() > 0){

         char primaLetteraInserita1 = lastRow1.getNome().charAt(0);
         char primaLetteraInserita2 = lastRow2.getNome().charAt(0);
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getNome(), "nome.txt");
                     boolean wordExists2 = sequentialSearch.searchWord(lastRow2.getNome(), "nome.txt");

         if (punteggioNome != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                         if(lastRow1.getNome().equals(lastRow2.getNome())){
                                  punteggioNome = 5;
                                 }
                        else {
                               punteggioNome =10;
                         
                        }	
        }
    }	

     }
     System.out.println("p 1 " + lastRow1.getNome());
     System.out.println("p 2 " + lastRow2.getNome());


System.out.println("p nome" + punteggioNome);   

         if (ColCosa) {
               if(lastRow1.getCosa().length() > 0 && lastRow2.getCosa().length() > 0){

         char primaLetteraInserita1 = lastRow1.getCosa().charAt(0);
         char primaLetteraInserita2 = lastRow2.getCosa().charAt(0);
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getCosa(), "cosa.txt");
                     boolean wordExists2 = sequentialSearch.searchWord(lastRow2.getCosa(), "cosa.txt");

         if (punteggioCosa != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                         if(lastRow1.getCosa().equals(lastRow2.getCosa())){
                                  punteggioCosa = 5;
                                    
                                 }
                        else {
                               punteggioCosa = 10;
                             
                        }	
          }
       }	
                     
         }

         System.out.println("p 1 " + lastRow1.getCosa());
     System.out.println("p 2 " + lastRow2.getCosa());
System.out.println("p cosa" + punteggioCosa);  

         if (ColCitta) {
               if(lastRow1.getCitta().length() > 0 && lastRow2.getCitta().length() > 0){

         char primaLetteraInserita1 = lastRow1.getCitta().charAt(0);
         char primaLetteraInserita2 = lastRow2.getCitta().charAt(0);
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getCitta(), "citta.txt");
                     boolean wordExists2 = sequentialSearch.searchWord(lastRow2.getCitta(), "citta.txt");

         if (punteggioCitta != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                         if(lastRow1.getCitta().equals(lastRow2.getCitta())){
                                  punteggioCitta = 5;
                                    
                                 }
                        else {
                               punteggioCitta = 10;
                          
                        }	
          }
       }	
                     
         }
         System.out.println("p 1 " + lastRow1.getCitta());
         System.out.println("p 2 " + lastRow2.getCitta());


System.out.println("p citta" + punteggioCitta);   

         if (ColFrutta) {
               if(lastRow1.getFrutta().length() > 0 && lastRow2.getFrutta().length() > 0){

         char primaLetteraInserita1 = lastRow1.getFrutta().charAt(0);
         char primaLetteraInserita2 = lastRow2.getFrutta().charAt(0);
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getFrutta(), "frutta.txt");
                     boolean wordExists2 = sequentialSearch.searchWord(lastRow2.getFrutta(), "frutta.txt");

         if (punteggioFrutta != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                         if(lastRow1.getFrutta().equals(lastRow2.getFrutta())){
                                  punteggioFrutta = 5;
                                    
                                 }
                        else {
                               punteggioFrutta = 10;
                              
                        }	



                        
          }

          
       }	
                     
         }
         System.out.println("p 1 " + lastRow1.getFrutta());
         System.out.println("p 2 " + lastRow2.getFrutta());

System.out.println("p Frutta" + punteggioFrutta);    
        }
                
 }

             punteggioTotale = 0; 

             punteggioTotale += (punteggioNome + punteggioCosa + punteggioCitta + punteggioFrutta);
             System.out.println("Punteggio TOT  " + punteggioTotale);  
    
     
       lastRow1.setTot(punteggioTotale); 

       punteggioNome =0;
       punteggioCosa =0;
       punteggioCitta=0;
       punteggioFrutta=0;
   
       currentTableView.refresh();  

   // TableView<Tabella> tabTemp = clonedTableViews.remove(0);
   // clonedTableViews.add(tabTemp);
    
            } 
         clonedTableViews.remove(GG); 
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
             if (ColTot){
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

            
            clonedTableViews.add(clonedTableView);
            v1.getChildren().addAll(clonedTableView);

              v1.setMinWidth(nuovaLarghezza);
              v1.setPrefWidth(nuovaLarghezza);
              v1.setMaxWidth(Double.MAX_VALUE);
           
        }

       


        


       
       
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


          if(ColTot==true){
             TOT.setCellValueFactory(new PropertyValueFactory<Tabella, String>("tot"));
             GG.getColumns().add(TOT);
    
            nuovaLarghezza += 100.0; 
          
            cont += 1;
    
            
            GG.setMinWidth(nuovaLarghezza);
            GG.setPrefWidth(nuovaLarghezza);
            GG.setMaxWidth(Double.MAX_VALUE);
            TOT.setMinWidth(nuovaLarghezza / cont);

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
    String alfabetoItaliano = "abcdefghilmnopqrstuvz";
    Random random = new Random();
    char randomLetter = alfabetoItaliano.charAt(random.nextInt(alfabetoItaliano.length()));
    this.LetteraCasuale = randomLetter;

    Lettera.setText(String.valueOf(randomLetter));
    RL.setVisible(false);
    RandomCharButton = false; 

    for (TableView<Tabella> tableView : clonedTableViews) {
        ObservableList<Tabella> items = tableView.getItems();
        for (Tabella row : items) {
            row.setNome("");
            row.setCosa("");
            row.setCitta("");
            row.setFrutta("");
            row.setTot(0);
        }
        tableView.refresh();
    }

    PlayerThreads playerThreads = new PlayerThreads(clonedTableViews);
    playerThreads.startThreads(LetteraCasuale);
}

    

    @FXML
    void submit(ActionEvent event) {

         TR.setVisible(true);

        


        ObservableList<Tabella> TT = GG.getItems();
      
        BuilderTabella builder = new BuilderTabella();
        
 
        if (ColNome) {
             builder.setNome(Campo1.getText());

    }
    

        if (ColCosa) {
             builder.setCosa(Campo2.getText());
            
    }
    
    if (ColCitta) {
             builder.setCitta(Campo3.getText());
           
    }
    
    if (ColFrutta) {
             builder.setFrutta(Campo4.getText());
           
    }
    timeline.play();

    
    
    

        

       
        Tabella row = builder.build();
        TT.add(row);

        GG.setItems(TT); 


        GG.refresh();

        

        if(!RandomCharButton){
             RL.setVisible(true);
        }
        
    }

}
    



