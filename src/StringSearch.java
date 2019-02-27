import java.util.ArrayList;

public abstract class StringSearch implements ISearch {
    protected String text;
    protected String pattern;
    protected ArrayList<Integer> occurrences = new ArrayList<>();

    public StringSearch(String pattern, String text) {
        this.pattern = pattern;
        this.text = text;
    }

    public ArrayList<Integer> getOccurrences() {
        return occurrences;
    }

    public boolean findAt(int i) {
        for (int j = 0; j < pattern.length(); j++) {
            if (text.charAt(i + j) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public abstract void search();

}
