package BUILDER;

// Questa interfaccia definisce un builder che costruisce un oggetto Tabella.
public interface Builder {
    // Imposta il punteggio totale
    public Builder setTot(int tot);
    
    // Imposta il campo "nome" della riga.
    public Builder setNome(String nome);
    
    // Imposta il campo "cosa" della riga.
    public Builder setCosa(String cosa);
    
    // Imposta il campo "città" della riga.
    public Builder setCitta(String citta);
    
    // Imposta il campo "frutta" della riga.
    public Builder setFrutta(String frutta);
    
    // Imposta il campo "verbi" della riga.
    public Builder setVerbi(String verbi);
    
    // Imposta il campo "animali" della riga.
    public Builder setAnimali(String animali);
    
    // Imposta il campo "piante" della riga.
    public Builder setPiante(String piante);
    
    // Imposta il campo "cantanti" della riga.
    public Builder setCantanti(String cantanti);
    
    // Imposta il campo "nazioni" della riga.
    public Builder setNazioni(String nazioni);
    
    // Imposta il campo "mestieri" della riga.
    public Builder setMestieri(String mestieri);
    
    // Imposta il campo "celebrità" della riga.
    public Builder setCelebrita(String celebrita);

    // Costruisce e restituisce l'oggetto Tabella configurato con le proprietà impostate.
    public Tabella build();
}
