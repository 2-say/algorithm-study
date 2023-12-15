import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class IndexedValue implements Comparable<IndexedValue> {
    int value;
    int index;
    public IndexedValue(int index,int value) {
        this.value = value;
        this.index = index;
    }
    @Override
    public int compareTo(IndexedValue other) {
        return Integer.compare(this.value, other.value);
    }
}
public class Baekjoon1377 {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<IndexedValue> a = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            a.add(new IndexedValue(i,Integer.parseInt(br.readLine())));
        }
        solve(a,n);
    }
    static void solve(List<IndexedValue> a, int n){ 
        a.sort(Comparator.naturalOrder());
        int max = Integer.MIN_VALUE;
        for(int i=0 ; i < n; i++){
            if(max < (a.get(i).index-i)){
                max = a.get(i).index-i;
            }
        }
        System.out.println(max+1);
    }
}
