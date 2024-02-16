package MVC;

import java.util.ArrayList;
import java.util.List;

import OBSERVER.Observable;
import OBSERVER.Observer;


// Questa classe rappresenta il modello dell'applicazione.
public class model1 implements Observable {
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
   

    //Costruttore vuoto
    public model1() {
        
    }

// Metodi getter e setter per l'username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println(username);
        notifyObservers();
    }
// Metodi getter e setter per la password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        System.out.println(password);
        notifyObservers();
    }
// Metodi getter e setter per l'email
    public void setMail(String mail){
        this.mail = mail;
        System.out.println("mail " + mail);
        notifyObservers();
    }


    public String getMail() {
        return this.mail;
    }


// Metodi getter e setter per le categorie di parole
    public void setCat1(boolean value) {
        this.cat1 = value;
        System.out.println("bool nome " + cat1);
        notifyObservers();
    }

    public boolean getCat1() {
        return this.cat1;
    }

    public void setCat2(boolean value) {
        this.cat2 = value;
        System.out.println("bool cosa " +cat2);
        notifyObservers();
    }

    public boolean getCat2() {
        return this.cat2;
    }

    public void setCat3(boolean value) {
        this.cat3 = value;
        System.out.println("bool citta " +cat3);
        notifyObservers();
    }

    public boolean getCat3() {
        return this.cat3;
    }

    public void setCat4(boolean value) {
        this.cat4 = value;
        System.out.println("bool frutta " +cat4);
        notifyObservers();
    }

    public boolean getCat4() {
        return this.cat4;
    }

     public void setCat5(boolean value) {
        this.cat5 = value;
        System.out.println("Valore di verbi: " );
    }

    public boolean getCat5() {
        return this.cat5;
    }

    public void setCat6(boolean value) {
        this.cat6 = value;
        System.out.println("Valore di animali: " );
    }


    public boolean getCat6() {
        return this.cat6;
    }

    
    public void setCat7(boolean value) {
        this.cat7 = value;
        System.out.println("Valore di piante: " );
    }

    public boolean getCat7() {
        return this.cat7;
    }
    
    public void setCat8(boolean value) {
        this.cat8 = value;
        System.out.println("Valore di cantanti: " );
    }

    public boolean getCat8() {
        return this.cat8;
    }


    public void setCat9(boolean value) {
        this.cat9 = value;
        System.out.println("Valore di nazioni: " );
    }

    public boolean getCat9() {
        return this.cat9;
    }

    
    public void setCat10(boolean value) {
        this.cat10 = value;
        System.out.println("Valore di mestieri: " );
    }

    public boolean getCat10() {
        return this.cat10;
    }

    
    public void setCat11(boolean value) {
        this.cat11 = value;
        System.out.println("Valore di celebrita: ");
    }

    public boolean getCat11() {
        return this.cat11;
    }

    // Metodi getter e setter per i giocatori

    
    public void setNumPlayers(int value) {
        this.numPlayers = value;
        notifyObservers();
         
     }
 
     public int getNumPlayers() {
         return this.numPlayers;
     }

     public void setPunteggi(int[] punteggi) {
        this.punteggi = punteggi;
        notifyObservers();
         
     }
 
     public int[] getPunteggi() {
         return this.punteggi;
     }

     public void setPosizioni(int[] posizioni) {
        this.posizioni = posizioni;
        notifyObservers();
         
     }
 
     public int[] getPosizioni() {
         return this.posizioni;
     }
    // Implementazione dei metodi dell'interfaccia Observable
     @Override
     public void addObserver(Observer observer) {
         observers.add(observer);
     }
 
     @Override
     public void removeObserver(Observer observer) {
         observers.remove(observer);
     }
 
     @Override
     public void notifyObservers() {
         for (Observer observer : observers) {
             observer.update(this);
         }
     }



}
