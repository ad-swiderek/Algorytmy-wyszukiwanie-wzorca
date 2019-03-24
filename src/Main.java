import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int alphabetSize = 10; // (angielski alfabet - 26 znakow)
        FileProcessing randomTextSearching = new FileProcessing("random_text.txt", 30); //max alphabet size - 26 (ilosc liter w alfabecie)
        //randomTextSearching.generateText(50000, 80000, alphabetSize); //funkcja generujaca losowy tekst o losowej dlugosci z przedzialu podanego w parametrach i o podanej wielkosci alfabetu
        randomTextSearching.readFromFileToBuffer();

        FileProcessing dnaTextSearching = new FileProcessing("dna.txt", 30);
        dnaTextSearching.readFromFileToBuffer();

        FileProcessing loremIpsumFileSearching = new FileProcessing("lorem_ipsum.txt", 30);
        loremIpsumFileSearching.readFromFileToBuffer();


    }
}
