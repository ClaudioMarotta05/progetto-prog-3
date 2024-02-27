package ADAPTER;
/**
 * Questa classe rappresenta un adattatore che implementa l'interfaccia SearchInterface
 * utilizzando un'istanza di Metodo2 per eseguire la ricerca.
 */
@SuppressWarnings("rawtypes")
public class adapter2 implements SearchInterface {
    private Metodo2 ricerca2; // Riferimento all'oggetto Metodo2 utilizzato per la ricerca

    /**
     * Costruttore della classe adapter2.
     *
     * @param ricerca2 Un'istanza di Metodo2 utilizzata per eseguire la ricerca.
     */
    public adapter2(Metodo2 ricerca2){
        this.ricerca2 = ricerca2;
    }

    /**
     * Esegue la ricerca utilizzando il metodo searchLetter di Metodo2.
     *
     * @param input    L'input per l'operazione di ricerca.
     * @param filename Il nome del file su cui eseguire la ricerca.
     * @return Una parola casuale che inizia con la prima lettera dell'input, o una stringa vuota se non trovata o in caso di errore.
     */

    @Override
    public String search(String input, String filename) {
        char startingLetter = input.charAt(0); // Estrae la prima lettera dalla parola
        return ricerca2.searchLetter(startingLetter, filename);
    }
}
