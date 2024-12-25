package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        
        int ans = 0;
        int m = Integer.parseInt(br.readLine());
        
        while(m-->0) {
        	ans += arr[Integer.parseInt(br.readLine())-1];
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}