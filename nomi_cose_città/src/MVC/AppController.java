package MVC;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

// Questa classe rappresenta il controller principale dell'applicazione.
public class AppController {
    private model1 model; // Il modello dell'applicazione

    // Costruttore per creare un nuovo controller principale con il modello specificato.
    public AppController(model1 model) {
        this.model = model;
    }

    // Metodo per gestire l'azione di avanzamento alla prossima schermata.
    public void Next(ActionEvent event) {
        // Creazione e visualizzazione della vista della scena 1
        Scene1View scene1View = new Scene1View(model);
        scene1View.showView();

        // Chiusura della finestra corrente
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
