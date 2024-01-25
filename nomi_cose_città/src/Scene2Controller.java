

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;


public class Scene2Controller {

  

    private boolean nome;
    private boolean cose;
    private boolean citta;
    private boolean frutta;

   
    


    
   


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
        MainScene Scena = new MainScene(nome,cose,citta,frutta);
        Scena.showView();

         Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    }
}
