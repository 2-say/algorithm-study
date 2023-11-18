package no_explain.beakjoon17298;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class beakjoon17298{
    void solve(String[] strNum , int n) throws IOException{
        int[] aList = new int[n];
        int[] answer = new int[n];
        for(int i=0; i<n; i++){
            aList[i]= Integer.parseInt(strNum[i]);
        }
        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);
        for(int i=1; i<n;i++){
            while(!myStack.isEmpty() && aList[myStack.peek()] < aList[i]){
                answer[myStack.pop()] = aList[i]; //POP을 해버리기 때문에 한번만 들어감 
            }
            myStack.push(i);
        }
        while(!myStack.empty()){
            answer[myStack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<strNum.length;i++){
            bw.write(answer[i]+" ");
        }
        bw.write("\n");
        bw.flush();
    }
    public static void main(String[] args) throws IOException {
        beakjoon17298 main = new beakjoon17298();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// n 생략
        String[] strNum = br.readLine().split(" ");
        main.solve(strNum,n);
    }
    
}
