import java.util.ArrayList;

public class MPSearch extends StringSearch {
    private ArrayList<Integer> pi = new ArrayList<>();

    public MPSearch(String pattern, String text) {
        super(pattern, text);
    }

    private void fillPi() {
        int i = 0, j = -1;
        int m = pattern.length();
        pi.add(-1);
        while (i < m) {
            while (j > -1 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi.get(j);
            }
            i++;
            j++;
            pi.add(i, j);
        }
    }

    @Override
    public void search() {
        fillPi();
        int i = 0, j = 0;
        int n = text.length();
        int m = pattern.length();
        while (i < n) {
            while (j >= 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi.get(j);
            }
            i++;
            j++;
            if (j == m) {
                occurrences.add(i - j);
                j = pi.get(m);
            }
        }
    }
}
