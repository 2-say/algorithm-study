    package no_explain.beakjoon1940;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class beakjoon1940 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            String[] input_arr = br.readLine().split(" ");
            int count=0;

            for(int i = 0 ; i < n-1 ; i++)
            {
                for(int j = i+1 ; j<n ; j++)
                {
                    if((Integer.parseInt(input_arr[i]) + Integer.parseInt(input_arr[j])) == m ){
                        count ++;
                    }
                }
            }
            System.out.println(count);
            br.close();
        }
    }
