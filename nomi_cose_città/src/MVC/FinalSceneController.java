package MVC;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

/**
 * Questa classe controlla la logica della scena finale dell'applicazione.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public class FinalSceneController {

    private model1 model; // Il modello dell'applicazione

    /**
     * Costruttore per creare una nuova istanza di FinalSceneController con il modello specificato.
     * @param model Il modello dell'applicazione.
     */
    public FinalSceneController(model1 model) {
        this.model = model;
    }

    /**
     * Metodo chiamato quando l'utente torna indietro dalla scena finale.
     * @param event L'evento di Action associato al click del bottone di ritorno.
     */
    public void back(ActionEvent event) {
        // Visualizza la scena precedente (Scene2View)
        Scene2View scene = new Scene2View(model);
        scene.showView();

        // Chiude la finestra attuale
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
