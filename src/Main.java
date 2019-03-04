public class Main {
    public static void main(String[] args) {

        NaiveSearch ns = new NaiveSearch("abcac", "abcabcacabababababcacba");
        ns.search();

        MPSearch mps = new MPSearch("abcac", "abcabcacabababababcacba");
        mps.search();

        KMPSearch kmps = new KMPSearch("abcac", "abcabcacabababababcacba");
        kmps.search();

        for (int s : ns.getOccurrences()) {
            System.out.println(s);
        }

        for (int p : mps.getOccurrences()) {
            System.out.println(p);
        }

        for (int p : kmps.getOccurrences()) {
            System.out.println(p);
        }
    }
}
