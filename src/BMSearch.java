public class BMSearch extends StringSearch {
    private int[] f;
    private int[] s;
    private int[] occ = new int[256];

    public BMSearch(String pattern, String text) {
        super(pattern, text);
        BMInitocc();
        init0();
        init1();
        init2();
    }

    public void init0() {
        int m = pattern.length();
        f = new int[m + 1];
        s = new int[m + 1];
        f[m] = m + 1;
        for (int i = 0; i <= m; i++) {
            s[i] = 0;
        }
    }

    public void init1() {
        //init0();
        int m = pattern.length();
        int i = m;
        int j = m + 1;
        while (i > 0) {
            while (j <= m && pattern.charAt(i - 1) != pattern.charAt(j - 1)) {
                if (s[j] == 0) {
                    s[j] = j - i;
                }
                j = f[j];
            }
            i--;
            j--;
            f[i] = j;
        }
    }

    public void init2() {
        int m = pattern.length();
        int i, j;
        j = f[0];
        for (i = 0; i <= m; i++) {
            if (s[i] == 0) {
                s[i] = j;
            }
            if (i == j) {
                j = f[j];
            }
        }

    }

    void printArrays() {
        for (int i = 0; i <= pattern.length(); i++) {
            System.out.print(f[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <= pattern.length(); i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }

    public void BMInitocc() {
        for (int i = 0; i < 256; i++) {
            occ[i] = pattern.length() + 1;
        }

        for (int i = 0; i < pattern.length(); i++) {
            occ[pattern.charAt(i)] = pattern.length() - i;
        }
    }

    @Override
    public void search() {
        int i = 0, j = 0;
        int n = text.length();
        int m = pattern.length();
        while (i <= n - m) {
            j = m - 1;
            while (j >= 0 && text.charAt(i + j) == pattern.charAt(j))
                j--;
            if (j < 0) {
                occurrences.add(i);
                i += s[0];
            } else {
                i += Math.max(s[j + 1], j - occ[text.charAt(i + j)]);
            }

        }
    }
}
