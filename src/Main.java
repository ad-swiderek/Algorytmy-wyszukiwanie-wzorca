public class Main {
    public static void main(String[] args) {

        NaiveSearch ns = new NaiveSearch("abcac", "abcabcacabababababcacba");
        ns.search();

        SundaySearch ss = new SundaySearch("abcac", "abcabcacabababababcacba");
        ss.search();

        MPSearch mps = new MPSearch("abcac", "abcabcacabababababcacba");
        mps.search();

        KMPSearch kmps = new KMPSearch("abcac", "abcabcacabababababcacba");
        kmps.search();

        System.out.println("Naive:");
        for (int s : ns.getOccurrences()) {
            System.out.println(s);
        }

        System.out.println("MP:");
        for (int s : mps.getOccurrences()) {
            System.out.println(s);
        }

        System.out.println("KMP:");
        for (int s : kmps.getOccurrences()) {
            System.out.println(s);
        }

        System.out.println("Sunday:");
        for (int s: ss.getOccurrences()){
            System.out.println(s);
        }
        System.out.println();

        //BMSearch bms = new BMSearch("ababcababaaba", "abababbbbaababcababaabababac");
        BMSearch bms = new BMSearch("abcac", "abcabcacabababababcacba");

        bms.init1();
        bms.init2();
        bms.printArrays();
        bms.search();

        System.out.println("BM:");
        for (int s: bms.getOccurrences()){
            System.out.println(s);
        }
    }
}
