package ADAPTER;
/**
 * L'interfaccia {@code SearchInterface} definisce il contratto per eseguire operazioni di ricerca.
 *
 * @param <T> Il tipo generico di risultato della ricerca.
 */
public interface SearchInterface<T> {
    /**
     * Esegue un'operazione di ricerca utilizzando l'input fornito e il nome del file specificato.
     *
     * @param input    L'input per l'operazione di ricerca(lettera o parola).
     * @param filename Il nome del file su cui eseguire la ricerca.
     * @return Il risultato della ricerca, di tipo T.
     */
    T search(String input, String filename);
    
}
