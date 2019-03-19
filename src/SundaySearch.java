public class SundaySearch extends StringSearch {

    private int[] occ = new int[256];

    public SundaySearch(String pattern, String text) {
        super(pattern, text);
        sundayInitocc();
    }

    public void sundayInitocc() {
        for (int i = 0; i < 256; i++) {
            occ[i] = pattern.length() + 1;
        }

        for (int i = 0; i < pattern.length(); i++) {
            occ[pattern.charAt(i)] = pattern.length() - i;
        }
    }

    @Override
    public void search() {
        int i = 0;
        int n = text.length();
        int m = pattern.length();

        while (i <= n - m) {
            if (findAt(i)) {
                occurrences.add(i);
            }

            if (i + m >= n) break;
            i += occ[text.charAt(i + m)];
        }
    }
}
