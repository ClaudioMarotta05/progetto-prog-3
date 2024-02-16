package COMMAND;

import MVC.MainSceneController;
import javafx.event.ActionEvent;

// Questa classe rappresenta un comando per avviare il gioco.
public class StartCommand implements Command {
    private MainSceneController controller; // Il controller della scena principale
    private ActionEvent event; // L'evento di azione che ha scatenato il comando

    // Costruttore per creare un nuovo comando Start con il controller e l'evento specificati.
    public StartCommand(MainSceneController controller, ActionEvent event) {
        this.controller = controller;
        this.event = event;
    }

    // Metodo per eseguire il comando, che chiama il metodo startGame() sul controller passando l'evento.
    @Override
    public void execute() {
        controller.startGame(event);
    }
}
