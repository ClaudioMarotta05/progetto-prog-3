package ADAPTER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Questa classe rappresenta un metodo per la ricerca di una parola all'interno di un file.
 */
public class Metodo1 {

    /**
     * Ricerca una parola all'interno di un file.
     *
     * @param word     La parola da cercare.
     * @param fileName Il nome del file in cui cercare la parola.
     * @return true se la parola viene trovata nel file, altrimenti false.
     */
    public boolean searchWord(String word, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            String line;
            // Leggi ogni linea nel file e verifica se contiene la parola cercata.
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(word)) {
                    return true; // Se la parola viene trovata, restituisci true.
                }
            }
        } catch (IOException e) {
            System.err.println("Errore di input/output: " + e.getMessage());
        }
        return false; // Se la parola non viene trovata o si verifica un errore, restituisci false.
    }
}
