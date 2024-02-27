package ADAPTER;
/**
 * Questa classe rappresenta un adattatore che implementa l'interfaccia SearchInterface
 * utilizzando un'istanza di Metodo1 per eseguire la ricerca.
 */
@SuppressWarnings("rawtypes")
public class adapter1 implements SearchInterface {
    private Metodo1 ricerca1;// Riferimento all'oggetto Metodo1 utilizzato per la ricerca
    /**
     * Costruttore della classe adapter1.
     *
     * @param ricerca1 Un'istanza di Metodo1 utilizzata per eseguire la ricerca.
     */
    public adapter1(Metodo1 ricerca1){
        this.ricerca1 = ricerca1;
    }
    /**
     * Esegue la ricerca utilizzando il metodo searchWord di Metodo1.
     *
     * @param input La parola da cercare.
     * @param filename Il nome del file in cui cercare la parola.
     * @return true se la parola viene trovata nel file, altrimenti false.
     */
    @Override
    public Boolean search(String input, String filename) {
        return ricerca1.searchWord(input, filename);
    }
}
