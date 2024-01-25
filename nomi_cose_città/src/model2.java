public class model2 {
    private boolean nome;
    private boolean cose;
    private boolean citta;
    private boolean frutta;

    public void setNome(boolean nome) {
        this.nome = nome;
        //setChanged();
        //notifyObservers();
    }

    public void setCose(boolean cose) {
        this.cose = cose;
        //setChanged();
        //notifyObservers();
    }

    public void setCitta(boolean citta) {
        this.citta = citta;
        //setChanged();
        //notifyObservers();
    }

    public void setFrutta(boolean frutta) {
        this.frutta = frutta;
        //setChanged();
        //notifyObservers();
    }

    public boolean getNome() {
        return nome;
    }

    public boolean getCose() {
        return cose;
    }

    public boolean getCitta() {
        return citta;
    }

    public boolean getFrutta() {
        return frutta;
    }
}
