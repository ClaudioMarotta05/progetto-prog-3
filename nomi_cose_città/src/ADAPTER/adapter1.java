package ADAPTER;

@SuppressWarnings("rawtypes")
public class adapter1 implements SearchInterface {
    private Metodo1 ricerca1;
    
    public adapter1(Metodo1 ricerca1){
        this.ricerca1 = ricerca1;
    }

    @Override
    public Boolean search(String input, String filename) {
        return ricerca1.searchWord(input, filename);
    }
}
