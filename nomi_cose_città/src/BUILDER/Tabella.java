package BUILDER;

// Questa classe rappresenta una tabella con vari campi di testo.
public class Tabella {
    private int tot; // Punteggio totale della riga
    private String nome; // Campo Nome della riga
    private String cosa; // Campo "cosa" della riga
    private String citta; // Campo "citta" della riga
    private String frutta; // Campo "frutta" della riga
    private String verbi; // Campo "verbi" della riga
    private String animali; // Campo "animali" della riga
    private String piante; // Campo "piante" della riga
    private String cantanti; // Campo "cantanti" della riga
    private String nazioni; // Campo "nazioni" della riga
    private String mestieri; // Campo "mestieri" della riga
    private String celebrita; // Campo "celebrita" della riga

    // Costruttore per inizializzare la tabella con i valori dei campi.
    public Tabella(int tot, String nome, String cosa, String citta, String frutta, String verbi, String animali, String piante, String cantanti, String nazioni, String mestieri, String celebrita) {
        this.tot = tot;
        this.nome = nome;
        this.cosa = cosa;
        this.citta = citta;
        this.frutta = frutta;
        this.verbi = verbi;
        this.animali = animali;
        this.piante = piante;
        this.cantanti = cantanti;
        this.nazioni = nazioni;
        this.mestieri = mestieri;
        this.celebrita = celebrita;
    }

    // Metodi getter per ottenere i valori dei campi.
    public int getTot() {
        return this.tot;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCosa() {
        return this.cosa;
    }

    public String getCitta() {
        return this.citta;
    }

    public String getFrutta() {
        return this.frutta;
    }

    public String getVerbi() {
        return this.verbi;
    }

    public String getAnimali() {
        return this.animali;
    }

    public String getPiante() {
        return this.piante;
    }

    public String getCantanti() {
        return this.cantanti;
    }

    public String getNazioni() {
        return this.nazioni;
    }

    public String getMestieri() {
        return this.mestieri;
    }

    public String getCelebrita() {
        return this.celebrita;
    }

    // Metodi setter per impostare i valori dei campi.
    public void setTot(int tot) {
        this.tot = tot;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCosa(String cosa) {
        this.cosa = cosa;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setFrutta(String frutta) {
        this.frutta = frutta;
    }
    
    public void setVerbi(String verbi) {
        this.verbi = verbi;
    }
    
    public void setAnimali(String animali) {
        this.animali = animali;
    }

    public void setPiante(String piante) {
        this.piante = piante;
    }

    public void setCantanti(String cantanti) {
        this.cantanti = cantanti;
    }

    public void setNazioni(String nazioni) {
        this.nazioni = nazioni;
    }

    public void setMestieri(String mestieri) {
        this.mestieri = mestieri;
    }

    public void setCelebrita(String celebrita) {
        this.celebrita = celebrita;
    }
}
