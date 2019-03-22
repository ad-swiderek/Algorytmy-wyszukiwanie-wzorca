import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int alphabetSize = 2; // (angielski alfabet - 26 znakow)
        FileProcessing randomTextSearching = new FileProcessing("random_text.txt", 10); //max alphabet size - 26 (ilosc liter w alfabecie)
        //randomTextSearching.generateText(10000, 20000, alphabetSize); //funkcja generujaca losowy tekst o losowej dlugosci z przedzialu podanego w parametrach i o podanej wielkosci alfabetu
        randomTextSearching.readFromFileToBuffer();

        FileProcessing dnaTextSearching = new FileProcessing("dna.txt", 30);
        dnaTextSearching.readFromFileToBuffer();

        FileProcessing loremIpsumFileSearching = new FileProcessing("lorem_ipsum.txt", 20);
        loremIpsumFileSearching.readFromFileToBuffer();


    }
}
