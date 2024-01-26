package BUILDER;

import MVC.Tabella;

public class BuilderTabella implements Builder{
    private int tot;
    private String nome;
    private String cosa;
    private String citta;
    private String frutta;


    public BuilderTabella() {
    }

    public Builder setTot(int tot) {
        this.tot = tot;
        return this;
    }

    public Builder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Builder setCosa(String cosa) {
        this.cosa = cosa;
        return this;
    }

    public Builder setCitta(String citta) {
        this.citta = citta;
        return this;
    }

    public Builder setFrutta(String frutta) {
        this.frutta = frutta;
        return this;
    }

    public Tabella build() {
        return new Tabella(tot,nome,cosa,citta,frutta);
    }
}
