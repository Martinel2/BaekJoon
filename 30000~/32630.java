package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	arr[i] = Long.parseLong(st.nextToken());
        }
        
        long ans = 0;
        Arrays.sort(arr);
        //곱하길르 적용하는 경우
        //양수 * 양수
        //음수 * 0
        //음수 * 음수
        long a = arr[n-1]*arr[n-2];
        long b = arr[0]*arr[1];
        
        if(n>2) {
	        for(int i = 2; i<n-2; i++) {
	        	ans += arr[i];
	        }
	        
	        ans = Math.max(ans+(2*a)+arr[0]+arr[1], ans+(2*b)+arr[n-1]+arr[n-2]);
        }
        else
        	ans = Math.max(2*a, arr[0]+arr[1]);
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}