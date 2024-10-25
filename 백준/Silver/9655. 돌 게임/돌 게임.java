import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //돌 개수
        
        if(n % 2 != 0) System.out.println("SK");
        else System.out.println("CY");
    }
}