package STRATEGY;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Definizione di una classe che implementa l'interfaccia SearchStrategy
public class LetterStartSequentialFileSearchStrategy implements SearchStrategy {

    // Metodo per cercare una parola in un file
    @Override
    public boolean searchWord(String word, String fileName) {
        // Utilizza un BufferedReader per leggere il file
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            String line;
            // Legge ogni riga del file
            while ((line = reader.readLine()) != null) {
                // Se trova una corrispondenza della parola nella riga, restituisce true
                if (line.trim().equalsIgnoreCase(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // Gestisce eventuali eccezioni di input/output
            System.err.println("Errore di input/output: " + e.getMessage());
        }
        // Se la parola non viene trovata o si verificano eccezioni, restituisce false
        return false;
    }

    // Metodo per cercare una parola che inizia con una lettera specifica in un file
    @Override
    public String search(char startingLetter, String fileName) {
        // Genera un numero casuale per simulare un comportamento condizionale
        if (new Random().nextInt(10) < 2) {
            // Se il numero generato è minore di 3, restituisce una stringa vuota
            return "";
        } else {
            // Altrimenti, crea una lista per memorizzare le parole che iniziano con la lettera specificata
            List<String> wordsWithSameLetter = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
                String line;
                // Legge ogni riga del file
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    // Se la riga non è vuota e inizia con la stessa lettera (ignorando maiuscole/minuscole),
                    // aggiunge la parola alla lista
                    if (!line.isEmpty() && line.toLowerCase().charAt(0) == Character.toLowerCase(startingLetter)) {
                        wordsWithSameLetter.add(line);
                    }
                }
            } catch (IOException e) {
                // Gestisce eventuali eccezioni di input/output
                System.err.println("Errore di input/output: " + e.getMessage());
            }
        
            // Stampa il numero di parole trovate
            System.out.println("Number of words found: " + wordsWithSameLetter.size());
        
            // Se la lista è vuota, restituisce una stringa vuota
            if (wordsWithSameLetter.isEmpty()) {
                return ""; 
            }
        
            // Altrimenti, genera un indice casuale per estrarre casualmente una parola dalla lista
            Random random = new Random();
            int randomIndex = random.nextInt(wordsWithSameLetter.size());
            // Restituisce la parola corrispondente all'indice casuale
            return wordsWithSameLetter.get(randomIndex);
        }
    }
}
