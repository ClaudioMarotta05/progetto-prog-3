package ADAPTER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Questa classe rappresenta un metodo per la ricerca di parole all'interno di un file
 * basato sulla lettera di inizio specificata.
 */
public class Metodo2 {
    /**
     * Cerca una parola all'interno di un file basata sulla lettera di inizio specificata.
     *
     * @param startingLetter La lettera di inizio per la ricerca delle parole.
     * @param fileName       Il nome del file da cui effettuare la ricerca.
     * @return Una parola casuale che inizia con la lettera specificata, o una stringa vuota se non trovata o in caso di errore.
     */
    public String searchLetter(char startingLetter, String fileName) {
        if (new Random().nextInt(10) < 3) { // Se il numero casuale è inferiore a 3, restituisci una stringa vuota.
            return "";
        } else {
            List<String> wordsWithSameLetter = new ArrayList<>(); // Lista delle parole con la stessa lettera di inizio.
            try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
                String line;
                // Leggi ogni linea nel file e aggiungi le parole con la stessa lettera di inizio alla lista.
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (!line.isEmpty() && line.toLowerCase().charAt(0) == Character.toLowerCase(startingLetter)) {
                        wordsWithSameLetter.add(line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Errore di input/output: " + e.getMessage());
            }
        
            System.out.println("Numero di parole trovate: " + wordsWithSameLetter.size());
        
            if (wordsWithSameLetter.isEmpty()) {
                return ""; // Se non sono state trovate parole, restituisci una stringa vuota.
            }
            // Genera un indice casuale per selezionare una parola casuale dalla lista.
            Random random = new Random();
            int randomIndex = random.nextInt(wordsWithSameLetter.size());
            return wordsWithSameLetter.get(randomIndex); // Restituisci una parola casuale.
        }
    }
    
}
