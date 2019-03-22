public class SearchFactory {
    public StringSearch makeSearching(String searchName, String pattern, String text) {
        StringSearch newSearching = null;
        if (searchName.equals("N")) {
            return new NaiveSearch(pattern, text);
        } else if (searchName.equals("S")) {
            return new SundaySearch(pattern, text);
        } else if (searchName.equals("MP")) {
            return new MPSearch(pattern, text);
        } else if (searchName.equals("KMP")) {
            return new KMPSearch(pattern, text);
        } else if (searchName.equals("BM")) {
            return new BMSearch(pattern, text);
        } else {
            return null;
        }

    }
}
