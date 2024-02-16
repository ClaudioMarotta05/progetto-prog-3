package COMMAND;

import MVC.SceneController;
import javafx.event.ActionEvent;

// Questa classe rappresenta un comando per gestire l'azione di login.
public class LoginCommand implements Command {
    private SceneController controller; // Il controller della scena
    private ActionEvent event; // L'evento di azione che ha scatenato il comando

    // Costruttore per creare un nuovo comando Login con il controller e l'evento specificati.
    public LoginCommand(SceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    // Metodo per eseguire il comando, che chiama il metodo handleLoginAction() sul controller passando l'evento.
    @Override
    public void execute() {
        controller.handleLoginAction(event);
    }
}
