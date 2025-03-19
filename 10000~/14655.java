package solved;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());

        int[] fr = new int[n];
        int[] sr = new int[n];

        long ans = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	fr[i] = Math.abs(Integer.parseInt(st.nextToken()));
        	ans += fr[i];
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	sr[i] = Math.abs(Integer.parseInt(st.nextToken()));
        	ans += sr[i];
        }
        
        System.out.println(ans);
        
    }
}