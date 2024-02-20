package ADAPTER;

@SuppressWarnings("rawtypes")
public class adapter2 implements SearchInterface {
    private Metodo2 ricerca2;
    
    public adapter2(Metodo2 ricerca2){
        this.ricerca2 = ricerca2;
    }

    @Override
    public String search(String input, String filename) {
        char startingLetter = input.charAt(0); // Estrarre la prima lettera dalla parola
        return ricerca2.searchLetter(startingLetter, filename);
    }
}
