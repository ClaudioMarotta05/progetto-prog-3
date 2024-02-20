package OBSERVER;

/**
 * Questa interfaccia Observer definisce il metodo di aggiornamento.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public interface Observer {

    /**
     * Metodo chiamato quando lo stato dell'oggetto osservabile cambia.
     *
     * @param observable L'oggetto osservabile che ha subito il cambiamento di stato.
     */
    void update(Observable observable);
}