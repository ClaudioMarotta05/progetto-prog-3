package COMMAND;

import MVC.Scene3controller;
import javafx.event.ActionEvent;

// Questa classe rappresenta un comando per tornare alla schermata precedente.
public class Back1Command implements Command {
    private Scene3controller controller; // Il controller della scena
    private ActionEvent event; // L'evento di azione che ha scatenato il comando

    // Costruttore per creare un nuovo comando Back1 con il controller e l'evento specificati.
    public Back1Command(Scene3controller controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    // Metodo per eseguire il comando, che chiama il metodo back() sul controller passando l'evento.
    @Override
    public void execute() {
        controller.back(event);
    }
}
