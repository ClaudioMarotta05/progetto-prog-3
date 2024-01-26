package MVC;



import BUILDER.BuilderTabella;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn; 
import javafx.scene.control.TableView;
import javafx.scene.control.TextField; 
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;




import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import PROTOTYPE.CustomTables;
import STRATEGY.LetterStartSequentialFileSearchStrategy;
import STRATEGY.SearchStrategy;




public class MainSceneController {

    private TableView<Tabella> GG;
    private HBox Hbox;
   
    private Label Lettera;
    private Button RL;
   
    private VBox v1;
    private Text TR;
    private Button Start;
    private String Nominativo;
    


    boolean ColTot  = true;
    boolean ColNome;
    boolean ColCosa;
    boolean ColCitta;
    boolean ColFrutta;
    boolean RandomCharButton = true;

    private List<TableView<Tabella>> clonedTableViews = new ArrayList<>();

   int cont = 0;
   int punteggioAmministratore = 0;
   
   char LetteraCasuale;
   int numTab = 0;
   
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

   

public MainSceneController(TableView<Tabella> GG,boolean nome, boolean cose, boolean citta, boolean frutta, HBox Hbox, VBox v1, Label Lettera,Text TR,Button RL,Button Start, String Nominativo) {
    this.GG = GG;
    this.ColNome = nome;
    this.ColCosa = cose;
    this.ColCitta = citta;
    this.ColFrutta = frutta;
    this.Hbox = Hbox;
    this.v1 = v1;
    this.Lettera = Lettera;
    this.TR =TR;
    this.RL = RL;
    this.Start = Start;
    this.Nominativo = Nominativo;
 
    
}
   
    
    public void startGame(ActionEvent event) {

        

       Start.setVisible(false);
       RL.setVisible(true);
       GG.setVisible(true);
      

       timeline = new Timeline(new KeyFrame(Duration.seconds(1.0), this::updateTimer));
       timeline.setCycleCount(Timeline.INDEFINITE);

       // Imposta il testo iniziale del label
       TR.setText(String.valueOf(countdown));

        TableColumn<Tabella, String> Cnome = new TableColumn<>("nome");
        TableColumn<Tabella, String> Ccose = new TableColumn<>("cosa");
        TableColumn<Tabella, String> Ccitta = new TableColumn<>("citta");
        TableColumn<Tabella, String> Cfrutta = new TableColumn<>("frutta");
        TableColumn<Tabella, String> TOT = new TableColumn<>("tot");

        

         System.out.println("Il valore di ColNome è: " + ColNome);
          System.out.println("Il valore di ColCosa è: " + ColCosa);
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



    
       public void updateTimer(ActionEvent event) {
        countdown--;
        TR.setText(String.valueOf(countdown));
    
        if(countdown==0){
            timeline.stop();
           
            PunteggioTabella();

            countdown = 10;


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

           
        if(lastRow1.getNome().length() > 0 && lastRow2.getNome().length() == 0){

                char primaLetteraInserita1 = lastRow1.getNome().charAt(0);
               
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getNome(), "nome.txt");
                     if (wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                     {
                        punteggioNome =10;
                        cont++;

                     }
                    
        }

        if(lastRow1.getNome().length() > 0 && lastRow2.getNome().length() > 0 ){

                 char primaLetteraInserita1 = lastRow1.getNome().charAt(0);
                 char primaLetteraInserita2 = lastRow2.getNome().charAt(0);
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getNome(), "nome.txt");
                 boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getNome(), "nome.txt");
                
    
        

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
            if(lastRow1.getCosa().length() > 0 && lastRow2.getCosa().length() == 0){

                char primaLetteraInserita1 = lastRow1.getCosa().charAt(0);
               
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getCosa(), "cosa.txt");
                     if (wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                     {
                        punteggioCosa =10;
                        
                     }
                    
        }

        if(lastRow1.getCosa().length() > 0 && lastRow2.getCosa().length() > 0 ){

                 char primaLetteraInserita1 = lastRow1.getCosa().charAt(0);
                 char primaLetteraInserita2 = lastRow2.getCosa().charAt(0);
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getCosa(), "cosa.txt");
                 boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getCosa(), "cosa.txt");
                
    
        

                if (punteggioCosa != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                        if(lastRow1.getCosa().equals(lastRow2.getCosa())){
                                  punteggioCosa = 5;
                        }
                        else {
                               punteggioCosa =10;
                         
                        }	
                }
    

     }
                     
         }
         System.out.println("p 1 " + lastRow1.getCosa());
         System.out.println("p 2 " + lastRow2.getCosa());


