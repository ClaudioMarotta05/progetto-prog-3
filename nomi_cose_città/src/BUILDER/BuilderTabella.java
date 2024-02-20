package BUILDER;

/**
 * Questa classe implementa l'interfaccia Builder per costruire oggetti Tabella.
 * 
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 * 
 */
public class BuilderTabella implements Builder {
    private int tot;        // Punteggio totale della riga
    private String nome;    // Campo Nome della riga
    private String cosa;    // Campo "cosa" della riga
    private String citta;   // Campo "citta" della riga
    private String frutta;  // Campo "frutta" della riga
    private String verbi;   // Campo "verbi" della riga
    private String animali; // Campo "animali" della riga
    private String piante;  // Campo "piante" della riga
    private String cantanti;// Campo "cantanti" della riga
    private String nazioni; // Campo "nazioni" della riga
    private String mestieri;// Campo "mestieri" della riga
    private String celebrita;// Campo "celebrita" della riga

    /**
     * Costruttore vuoto per BuilderTabella.
     */
    public BuilderTabella() {
    }

    /**
     * Imposta il punteggio totale della riga.
     *
     * @param tot Il punteggio totale della riga
     * @return Questo oggetto Builder
     */
    public Builder setTot(int tot) {
        this.tot = tot;
        return this;
    }

    /**
     * Imposta il nome della riga.
     *
     * @param nome Il nome della riga
     * @return Questo oggetto Builder
     */
    public Builder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Imposta il campo "cosa" della riga.
     *
     * @param cosa Il campo "cosa" della riga
     * @return Questo oggetto Builder
     */
    public Builder setCosa(String cosa) {
        this.cosa = cosa;
        return this;
    }

    /**
     * Imposta il campo "citta" della riga.
     *
     * @param citta Il campo "citta" della riga
     * @return Questo oggetto Builder
     */
    public Builder setCitta(String citta) {
        this.citta = citta;
        return this;
    }

    /**
     * Imposta il campo "frutta" della riga.
     *
     * @param frutta Il campo "frutta" della riga
     * @return Questo oggetto Builder
     */
    public Builder setFrutta(String frutta) {
        this.frutta = frutta;
        return this;
    }

    /**
     * Imposta il campo "verbi" della riga.
     *
     * @param verbi Il campo "verbi" della riga
     * @return Questo oggetto Builder
     */
    public Builder setVerbi(String verbi) {
        this.verbi = verbi;
        return this;
    }

    /**
     * Imposta il campo "animali" della riga.
     *
     * @param animali Il campo "animali" della riga
     * @return Questo oggetto Builder
     */
    public Builder setAnimali(String animali) {
        this.animali = animali;
        return this;
    }

    /**
     * Imposta il campo "piante" della riga.
     *
     * @param piante Il campo "piante" della riga
     * @return Questo oggetto Builder
     */
    public Builder setPiante(String piante) {
        this.piante = piante;
        return this;
    }

    /**
     * Imposta il campo "cantanti" della riga.
     *
     * @param cantanti Il campo "cantanti" della riga
     * @return Questo oggetto Builder
     */
    public Builder setCantanti(String cantanti) {
        this.cantanti = cantanti;
        return this;
    }

    /**
     * Imposta il campo "nazioni" della riga.
     *
     * @param nazioni Il campo "nazioni" della riga
     * @return Questo oggetto Builder
     */
    public Builder setNazioni(String nazioni) {
        this.nazioni = nazioni;
        return this;
    }

    /**
     * Imposta il campo "mestieri" della riga.
     *
     * @param mestieri Il campo "mestieri" della riga
     * @return Questo oggetto Builder
     */
    public Builder setMestieri(String mestieri) {
        this.mestieri = mestieri;
        return this;
    }

    /**
     * Imposta il campo "celebrita" della riga.
     *
     * @param celebrita Il campo "celebrita" della riga
     * @return Questo oggetto Builder
     */
    public Builder setCelebrita(String celebrita) {
        this.celebrita = celebrita;
        return this;
    }

    /**
     * Costruisce e restituisce l'oggetto Tabella configurato con le proprietà impostate.
     *
     * @return L'oggetto Tabella configurato
     */
    public Tabella build() {
        return new Tabella(tot, nome, cosa, citta, frutta, verbi, animali, piante, cantanti, nazioni, mestieri, celebrita);
    }
}
