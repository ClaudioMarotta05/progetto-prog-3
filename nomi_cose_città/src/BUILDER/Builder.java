package BUILDER;

public interface Builder {
    public Builder setTot(int tot);
    public Builder setNome(String nome);
    public Builder setCosa(String cosa);
    public Builder setCitta(String citta);
    public Builder setFrutta(String frutta);
    

    public Tabella build();
}