System.out.println("p cosa" + punteggioCosa);



         if (ColCitta) {
            if(lastRow1.getCitta().length() > 0 && lastRow2.getCitta().length() == 0){

                char primaLetteraInserita1 = lastRow1.getCitta().charAt(0);
               
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getCitta(), "citta.txt");
                     if (wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                     {
                        punteggioCitta =10;
                        
                     }
                    
        }

        if(lastRow1.getCitta().length() > 0 && lastRow2.getCitta().length() > 0 ){

                 char primaLetteraInserita1 = lastRow1.getCitta().charAt(0);
                 char primaLetteraInserita2 = lastRow2.getCitta().charAt(0);
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getCitta(), "citta.txt");
                 boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getCitta(), "citta.txt");
                
    
        

                if (punteggioCitta != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                        if(lastRow1.getCitta().equals(lastRow2.getCitta())){
                                  punteggioCitta = 5;
                        }
                        else {
                               punteggioCitta =10;
                         
                        }	
                }
    

     }
                     
         }
         System.out.println("p 1 " + lastRow1.getCitta());
         System.out.println("p 2 " + lastRow2.getCitta());


System.out.println("p citta" + punteggioCitta);   

         if (ColFrutta) {
            if(lastRow1.getFrutta().length() > 0 && lastRow2.getFrutta().length() == 0){

                char primaLetteraInserita1 = lastRow1.getFrutta().charAt(0);
               
                     SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                     boolean wordExists1 = sequentialSearch.searchWord(lastRow1.getFrutta(), "frutta.txt");
                     if (wordExists1 && primaLetteraInserita1 == LetteraCasuale)
                     {
                        punteggioFrutta =10;
                        
                     }
                    
        }

        if(lastRow1.getFrutta().length() > 0 && lastRow2.getFrutta().length() > 0 ){

                 char primaLetteraInserita1 = lastRow1.getFrutta().charAt(0);
                 char primaLetteraInserita2 = lastRow2.getFrutta().charAt(0);
                 SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
                 boolean  wordExists1 = sequentialSearch.searchWord(lastRow1.getFrutta(), "frutta.txt");
                 boolean  wordExists2 = sequentialSearch.searchWord(lastRow1.getFrutta(), "frutta.txt");
                
    
        

                if (punteggioFrutta != 5 && wordExists1 && wordExists2 && primaLetteraInserita1 == LetteraCasuale && primaLetteraInserita2 == LetteraCasuale) {

                        if(lastRow1.getFrutta().equals(lastRow2.getFrutta())){
                                  punteggioFrutta = 5;
                        }
                        else {
                               punteggioFrutta =10;
                         
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

       if(i==0){
        punteggioAmministratore += punteggioTotale;
        System.out.println("Punteggio Amministratore " + punteggioAmministratore);  
       }

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
 

    
    public void addTables(ActionEvent event)
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


   public void backToSettings(ActionEvent event)
    {/* 
        Scene2View scene2View = new Scene2View();
        scene2View.showView();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
         */
    }

/* 
    @FXML
    void colonna1(ActionEvent event) {
    double nuovaLarghezza;
    TableColumn<Tabella, String> Cnome = new TableColumn<>("nome");
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
    TableColumn<Tabella, String> Ccose = new TableColumn<>("cosa");
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
    TableColumn<Tabella, String> Ccitta = new TableColumn<>("citta");
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
    TableColumn<Tabella, String> Cfrutta = new TableColumn<>("frutta");
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
    
*/

public void randomChar(ActionEvent event) {
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

    

    
    public void submit(ActionEvent event) {

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



    public void terminaPartita(ActionEvent event){
        FinalScene View = new FinalScene(Nominativo);
        View.showView();

      
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

}
    



