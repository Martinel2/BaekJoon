package solved;

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    
    st = new StringTokenizer(br.readLine());
    int n,m,r;
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    
    ArrayList<Integer>[] link = new ArrayList[n+1];
    int[] visit = new int[n+1];
    int[] depth = new int[n+1];
    long ans = 0;
    for(int i = 1; i<=n; i++) {
    	link[i] = new ArrayList<>();
    	depth[i] = -1;
    }
    
    for(int i=0; i<m; i++) {
    	st = new StringTokenizer(br.readLine());
    	int a =  Integer.parseInt(st.nextToken());
    	int b =  Integer.parseInt(st.nextToken());
    
    	link[a].add(b);
    	link[b].add(a);
    }
    
    for(int i = 1; i<=n; i++) {
    	Collections.sort(link[i]);
    }
    
    Queue<Integer> q= new LinkedList<>();
    q.add(r);
    depth[r] = 0;
    int cnt = 1;
    while(!q.isEmpty()) {
    	int now = q.poll();
    	visit[now] = cnt;
    	for(int next : link[now]) {
    		if(depth[next] == -1) {
    			q.add(next);
    			//System.out.println("depth: " + depth[now] + " " + now);
    			depth[next] = depth[now]+1;
    		}
    	}
    	cnt++;
    }
    
    for(int i = 1; i<=n; i++) {
    	//System.out.println(depth[i] + " " + visit[i]);
    	long a = depth[i];
    	a *= visit[i];
    	ans += a;
    }
    System.out.println(ans);
  }
}