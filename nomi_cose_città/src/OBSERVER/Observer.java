package OBSERVER;

//Interfaccia Observer che definisce il metodo di aggiornamento
public interface Observer {
    // Metodo chiamato quando lo stato dell'oggetto osservabile cambia
    void update(Observable observable);
}
