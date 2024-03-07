import java.io.*;

public class Baekjoon9252 {

    static char[] s1;
    static char[] s2;

    public static void init() throws IOException {
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();
    }
    public static String solve(int i, int j) {
        if (i == s1.length || j == s2.length)
            return "";
        if (s1[i] == s2[j])
            return s1[i] + solve(i + 1, j + 1);
        else {
            String tmp1 = solve(i + 1, j);
            String tmp2 = solve(i, j + 1);
            return tmp1.length() > tmp2.length() ? tmp1 : tmp2;
        }
    }

    public static void solve() throws IOException {
        String lcs = solve(0, 0);
        bw.write(lcs.length() + "\n" + lcs);
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    // I/O
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        init();
        solve();
        close();
    }
}