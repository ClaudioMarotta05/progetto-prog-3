package MVC;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;


public class Scene2Controller {

  

    private boolean nome;
    private boolean cose;
    private boolean citta;
    private boolean frutta;
    private String username;


    public Scene2Controller(String username){
        this.username = username;
    }
    

   

    public void setCat1(ActionEvent event) {
        this.nome = !this.nome;
        System.out.println("Valore di nome: " + this.nome);
    }

    
    public void setCat2(ActionEvent event) {
        this.cose = !this.cose;
        System.out.println("Valore di cosa: " + this.cose);
    }

    
    public void setCat3(ActionEvent event) {
        this.citta = !this.citta;
        System.out.println("Valore di citta: " + this.citta);
    }

    
    public void setCat4(ActionEvent event) {
        this.frutta = !this.frutta;
        System.out.println("Valore di frutta: " + this.frutta);
    }


     
    public boolean getNome() {
        return this.nome;
    }

    public boolean getCose() {
        return this.cose;
    }

    public boolean getCitta() {
        return this.citta;
    }

    public boolean getFrutta() {
        return this.frutta;
    }



    
    public void playGame(ActionEvent event) {

        model2 model = new model2();
        model.setCat1(nome);
        model.setCat2(cose);
        model.setCat3(citta);
        model.setCat4(frutta);
        model.setPartecipante(username);


        
        MainScene Scena = new MainScene(model);
        Scena.showView();

         Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    }
}
