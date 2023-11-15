import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Interfaccia per la strategia di ricerca
interface SearchStrategy {
    String search(char startingLetter, String filePath);
}

// Implementazione della strategia di ricerca casuale nei file
class RandomFileSearchStrategy implements SearchStrategy {
    @Override
    public String search(char startingLetter, String filePath) {
        List<String> matchingWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Rimuovi spazi
                if (!line.isEmpty() && Character.toLowerCase(line.charAt(0)) == Character.toLowerCase(startingLetter)) {
                    matchingWords.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!matchingWords.isEmpty()) {
            // Se ci sono parole corrispondenti, restituisci una casuale
            Random random = new Random();
            return matchingWords.get(random.nextInt(matchingWords.size()));
        } else {
            return null; // Nessuna parola trovata nel file
        }
    }
}

public class WordSearchGame {
    public static void main(String[] args) {
        // Crea strategia di ricerca casuale
        SearchStrategy fileSearchStrategy = new RandomFileSearchStrategy();

        // Richiedi la lettera e il file da cercare all'utente
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la lettera iniziale: ");
        char startingLetter = scanner.next().charAt(0);
        System.out.print("Inserisci il nome del file da cercare: ");
        String fileToSearch = scanner.next().toLowerCase();
        scanner.close();

        // Aggiungi l'estensione .txt se non è già presente
        if (!fileToSearch.endsWith(".txt")) {
            fileToSearch += ".txt";
        }

        // Percorso della cartella "dizionario"
        String basePath = "nomi_cose_città/src/dizionario/";
        
        // Percorso completo del file da cercare
        String fullFilePath = Paths.get(basePath, fileToSearch).toString();

        // Esempio di utilizzo:
        String foundWord = fileSearchStrategy.search(startingLetter, fullFilePath);

        if (foundWord != null) {
            System.out.println("Parola trovata: " + foundWord);
        } else {
            System.out.println("Nessuna parola trovata con la lettera " + startingLetter + " nel file " + fileToSearch);
        }
    }
}