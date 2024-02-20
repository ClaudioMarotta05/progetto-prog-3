package ADAPTER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Metodo2 {
    public String searchLetter(char startingLetter, String fileName) {
        if (new Random().nextInt(10) < 3) {
            return "";
        } else {
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
                System.err.println("Errore di input/output: " + e.getMessage());
            }
        
            System.out.println("Numero di parole trovate: " + wordsWithSameLetter.size());
        
            if (wordsWithSameLetter.isEmpty()) {
                return ""; 
            }
        
            Random random = new Random();
            int randomIndex = random.nextInt(wordsWithSameLetter.size());
            return wordsWithSameLetter.get(randomIndex);
        }
    }
    
}
