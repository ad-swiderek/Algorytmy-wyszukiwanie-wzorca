import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class FileProcessing {
    private String text;
    private String pattern;
    private int textLength;
    private String fileName;
    private int patternLenght;
    private int alphabetSize;

    public FileProcessing(String fileName, int patternLenght, int alphabetSize) throws IOException {
        this.fileName = fileName;
        this.patternLenght = patternLenght;
        this.alphabetSize = alphabetSize;
        countTextLength();
    }

    public void generateText(int minLetters, int maxLetters) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("random_text.txt"));
        Random rand = new Random();

        int numberOfLetters = minLetters + rand.nextInt((maxLetters - minLetters) + 1);
        char c;

        for (int i = 0; i <= numberOfLetters; i++) {
            c = (char) (rand.nextInt(alphabetSize) + 'a');
            pw.print(c);
        }
        pw.close();
    }

    public void readFromFileToBuffer() throws IOException {
        //StringBuilder buffer = new StringBuilder(2048);
        char[] buffer = new char[2048];
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        while (br.read(buffer, 0, 2048) > 0) {
            //br.read(buffer, 0, 2048);
            /*for (int i = 0; i < buffer.length; i++) {
                System.out.print(buffer[i]);
            }*/
            text = new String(buffer);
            System.out.println(text);
            buffer = new char[2048];
        }
        br.close();
    }

    public void countTextLength() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        textLength = br.readLine().length();
        //System.out.println(textLength);
        br.close();
    }

    public void generatePattern(int length) throws IOException {
        Random rand = new Random();
        int startIndex = rand.nextInt(((textLength-length)) + 1);
        char [] buffer = new char[length];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.skip(startIndex);
        br.read(buffer, 0, length);
        pattern = new String(buffer);
        br.close();
        System.out.println("Wzorzec: " + pattern);
    }
}
