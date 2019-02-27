public class NaiveSearch extends StringSearch {

    public NaiveSearch(String pattern, String text) {
        super(pattern, text);
    }

    @Override
    public void search() {
        for (int i = 0; i < text.length() - pattern.length(); i++) {
            if (findAt(i)) {
                occurrences.add(i);
            }
        }
    }
}
