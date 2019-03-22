import java.io.*;
import java.util.Random;

public class FileProcessing {
    private String text2048;
    private String pattern;
    private int textLength;
    private String fileName;
    private int patternLenght;


    public FileProcessing(String fileName, int patternLenght) throws IOException {
        this.fileName = fileName;
        this.patternLenght = patternLenght;
        countTextLength();
        generatePattern(patternLenght);
    }

    public void generateText(int minLetters, int maxLetters, int alphabetSize) throws IOException {
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
        char[] buffer = new char[2048];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        BufferedWriter bw = new BufferedWriter(new FileWriter("results.txt", true));
        long startTime;
        long stopTime;
        String toFileWriting;
        SearchFactory searchFactory = new SearchFactory();
        StringSearch stringSearch;

        bw.write(fileName + "\tDługość wzorca:\t" + patternLenght + "\n");
        bw.write("Sunday:\tMP:\tBM:\n");
        while (br.read(buffer, 0, 2048) > 0) {
            text2048 = new String(buffer);

            stringSearch = searchFactory.makeSearching("S", pattern, text2048); //algorytm Sundaya
            startTime = System.nanoTime();
            stringSearch.search();
            stopTime = System.nanoTime();
            System.out.println("Sunday: " + (stopTime - startTime));
            toFileWriting = Long.toString(stopTime - startTime);
            bw.write(toFileWriting + "\t");

            stringSearch = searchFactory.makeSearching("MP", pattern, text2048); //algorytm Sundaya
            startTime = System.nanoTime();
            stringSearch.search();
            stopTime = System.nanoTime();
            System.out.println("MP: " + (stopTime - startTime));
            toFileWriting = Long.toString(stopTime - startTime);
            bw.write(toFileWriting + "\t");

            stringSearch = searchFactory.makeSearching("BM", pattern, text2048); //algorytm Sundaya
            startTime = System.nanoTime();
            stringSearch.search();
            stopTime = System.nanoTime();
            System.out.println("BM: " + (stopTime - startTime));
            toFileWriting = Long.toString(stopTime - startTime);
            bw.write(toFileWriting + "\t");
            bw.write("\n");
            System.out.println();


            //System.out.println(text2048);
            buffer = new char[2048];
        }
        bw.write("\n");
        br.close();
        bw.close();
    }

    public void countTextLength() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        textLength = br.readLine().length();
        //System.out.println(textLength);
        br.close();
    }

    public void generatePattern(int length) throws IOException {
        Random rand = new Random();
        int startIndex = rand.nextInt(((textLength - length)) + 1);
        char[] buffer = new char[length];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        br.skip(startIndex);
        br.read(buffer, 0, length);
        pattern = new String(buffer);
        br.close();
        //System.out.println("Wzorzec: " + pattern);
    }

}
