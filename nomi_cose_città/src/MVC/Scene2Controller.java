package MVC;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Questa classe rappresenta il controller per la seconda scena dell'applicazione.
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
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

    /**
     * Costruttore della classe.
     * @param model Il modello dell'applicazione.
     */
    public Scene2Controller(model1 model){
        this.model = model; // Inizializza il modello
    }

    /**
     * Metodo per impostare lo stato della categoria nome.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat1(ActionEvent event) {
        this.nome = !this.nome;
        System.out.println("Valore di nome: " + this.nome);
    }

    /**
     * Metodo per impostare lo stato della categoria cosa.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat2(ActionEvent event) {
        this.cose = !this.cose;
        System.out.println("Valore di cosa: " + this.cose);
    }

    /**
     * Metodo per impostare lo stato della categoria citta.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat3(ActionEvent event) {
        this.citta = !this.citta;
        System.out.println("Valore di citta: " + this.citta);
    }

    /**
     * Metodo per impostare lo stato della categoria frutta.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat4(ActionEvent event) {
        this.frutta = !this.frutta;
        System.out.println("Valore di frutta: " + this.frutta);
    }

    /**
     * Metodo per impostare lo stato della categoria verbi.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat5(ActionEvent event) {
        this.verbi = !this.verbi;
        System.out.println("Valore di verbi: " + this.verbi);
    }

    /**
     * Metodo per impostare lo stato della categoria animali.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat6(ActionEvent event) {
        this.animali = !this.animali;
        System.out.println("Valore di animali: " + this.animali);
    }

    /**
     * Metodo per impostare lo stato della categoria piante.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat7(ActionEvent event) {
        this.piante = !this.piante;
        System.out.println("Valore di piante: " + this.piante);
    }

    /**
     * Metodo per impostare lo stato della categoria cantanti.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat8(ActionEvent event) {
        this.cantanti = !this.cantanti;
        System.out.println("Valore di cantanti: " + this.cantanti);
    }

    /**
     * Metodo per impostare lo stato della categoria nazioni.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat9(ActionEvent event) {
        this.nazioni = !this.nazioni;
        System.out.println("Valore di nazioni: " + this.nazioni);
    }

    /**
     * Metodo per impostare lo stato della categoria mestieri.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat10(ActionEvent event) {
        this.mestieri = !this.mestieri;
        System.out.println("Valore di mestieri: " + this.mestieri);
    }

    /**
     * Metodo per impostare lo stato della categoria celebrita.
     * @param event L'evento che ha scatenato l'azione.
     */
    public void setCat11(ActionEvent event) {
        this.celebrita = !this.celebrita;
        System.out.println("Valore di celebrita: " + this.celebrita);
    }

    /**
     * Metodo per ottenere lo stato della categoria nome.
     * @return Lo stato della categoria nome.
     */
    public boolean getNome() {
        return this.nome;
    }

    /**
     * Metodo per ottenere lo stato della categoria cose.
     * @return Lo stato della categoria cose.
     */
    public boolean getCose() {
        return this.cose;
    }


      /**
     * Metodo per ottenere lo stato della categoria citta.
     * @return Lo stato della categoria citta.
     */
    public boolean getCitta() {
        return this.citta;
    }

      /**
     * Metodo per ottenere lo stato della categoria frutta.
     * @return Lo stato della categoria frutta.
     */
    public boolean getFrutta() {
        return this.frutta;
    }

      /**
     * Metodo per ottenere lo stato della categoria verbi.
     * @return Lo stato della categoria verbi.
     */
    public boolean getVerbi() {
        return this.verbi;
    }

      /**
     * Metodo per ottenere lo stato della categoria animali.
     * @return Lo stato della categoria animali.
     */
    public boolean getAnimali() {
        return this.animali;
    }

      /**
     * Metodo per ottenere lo stato della categoria piante.
     * @return Lo stato della categoria piante.
     */
    public boolean getPiante() {
        return this.piante;
    }

      /**
     * Metodo per ottenere lo stato della categoria cantanti.
     * @return Lo stato della categoria cantanti.
     */
    public boolean getCantanti() {
        return this.cantanti;
    }

      /**
     * Metodo per ottenere lo stato della categoria nazioni.
     * @return Lo stato della categoria nazioni.
     */
    public boolean getNazioni() {
        return this.nazioni;
    }

      /**
     * Metodo per ottenere lo stato della categoria mestieri.
     * @return Lo stato della categoria mestieri.
     */
    public boolean getMestieri() {
        return this.mestieri;
    }

      /**
     * Metodo per ottenere lo stato della categoria celebrita.
     * @return Lo stato della categoria celebrita.
     */
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
