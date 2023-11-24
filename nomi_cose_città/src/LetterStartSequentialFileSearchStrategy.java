
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Interfaccia per la strategia di ricerca
interface SearchStrategy {
    boolean searchWord(String word, String fileName);
    String search(char startingLetter, String fileName);
}


// Implementazione della strategia di ricerca sequenziale basata sulla lettera iniziale
class LetterStartSequentialFileSearchStrategy implements SearchStrategy {
    @Override
    public boolean searchWord(String word, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String search(char startingLetter, String fileName) {
        List<String> wordsWithSameLetter = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && line.toLowerCase().charAt(0) == Character.toLowerCase(startingLetter)) {
                    wordsWithSameLetter.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        String randomWord = wordsWithSameLetter.get(random.nextInt(wordsWithSameLetter.size()));
        return randomWord;
    }
}

