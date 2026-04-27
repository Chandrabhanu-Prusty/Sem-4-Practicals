public class Exp10_RabinKarp {
    static final int D = 256, Q = 101;

    public static void rabinKarp(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        int h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * D) % Q;
        }

        int pHash = 0, tHash = 0;
        for (int i = 0; i < m; i++) {
            pHash = (D * pHash + pattern.charAt(i)) % Q;
            tHash = (D * tHash + text.charAt(i)) % Q;
        }

        for (int i = 0; i <= n - m; i++) {
            if (pHash == tHash && matches(text, pattern, i)) {
                System.out.println("Pattern found at index: " + i);
            }

            if (i < n - m) {
                tHash = (D * (tHash - text.charAt(i) * h % Q + Q) + text.charAt(i + m)) % Q;
            }
        }
    }

    static boolean matches(String text, String pattern, int start) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        rabinKarp("AABAACAADAABAABA", "AABA");
    }
}
