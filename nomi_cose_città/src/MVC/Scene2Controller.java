package MVC;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

// Questa classe rappresenta il controller per la seconda scena dell'applicazione
public class Scene2Controller {
    private model1 model; // Modello dell'applicazione
    private boolean nome; // Variabile per la categoria "nome"
    private boolean cose; // Variabile per la categoria "cosa"
    private boolean citta; // Variabile per la categoria "città"
    private boolean frutta; // Variabile per la categoria "frutta"
    private boolean verbi; // Variabile per la categoria "verbi"
    private boolean animali; // Variabile per la categoria "animali"
    private boolean piante; // Variabile per la categoria "piante"
    private boolean cantanti; // Variabile per la categoria "cantanti"
    private boolean nazioni; // Variabile per la categoria "nazioni"
    private boolean mestieri; // Variabile per la categoria "mestieri"
    private boolean celebrita; // Variabile per la categoria "celebrità"
    private int numPlayers; // Numero di giocatori

    // Costruttore della classe
    public Scene2Controller(model1 model){
        this.model = model; // Inizializza il modello
    }

    // Metodi per impostare lo stato delle categorie
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

    public void setCat5(ActionEvent event) {
        this.verbi = !this.verbi;
        System.out.println("Valore di verbi: " + this.verbi);
    }

    public void setCat6(ActionEvent event) {
        this.animali = !this.animali;
        System.out.println("Valore di animali: " + this.animali);
    }

    public void setCat7(ActionEvent event) {
        this.piante = !this.piante;
        System.out.println("Valore di piante: " + this.piante);
    }

    public void setCat8(ActionEvent event) {
        this.cantanti = !this.cantanti;
        System.out.println("Valore di cantanti: " + this.cantanti);
    }

    public void setCat9(ActionEvent event) {
        this.nazioni = !this.nazioni;
        System.out.println("Valore di nazioni: " + this.nazioni);
    }

    public void setCat10(ActionEvent event) {
        this.mestieri = !this.mestieri;
        System.out.println("Valore di mestieri: " + this.mestieri);
    }

    public void setCat11(ActionEvent event) {
        this.celebrita = !this.celebrita;
        System.out.println("Valore di celebrita: " + this.celebrita);
    }

    // Metodi per ottenere lo stato delle categorie
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

    public boolean getVerbi() {
        return this.verbi;
    }

    public boolean getAnimali() {
        return this.animali;
    }

    public boolean getPiante() {
        return this.piante;
    }

    public boolean getCantanti() {
        return this.cantanti;
    }

    public boolean getNazioni() {
        return this.nazioni;
    }

    public boolean getMestieri() {
        return this.mestieri;
    }

    public boolean getCelebrita() {
        return this.celebrita;
    }

    // Metodo per tornare alla schermata di accesso
    public void back(ActionEvent event){
        // Torna alla schermata di accesso
        Scene1View scene = new Scene1View(model);
        scene.showView();

        // Chiude la finestra attuale
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    // Metodo per avviare il gioco
    public void playGame(int numPLayers, ActionEvent event) {
        // Imposta il numero di giocatori
        this.numPlayers = numPLayers;
        
        // Imposta lo stato delle categorie nel modello
        model.setCat1(nome);
        model.setCat2(cose);
        model.setCat3(citta);
        model.setCat4(frutta);
        model.setCat5(verbi);
        model.setCat6(animali);
        model.setCat7(piante);
        model.setCat8(cantanti);
        model.setCat9(nazioni);
        model.setCat10(mestieri);
        model.setCat11(celebrita);
        model.setNumPlayers(numPlayers);
      
        // Avvia la schermata principale del gioco
        MainScene Scena = new MainScene(model);
        Scena.showView();

        // Chiude la finestra attuale
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
