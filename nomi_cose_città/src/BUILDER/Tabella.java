package BUILDER;

/**
 * Questa classe rappresenta una tabella con vari campi di testo.
 *
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 * 
 */

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

   
    /**
 * Costruttore della classe Tabella.
 *
 * @param tot       Il punteggio totale della riga
 * @param nome      Il campo Nome della riga
 * @param cosa      Il campo "cosa" della riga
 * @param citta     Il campo "citta" della riga
 * @param frutta    Il campo "frutta" della riga
 * @param verbi     Il campo "verbi" della riga
 * @param animali   Il campo "animali" della riga
 * @param piante    Il campo "piante" della riga
 * @param cantanti  Il campo "cantanti" della riga
 * @param nazioni   Il campo "nazioni" della riga
 * @param mestieri  Il campo "mestieri" della riga
 * @param celebrita Il campo "celebrita" della riga
 */
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

   /**
 * Restituisce il punteggio totale della riga.
 *
 * @return Il punteggio totale della riga
 */
public int getTot() {
    return this.tot;
}

/**
 * Restituisce il campo Nome della riga.
 *
 * @return Il campo Nome della riga
 */
public String getNome() {
    return this.nome;
}

/**
 * Restituisce il campo "cosa" della riga.
 *
 * @return Il campo "cosa" della riga
 */
public String getCosa() {
    return this.cosa;
}

/**
 * Restituisce il campo "citta" della riga.
 *
 * @return Il campo "citta" della riga
 */
public String getCitta() {
    return this.citta;
}

/**
 * Restituisce il campo "frutta" della riga.
 *
 * @return Il campo "frutta" della riga
 */
public String getFrutta() {
    return this.frutta;
}

/**
 * Restituisce il campo "verbi" della riga.
 *
 * @return Il campo "verbi" della riga
 */
public String getVerbi() {
    return this.verbi;
}

/**
 * Restituisce il campo "animali" della riga.
 *
 * @return Il campo "animali" della riga
 */
public String getAnimali() {
    return this.animali;
}

/**
 * Restituisce il campo "piante" della riga.
 *
 * @return Il campo "piante" della riga
 */
public String getPiante() {
    return this.piante;
}

/**
 * Restituisce il campo "cantanti" della riga.
 *
 * @return Il campo "cantanti" della riga
 */
public String getCantanti() {
    return this.cantanti;
}

/**
 * Restituisce il campo "nazioni" della riga.
 *
 * @return Il campo "nazioni" della riga
 */
public String getNazioni() {
    return this.nazioni;
}

/**
 * Restituisce il campo "mestieri" della riga.
 *
 * @return Il campo "mestieri" della riga
 */
public String getMestieri() {
    return this.mestieri;
}

/**
 * Restituisce il campo "celebrita" della riga.
 *
 * @return Il campo "celebrita" della riga
 */
public String getCelebrita() {
    return this.celebrita;
}

/**
 * Imposta il punteggio totale della riga.
 *
 * @param tot Il nuovo punteggio totale della riga
 */
public void setTot(int tot) {
    this.tot = tot;
}

/**
 * Imposta il campo Nome della riga.
 *
 * @param nome Il nuovo campo Nome della riga
 */
public void setNome(String nome) {
    this.nome = nome;
}

/**
 * Imposta il campo "cosa" della riga.
 *
 * @param cosa Il nuovo campo "cosa" della riga
 */
public void setCosa(String cosa) {
    this.cosa = cosa;
}

/**
 * Imposta il campo "citta" della riga.
 *
 * @param citta Il nuovo campo "citta" della riga
 */
public void setCitta(String citta) {
    this.citta = citta;
}

/**
 * Imposta il campo "frutta" della riga.
 *
 * @param frutta Il nuovo campo "frutta" della riga
 */
public void setFrutta(String frutta) {
    this.frutta = frutta;
}

/**
 * Imposta il campo "verbi" della riga.
 *
 * @param verbi Il nuovo campo "verbi" della riga
 */
public void setVerbi(String verbi) {
    this.verbi = verbi;
}

/**
 * Imposta il campo "animali" della riga.
 *
 * @param animali Il nuovo campo "animali" della riga
 */
public void setAnimali(String animali) {
    this.animali = animali;
}

/**
 * Imposta il campo "piante" della riga.
 *
 * @param piante Il nuovo campo "piante" della riga
 */
public void setPiante(String piante) {
    this.piante = piante;
}

/**
 * Imposta il campo "cantanti" della riga.
 *
 * @param cantanti Il nuovo campo "cantanti" della riga
 */
public void setCantanti(String cantanti) {
    this.cantanti = cantanti;
}

/**
 * Imposta il campo "nazioni" della riga.
 *
 * @param nazioni Il nuovo campo "nazioni" della riga
 */
public void setNazioni(String nazioni) {
    this.nazioni = nazioni;
}

/**
 * Imposta il campo "mestieri" della riga.
 *
 * @param mestieri Il nuovo campo "mestieri" della riga
 */
public void setMestieri(String mestieri) {
    this.mestieri = mestieri;
}

/**
 * Imposta il campo "celebrita" della riga.
 *
 * @param celebrita Il nuovo campo "celebrita" della riga
 */
public void setCelebrita(String celebrita) {
    this.celebrita = celebrita;
}
}
