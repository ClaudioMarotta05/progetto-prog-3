package MVC;

import ADAPTER.Metodo1;
import ADAPTER.adapter1;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

/**
 * Controller per la gestione delle azioni nelle diverse scene.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public class SceneController {
    
    private model1 model; // Modello associato al controller

    /**
     * Costruttore del controller.
     *
     * @param model Il modello associato al controller.
     */
    public SceneController(model1 model) {
        this.model = model;
    }

    /**
     * Gestione dell'azione di login.
     *
     * @param event L'evento di azione che ha scatenato l'azione di login.
     */
    public void handleLoginAction(ActionEvent event) {
        if (!model.getUsername().isEmpty() && !model.getPassword().isEmpty()) {

            Metodo1 ricerca1 = new Metodo1();
            adapter1 adattatore1 = new adapter1(ricerca1);
            boolean wordExists1 = adattatore1.search(model.getUsername(), "credenziali.txt");
            boolean wordExists2 = adattatore1.search(model.getPassword(), "credenziali.txt");

            if(wordExists1 && wordExists2) {
                Scene2View scene2View = new Scene2View(model);
                scene2View.showView();
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();
            }
        }
    }

    /**
     * Gestione dell'azione di registrazione.
     *
     * @param event L'evento di azione che ha scatenato l'azione di registrazione.
     */
    public void handleSignUpAction(ActionEvent event){
        Scene3View scene3View = new Scene3View(model);
        scene3View.showView1();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}