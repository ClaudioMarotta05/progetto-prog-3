package MVC;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

// Questa classe controlla la logica della scena finale dell'applicazione.
public class FinalSceneController {

    private model1 model; // Il modello dell'applicazione

    // Costruttore per creare una nuova istanza di FinalSceneController con il modello specificato.
    public FinalSceneController(model1 model) {
        this.model = model;
    }

    // Metodo chiamato quando l'utente torna indietro dalla scena finale.
    public void back(ActionEvent event) {
        // Visualizza la scena precedente (Scene2View)
        Scene2View scene = new Scene2View(model);
        scene.showView();

        // Chiude la finestra attuale
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
