package OBSERVER;

// Interfaccia Observable che definisce le operazioni per gestire gli osservatori
public interface Observable {
    // Aggiunge un osservatore all'elenco degli osservatori
    void addObserver(Observer observer);
    
    // Rimuove un osservatore dall'elenco degli osservatori
    void removeObserver(Observer observer);
    
    // Notifica tutti gli osservatori registrati
    void notifyObservers();
}
