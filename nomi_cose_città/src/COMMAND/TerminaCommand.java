package COMMAND;

import MVC.MainSceneController;
import javafx.event.ActionEvent;

/**
 * Questa classe rappresenta un comando per terminare una partita.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public class TerminaCommand implements Command {
    private MainSceneController controller; // Il controller della scena principale
    private ActionEvent event; // L'evento di azione che ha scatenato il comando

    /**
     * Costruttore per creare un nuovo comando Termina con il controller e l'evento specificati.
     *
     * @param controller Il controller della scena principale.
     * @param event L'evento di azione che ha scatenato il comando.
     */
    public TerminaCommand(MainSceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    /**
     * Metodo per eseguire il comando, che chiama il metodo terminaPartita() sul controller passando l'evento.
     */
    @Override
    public void execute() {
        controller.terminaPartita(event);
    }
}