package OBSERVER;

/**
 * Questa interfaccia Observable definisce le operazioni per gestire gli osservatori.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public interface Observable {

    /**
     * Aggiunge un osservatore all'elenco degli osservatori.
     *
     * @param observer L'osservatore da aggiungere.
     */
    void addObserver(Observer observer);
    
    /**
     * Rimuove un osservatore dall'elenco degli osservatori.
     *
     * @param observer L'osservatore da rimuovere.
     */
    void removeObserver(Observer observer);
    
    /**
     * Notifica tutti gli osservatori registrati.
     */
    void notifyObservers();
}