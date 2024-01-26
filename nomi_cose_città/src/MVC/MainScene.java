package MVC;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
//import javafx.scene.control.MenuButton;
 
import javafx.scene.control.TableView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class MainScene extends AnchorPane{
    private TableView<Tabella> GG;
    private HBox Hbox;
    private Button Start;
    //private MenuButton menu1;
    private Label Lettera;
    private Button RL;
    private Button Submit;
    private Button Back;
    private Button Termina;
    private Button newButton;
    private VBox v1;
    private Text TR;
    private Label Nominativo;

    private boolean nome;
    private boolean cose;
    private boolean citta;
    private boolean frutta;
    private String Username;

    model2 model;
    MainSceneController controller;

    public MainScene(model2 model) {
        this.model=model;

        initialize();

    }

    

    public MainScene() {
       initialize();
    }



    private void initialize() {

        Username = model.getPartecipante();

        Nominativo = new Label(Username);
        Nominativo.setLayoutX(66);
        Nominativo.setLayoutY(80);



        GG = new TableView<Tabella>();
        GG.setLayoutX(66);
        GG.setLayoutY(101);
        GG.setPrefHeight(135);
        GG.setVisible(false);
        
       

        Hbox = new HBox();
        Hbox.setAlignment(Pos.CENTER);
        Hbox.setLayoutX(3);
        Hbox.setLayoutY(478);
        Hbox.setPrefHeight(45);
        Hbox.setPrefWidth(779);
        
        Lettera = new Label();
        Lettera.setLayoutX(503);
        Lettera.setLayoutY(24);
        Lettera.setPrefHeight(57);
        Lettera.setPrefWidth(77);
        Lettera.setFont(new Font("Bell MT Bold", 30));

        v1 = new VBox();
        v1.setLayoutX(66);
        v1.setLayoutY(259);
        v1.setPrefHeight(209);
        v1.setPrefWidth(255);

        TR = new Text();
        TR.setLayoutX(359);
        TR.setLayoutY(67);
        TR.setFont(new Font(36));
        TR.setVisible(false);

        RL = new Button("Lettera");
        RL.setLayoutX(685);
        RL.setLayoutY(23);
        RL.setVisible(false);
        
        Termina = new Button("Termina");
        Termina.setLayoutX(597);
        Termina.setLayoutY(23);
        
        

        

        Start = new Button("START");
        Start.setLayoutX(354);
        Start.setLayoutY(268);
        Start.setVisible(true);

        nome = model.getCat1();
        cose = model.getCat2();
        citta = model.getCat3();
        frutta = model.getCat4();

        controller = new MainSceneController(GG,nome,cose,citta,frutta,Hbox,v1,Lettera,TR,RL,Start,Username);
        

        /* 

        menu1 = new MenuButton("Menu");
        menu1.setLayoutX(597);
        menu1.setLayoutY(23);
        menu1.setPrefHeight(35);
        menu1.setPrefWidth(63);
        menu1.setVisible(false);
        configureMenuItems(menu1);

       */

        

        Submit = new Button("Submit");
        Submit.setLayoutX(302);
        Submit.setLayoutY(523);
        

        Back = new Button("<-");
        Back.setLayoutX(-1);
        Back.setLayoutY(-2);
        

        newButton = new Button("NEW");
        newButton.setLayoutX(102);
        newButton.setLayoutY(28);


        

        
        Start.setOnAction(controller::startGame);
        Submit.setOnAction(controller::submit);
        Back.setOnAction(controller::backToSettings);
        newButton.setOnAction(controller::addTables);
        RL.setOnAction(controller::randomChar);
        Termina.setOnAction(controller::terminaPartita);

        getChildren().addAll(GG, Hbox, Start, Lettera, RL, Submit, Back, newButton, v1, TR, Termina, Nominativo);

    }
    /* 
    private void configureMenuItems(MenuButton menuButton) {
        CheckMenuItem col1 = new CheckMenuItem("Nome");
        col1.setOnAction(controller::colonna1);

        CheckMenuItem col2 = new CheckMenuItem("Cose");
        col2.setOnAction(controller::colonna2);

        CheckMenuItem col3 = new CheckMenuItem("Citta");
        col3.setOnAction(controller::colonna3);

        CheckMenuItem col4 = new CheckMenuItem("Frutta");
        col4.setOnAction(controller::colonna4);

        menuButton.getItems().addAll(col1, col2, col3, col4);
    }
    */

    public void showView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(this, 800, 600));
        stage.show();
    }
}
