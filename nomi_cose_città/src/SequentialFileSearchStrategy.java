
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

// Interfaccia per la strategia di ricerca
interface SearchStrategy {
    boolean search(String word, List<String> files);
}

// Implementazione della strategia di ricerca sequenziale nei file
class SequentialFileSearchStrategy implements SearchStrategy {
    @Override
    public boolean search(String word, List<String> files) {
        for (String filePath : files) {
            if (searchInFile(word, filePath)) {
                return true; 
            }
        }
        return false; // Parola non trovata nei file
    }

    private boolean searchInFile(String word, String filePath) {
        word = word.toLowerCase(); // Converti la parola da cercare in lettere minuscole
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase(); // Converti la riga in lettere minuscole
                if (line.contains(word)) {
                    return true; // Parola trovata nel file
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Parola non trovata nel file
    }
}

