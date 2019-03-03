public class Main {
    public static void main(String[] args) {

        //NaiveSearch ns = new NaiveSearch("abcac", "abcabcacabababababcacba");
        //ns.search();
        MPSearch mps = new MPSearch("abcac", "abcabcacabababababcacba");
        mps.search();

       /* for (int s : ns.getOccurrences()) {
            System.out.println(s);
        }*/

        for (int p : mps.getOccurrences()) {
            System.out.println(p);
        }
    }
}
