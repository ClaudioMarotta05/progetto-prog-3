package BUILDER;

/**
 * Questa interfaccia definisce un builder che costruisce un oggetto Tabella.
 * @author Marco Michele Pisacane
 * @author Francesco Fossari
 * @author Claudio Marotta 
 * 
 * @version 1.0
 */
public interface Builder {
    /**
     * Imposta il punteggio totale della riga.
     *
     * @param tot Il punteggio totale della riga
     * @return Questo oggetto Builder
     */
    public Builder setTot(int tot);
    
    /**
     * Imposta il campo "nome" della riga.
     *
     * @param nome Il campo "nome" della riga
     * @return Questo oggetto Builder
     */
    public Builder setNome(String nome);
    
    /**
     * Imposta il campo "cosa" della riga.
     *
     * @param cosa Il campo "cosa" della riga
     * @return Questo oggetto Builder
     */
    public Builder setCosa(String cosa);
    
    /**
     * Imposta il campo "città" della riga.
     *
     * @param citta Il campo "città" della riga
     * @return Questo oggetto Builder
     */
    public Builder setCitta(String citta);
    
    /**
     * Imposta il campo "frutta" della riga.
     *
     * @param frutta Il campo "frutta" della riga
     * @return Questo oggetto Builder
     */
    public Builder setFrutta(String frutta);
    
    /**
     * Imposta il campo "verbi" della riga.
     *
     * @param verbi Il campo "verbi" della riga
     * @return Questo oggetto Builder
     */
    public Builder setVerbi(String verbi);
    
    /**
     * Imposta il campo "animali" della riga.
     *
     * @param animali Il campo "animali" della riga
     * @return Questo oggetto Builder
     */
    public Builder setAnimali(String animali);
    
    /**
     * Imposta il campo "piante" della riga.
     *
     * @param piante Il campo "piante" della riga
     * @return Questo oggetto Builder
     */
    public Builder setPiante(String piante);
    
    /**
     * Imposta il campo "cantanti" della riga.
     *
     * @param cantanti Il campo "cantanti" della riga
     * @return Questo oggetto Builder
     */
    public Builder setCantanti(String cantanti);
    
    /**
     * Imposta il campo "nazioni" della riga.
     *
     * @param nazioni Il campo "nazioni" della riga
     * @return Questo oggetto Builder
     */
    public Builder setNazioni(String nazioni);
    
    /**
     * Imposta il campo "mestieri" della riga.
     *
     * @param mestieri Il campo "mestieri" della riga
     * @return Questo oggetto Builder
     */
    public Builder setMestieri(String mestieri);
    
    /**
     * Imposta il campo "celebrità" della riga.
     *
     * @param celebrita Il campo "celebrità" della riga
     * @return Questo oggetto Builder
     */
    public Builder setCelebrita(String celebrita);

    /**
     * Costruisce e restituisce l'oggetto Tabella configurato con le proprietà impostate.
     *
     * @return L'oggetto Tabella configurato
     */
    public Tabella build();
}
