package MVC;

public class model2 {
    private boolean cat1;
    private boolean cat2;
    private boolean cat3;
    private boolean cat4;
    private String username;

    public model2() {
        
    }

    public void setCat1(boolean value) {
        this.cat1 = value;
        System.out.println("bool nome " + cat1);
    }

    public boolean getCat1() {
        return this.cat1;
    }

    public void setCat2(boolean value) {
        this.cat2 = value;
        System.out.println("bool cosa " +cat2);
    }

    public boolean getCat2() {
        return this.cat2;
    }

    public void setCat3(boolean value) {
        this.cat3 = value;
        System.out.println("bool citta " +cat3);
    }

    public boolean getCat3() {
        return this.cat3;
    }

    public void setCat4(boolean value) {
        this.cat4 = value;
        System.out.println("bool frutta " +cat4);
    }

    public boolean getCat4() {
        return this.cat4;
    }

    public void setPartecipante(String username) {
        this.username = username;
        System.out.println("nome utente  " +username);
    }

    public String getPartecipante() {
        return this.username;
    }
}