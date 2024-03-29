package COMMAND;

import MVC.SceneController;
import javafx.event.ActionEvent;

/**
 * Questa classe rappresenta un comando per gestire l'azione di registrazione.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public class SignUpCommand implements Command {
    private SceneController controller; // Il controller della scena
    private ActionEvent event; // L'evento di azione che ha scatenato il comando

    /**
     * Costruttore per creare un nuovo comando SignUp con il controller e l'evento specificati.
     *
     * @param controller Il controller della scena.
     * @param event L'evento di azione che ha scatenato il comando.
     */
    public SignUpCommand(SceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    /**
     * Metodo per eseguire il comando, che chiama il metodo handleSignUpAction() sul controller passando l'evento.
     */
    @Override
    public void execute() {
        controller.handleSignUpAction(event);
    }
}