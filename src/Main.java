public class Main {
    public static void main(String[] args) {

        NaiveSearch ns = new NaiveSearch("kot", "ala ma kota, kot nie ma ogona, koty zwykle maja ogon.");
        ns.search();
        for (int s : ns.getOccurrences()) {
            System.out.println(s);
        }
    }
}
