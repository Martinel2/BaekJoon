package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main { 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] rank = new int[n];
        HashSet<Integer>[] arr = new HashSet[n+1];
        for(int i = 1; i<=n; i++) arr[i] = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) rank[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int mi = Integer.parseInt(st.nextToken());
        	for(int j = 0; j<mi; j++) {
        		arr[rank[i]].add(Integer.parseInt(st.nextToken()));
        	}
        }
        
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i<q; i++) {
        	int num = Integer.parseInt(br.readLine());
        	for(int j = 1; j<=n; j++) {
        		if(arr[j].contains(num)) sb.append(j).append(" ");
        	}
        	sb.append('\n');
        }
        System.out.println(sb);
    }
}