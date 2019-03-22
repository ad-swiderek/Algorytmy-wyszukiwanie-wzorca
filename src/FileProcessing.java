import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileProcessing {
    public void saveRandomString() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("random_text.txt"));
        Random rand = new Random();
        int minLetters = 10000;
        int maxLetters = 20000;
        int alphabetSize = 2; //ilosc liter - max 26
        int numberOfLetters = minLetters + rand.nextInt((maxLetters - minLetters) + 1);
        char c;

        for (int i = 0; i <= numberOfLetters; i++) {
            c = (char) (rand.nextInt(alphabetSize) + 'a');
            pw.print(c);
        }
        pw.close();
    }
}
