package COMMAND;

import javafx.event.ActionEvent;
import MVC.Scene2Controller;

/**
 * Questa classe rappresenta un comando per avviare il gioco con un numero specificato di giocatori.
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public class PlayGameCommand implements Command {
    private Scene2Controller controller; // Il controller della scena
    private int numPlayers; // Il numero di giocatori per il gioco
    private ActionEvent event; // L'evento di azione che ha scatenato il comando

    /**
     * Costruttore per creare un nuovo comando PlayGame con il controller, il numero di giocatori e l'evento specificati.
     *
     * @param controller Il controller della scena
     * @param numPlayers Il numero di giocatori per il gioco
     * @param event      L'evento di azione che ha scatenato il comando
     */
    public PlayGameCommand(Scene2Controller controller, int numPlayers, ActionEvent event) {
        this.controller = controller;
        this.numPlayers = numPlayers;
        this.event = event;
    }

    /**
     * Metodo per eseguire il comando, che chiama il metodo playGame() sul controller passando il numero di giocatori e l'evento.
     */
    @Override
    public void execute() {
        controller.playGame(numPlayers, event);
    }
}
