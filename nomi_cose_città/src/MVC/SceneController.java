package MVC;

import STRATEGY.LetterStartSequentialFileSearchStrategy;
import STRATEGY.SearchStrategy;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

// Controller per la gestione delle azioni nelle diverse scene
public class SceneController {
    
    private model1 model; // Modello associato al controller

    // Costruttore del controller
    public SceneController(model1 model) {
        this.model = model;
    }

    // Gestione dell'azione di login
    public void handleLoginAction(ActionEvent event) {
        // Verifica che l'username e la password non siano vuoti
        if (!model.getUsername().isEmpty() && !model.getPassword().isEmpty()) {
            // Utilizzo della strategia di ricerca sequenziale basata sulla lettera iniziale
            SearchStrategy sequentialSearch = new LetterStartSequentialFileSearchStrategy();
            // Ricerca dell'username e della password nel file di credenziali
            boolean wordExists1 = sequentialSearch.searchWord(model.getUsername(), "credenziali.txt");
            boolean wordExists2 = sequentialSearch.searchWord(model.getPassword(), "credenziali.txt");
            // Se entrambe le parole esistono nel file di credenziali, procedi al login
            if(wordExists1 && wordExists2) {
                // Visualizzazione della seconda scena (Scene2View)
                Scene2View scene2View = new Scene2View(model);
                scene2View.showView();
                // Chiusura della finestra corrente
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();
            }
        }
    }

    // Gestione dell'azione di registrazione
    public void handleSignUpAction(ActionEvent event){
        // Visualizzazione della terza scena (Scene3View) per la registrazione
        Scene3View scene3View = new Scene3View(model);
        scene3View.showView1();
        // Chiusura della finestra corrente
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
