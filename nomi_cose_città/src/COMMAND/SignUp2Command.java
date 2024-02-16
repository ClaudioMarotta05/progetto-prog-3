package COMMAND;

import MVC.Scene3controller;
import javafx.event.ActionEvent;

// Questa classe rappresenta un comando per gestire l'azione di registrazione.
public class SignUp2Command implements Command {
    private Scene3controller controller; // Il controller della scena
    private ActionEvent event; // L'evento di azione che ha scatenato il comando

    // Costruttore per creare un nuovo comando SignUp2 con il controller e l'evento specificati.
    public SignUp2Command(Scene3controller controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    // Metodo per eseguire il comando, che chiama il metodo signup() sul controller passando l'evento.
    @Override
    public void execute() {
        controller.signup(event);
    }
}
