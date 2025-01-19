package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        //1 - 1
        //2 - 11, 2 
        //3 - 111, 12, 3
        //4 - 1111 , 112, 13, 22
        //5 - 11111 , 1112,  113, 122, 23
        //6 - 111111, 11112, 1113, 1122, 123, 222, 33
        //7 - 1111111, 111112, 11113, 11122, 1123, 1222, 133, 223
        
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[10001][3];
        arr[1][0] = 1;
        arr[2][0] = 1;
        arr[2][1] = 1;
        arr[3][0] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        for(int i = 4; i<=10000; i++) {
        	arr[i][0] = arr[i-1][0];
        	arr[i][1] = arr[i-2][0] + arr[i-2][1];
        	arr[i][2] = arr[i-3][0] + arr[i-3][1] + arr[i-3][2];
        }
        while(t-->0) {
        	int n = Integer.parseInt(br.readLine());
        	
        	sb.append(arr[n][0]+arr[n][1]+arr[n][2]).append('\n');
        }
        System.out.println(sb);
    }
}
