package COMMAND;

import MVC.FinalSceneController;
import javafx.event.ActionEvent;

// Questa classe rappresenta un comando per tornare alla schermata finale.
public class Back3Command implements Command {
    private FinalSceneController controller; // Il controller della schermata finale
    private ActionEvent event; // L'evento di azione che ha scatenato il comando

    // Costruttore per creare un nuovo comando Back3 con il controller e l'evento specificati.
    public Back3Command(FinalSceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    // Metodo per eseguire il comando, che chiama il metodo back() sul controller passando l'evento.
    @Override
    public void execute() {
        controller.back(event);
    }
}
