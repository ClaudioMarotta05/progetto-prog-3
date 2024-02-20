package ADAPTER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Metodo1 {
    public boolean searchWord(String word, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nomi_cose_città/src/dizionario/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(word)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Errore di input/output: " + e.getMessage());
        }
        return false;
    }
}
