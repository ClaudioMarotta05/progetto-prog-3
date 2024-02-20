package MVC;

import java.util.ArrayList;
import java.util.List;

import OBSERVER.Observable;
import OBSERVER.Observer;

/**
 * Questa classe rappresenta il modello dell'applicazione.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public class model1 implements Observable {

    // Variabili di istanza per l'utente e le categorie
    private String username; // Username dell'utente
    private String password; // Password dell'utente
    private String mail; // Indirizzo email dell'utente
    private boolean cat1; // Stato della categoria 1
    private boolean cat2; // Stato della categoria 2
    private boolean cat3; // Stato della categoria 3
    private boolean cat4; // Stato della categoria 4
    private boolean cat5; // Stato della categoria 5
    private boolean cat6; // Stato della categoria 6
    private boolean cat7; // Stato della categoria 7
    private boolean cat8; // Stato della categoria 8
    private boolean cat9; // Stato della categoria 9
    private boolean cat10; // Stato della categoria 10
    private boolean cat11; // Stato della categoria 11
    private int numPlayers; // Numero di giocatori
    private List<Observer> observers = new ArrayList<>(); // Lista degli osservatori
    private int[] punteggi; // Punteggi dei giocatori
    private int[] posizioni; // Posizioni dei giocatori

    /**
     * Costruttore vuoto per la classe model1.
     */
    public model1() {

    }

    /**
     * Metodo getter per l'username dell'utente.
     *
     * @return L'username dell'utente.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo setter per l'username dell'utente.
     *
     * @param username Il nuovo username dell'utente.
     */
    public void setUsername(String username) {
        this.username = username;
        notifyObservers();
    }

    /**
     * Metodo getter per la password dell'utente.
     *
     * @return La password dell'utente.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodo setter per la password dell'utente.
     *
     * @param password La nuova password dell'utente.
     */
    public void setPassword(String password) {
        this.password = password;
        notifyObservers();
    }

    /**
     * Metodo getter per l'email dell'utente.
     *
     * @return L'email dell'utente.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Metodo setter per l'email dell'utente.
     *
     * @param mail Il nuovo indirizzo email dell'utente.
     */
    public void setMail(String mail) {
        this.mail = mail;
        notifyObservers();
    }

/**
 * Metodo setter per la categoria nomi.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria nomi.
 */
public void setCat1(boolean value) {
    this.cat1 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria nomi.
 *
 * @return Il valore booleano che indica lo stato della categoria nomi.
 */
public boolean getCat1() {
    return this.cat1;
}

/**
 * Metodo setter per la categoria cose.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria cose.
 */
public void setCat2(boolean value) {
    this.cat2 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria cose.
 *
 * @return Il valore booleano che indica lo stato della categoria cose.
 */
public boolean getCat2() {
    return this.cat2;
}

/**
 * Metodo setter per la categoria città.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria città.
 */
public void setCat3(boolean value) {
    this.cat3 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria città.
 *
 * @return Il valore booleano che indica lo stato della categoria città.
 */
public boolean getCat3() {
    return this.cat3;
}

/**
 * Metodo setter per la categoria frutta.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria frutta.
 */
public void setCat4(boolean value) {
    this.cat4 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria frutta.
 *
 * @return Il valore booleano che indica lo stato della categoria frutta.
 */
public boolean getCat4() {
    return this.cat4;
}

/**
 * Metodo setter per la categoria verbi.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria verbi.
 */
public void setCat5(boolean value) {
    this.cat5 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria verbi.
 *
 * @return Il valore booleano che indica lo stato della categoria verbi.
 */
public boolean getCat5() {
    return this.cat5;
}

/**
 * Metodo setter per la categoria animali.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria animali.
 */
public void setCat6(boolean value) {
    this.cat6 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria animali.
 *
 * @return Il valore booleano che indica lo stato della categoria animali.
 */
public boolean getCat6() {
    return this.cat6;
}

/**
 * Metodo setter per la categoria piante.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria piante.
 */
public void setCat7(boolean value) {
    this.cat7 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria piante.
 *
 * @return Il valore booleano che indica lo stato della categoria piante.
 */
public boolean getCat7() {
    return this.cat7;
}

/**
 * Metodo setter per la categoria cantanti.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria cantanti.
 */
public void setCat8(boolean value) {
    this.cat8 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria cantanti.
 *
 * @return Il valore booleano che indica lo stato della categoria cantanti.
 */
public boolean getCat8() {
    return this.cat8;
}

/**
 * Metodo setter per la categoria nazioni.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria nazioni.
 */
public void setCat9(boolean value) {
    this.cat9 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria nazioni.
 *
 * @return Il valore booleano che indica lo stato della categoria nazioni.
 */
public boolean getCat9() {
    return this.cat9;
}

/**
 * Metodo setter per la categoria mestieri.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria mestieri.
 */
public void setCat10(boolean value) {
    this.cat10 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria mestieri.
 *
 * @return Il valore booleano che indica lo stato della categoria mestieri.
 */
public boolean getCat10() {
    return this.cat10;
}

/**
 * Metodo setter per la categoria celebrità.
 *
 * @param value Il valore booleano che rappresenta lo stato della categoria celebrità.
 */
public void setCat11(boolean value) {
    this.cat11 = value;
    notifyObservers();
}

/**
 * Metodo getter per la categoria celebrità.
 *
 * @return Il valore booleano che indica lo stato della categoria celebrità.
 */
public boolean getCat11() {
    return this.cat11;
}


   /**
 * Imposta il numero di giocatori.
 *
 * @param value Il numero di giocatori da impostare.
 */
public void setNumPlayers(int value) {
    this.numPlayers = value;
    notifyObservers();
}

/**
 * Ottiene il numero di giocatori.
 *
 * @return Il numero di giocatori.
 */
public int getNumPlayers() {
    return this.numPlayers;
}


      /**
     * Metodo setter per i punteggi dei giocatori.
     *
     * @param punteggi Un array contenente i punteggi dei giocatori.
     */
    public void setPunteggi(int[] punteggi) {
        this.punteggi = punteggi;
        notifyObservers();
    }

    /**
     * Metodo getter per i punteggi dei giocatori.
     *
     * @return Un array contenente i punteggi dei giocatori.
     */
    public int[] getPunteggi() {
        return punteggi;
    }

    /**
     * Metodo setter per le posizioni dei giocatori.
     *
     * @param posizioni Un array contenente le posizioni dei giocatori.
     */
    public void setPosizioni(int[] posizioni) {
        this.posizioni = posizioni;
        notifyObservers();
    }

    /**
     * Metodo getter per le posizioni dei giocatori.
     *
     * @return Un array contenente le posizioni dei giocatori.
     */
    public int[] getPosizioni() {
        return posizioni;
    }

    /**
     * Aggiunge un osservatore alla lista degli osservatori.
     *
     * @param observer L'osservatore da aggiungere.
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Rimuove un osservatore dalla lista degli osservatori.
     *
     * @param observer L'osservatore da rimuovere.
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifica tutti gli osservatori registrati di un cambiamento di stato nel modello.
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}
