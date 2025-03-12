package solved;

import java.util.*;
import java.io.*;

public class Main {
		
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] link = new ArrayList[n];
        for(int i=0; i<n; i++) {
        	link[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a= Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	link[a].add(b);
        }
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        q.add(0);
        
        int ans = 0;
        int t = 0;
        while(t <= m) {
        	if(t%2 == 0) {
	        	while(!q.isEmpty()) {
	            	int now = q.poll();
	            	if(arr[now] == 1) ans++;
	            	for(int next: link[now]) q2.add(next);
	            	//System.out.println(q2.peek());
	            }
        	}
        	else {
        		while(!q2.isEmpty()) {
	            	int now = q2.poll();
	            	if(arr[now] == 1) ans++;
	            	for(int next: link[now]) q.add(next);

	            	//System.out.println(q.peek());
	            }
        	}
        	t++;
        }
        
        System.out.println(ans);
    }
}