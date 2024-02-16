package STRATEGY;

// Definisce un'interfaccia chiamata SearchStrategy
public interface SearchStrategy {

    // Metodo per cercare una parola esatta in un file
    boolean searchWord(String word, String fileName);

    // Metodo per cercare una parola che inizia con una lettera specifica in un file
    String search(char startingLetter, String fileName);
}
