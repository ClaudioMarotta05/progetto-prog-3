import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Interfaccia per la strategia di ricerca
interface SearchStrategy {
    String search(char startingLetter, String fileName);
    boolean exists(String word, String fileName);
}

// Implementazione della strategia di ricerca sequenziale basata sulla lettera iniziale
class LetterStartSequentialFileSearchStrategy implements SearchStrategy {
    @Override
    public String search(char startingLetter, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase();
                if (!line.isEmpty() && line.charAt(0) == Character.toLowerCase(startingLetter)) {
                    return line;  // Restituisci la parola trovata
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;  // Nessuna parola trovata nel file
    }

    @Override
    public boolean exists(String word, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase();
                if (line.equals(word.toLowerCase())) {
                    return true;  // La parola esiste nel file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;  // La parola non esiste nel file
    }
}

// Implementazione della strategia di ricerca casuale nel file
class RandomFileSearchStrategy implements SearchStrategy {
    @Override
    public String search(char startingLetter, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            List<String> matchingWords = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase();
                if (!line.isEmpty() && line.charAt(0) == Character.toLowerCase(startingLetter)) {
                    matchingWords.add(line);
                }
            }

            if (!matchingWords.isEmpty()) {
                // Restituisci una parola casuale tra quelle trovate
                Random random = new Random();
                return matchingWords.get(random.nextInt(matchingWords.size()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;  // Nessuna parola trovata nel file
    }

    @Override
    public boolean exists(String word, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim().toLowerCase();
                if (line.equals(word.toLowerCase())) {
                    return true;  // La parola esiste nel file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;  // La parola non esiste nel file
    }
}

// Classe che utilizza il design pattern strategy
public class WordSearchGame {
    public static void main(String[] args) {
        // Richiedi la lettera e il file da cercare all'utente
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la lettera iniziale: ");
        char startingLetter = scanner.next().charAt(0);
        System.out.print("Inserisci il nome del file da cercare (es. nomi.txt): ");
        String fileName = scanner.next();
        scanner.close();

        // Aggiungi l'estensione .txt se non è già presente
        if (!fileName.endsWith(".txt")) {
            fileName+= ".txt";
        }


        // Utilizza la strategia di ricerca basata sulla lettera iniziale
        SearchStrategy letterStartSearchStrategy = new LetterStartSequentialFileSearchStrategy();
        String foundWordLetterStart = letterStartSearchStrategy.search(startingLetter, fileName);
        if (foundWordLetterStart != null) {
            System.out.println("Parola trovata (lettera iniziale): " + foundWordLetterStart);
            boolean exists = letterStartSearchStrategy.exists(foundWordLetterStart, fileName);
            System.out.println("La parola esiste nel file: " + exists);
        } else {
            System.out.println("Nessuna parola trovata con la lettera " + startingLetter + " nel file " + fileName);
        }

        // Utilizza la strategia di ricerca casuale
        SearchStrategy randomFileSearchStrategy = new RandomFileSearchStrategy();
        String foundWordRandom = randomFileSearchStrategy.search(startingLetter, fileName);
        if (foundWordRandom != null) {
            System.out.println("Parola trovata (casuale): " + foundWordRandom);
            boolean exists = randomFileSearchStrategy.exists(foundWordRandom, fileName);
            System.out.println("La parola esiste nel file: " + exists);
        } else {
            System.out.println("Nessuna parola trovata (casuale) nel file " + fileName);
        }
    }
}
