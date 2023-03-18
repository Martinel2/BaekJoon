package wormholl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

//1865 ¿úÈ¦
public class Main {
	 static int n;
	    static LinkedList<Edge> list[];
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer stz;
	        int tc = Integer.parseInt(br.readLine());
	        StringBuilder sb = new StringBuilder();
	        
	        while(tc --> 0) {
	            stz = new StringTokenizer(br.readLine());
	            n = Integer.parseInt(stz.nextToken());
	            int m = Integer.parseInt(stz.nextToken());
	            int w = Integer.parseInt(stz.nextToken());
	            list = new LinkedList[n+1];
	            for(int i = 1; i <= n; i++)
	                list[i] = new LinkedList<>();
	            for(int i = 0; i < m+w; i++) {
	                stz = new StringTokenizer(br.readLine());
	                int s = Integer.parseInt(stz.nextToken());
	                int e = Integer.parseInt(stz.nextToken());
	                int t = Integer.parseInt(stz.nextToken());
	                
	                if(i < m) {
	                    list[s].add(new Edge(e, t));
	                    list[e].add(new Edge(s, t));
	                }
	                else
	                    list[s].add(new Edge(e, -t));
	            }
	            
	            boolean cycle = false;
	            for(int i = 1; i <= n; i++) {
	                if(bellmanFord(i)) {
	                    cycle = true;
	                    sb.append("YES\n");
	                    break;
	                }
	            }
	            
	            if(!cycle)
	                sb.append("NO\n");
	        }
	    
	        System.out.println(sb.toString());
	    }
	    
	    public static boolean bellmanFord(int start) {
	        int dist[] = new int[n+1];
	        Arrays.fill(dist, 987654321);
	        dist[start] = 0;
	        boolean update = false;
	        
	        for(int i = 1; i < n; i++) {
	            update = false;
	            
	            for(int j = 1; j <= n; j++) {
	                for(Edge edge : list[j]) {
	                    if(dist[j] != 987654321 && dist[edge.v] > dist[j] + edge.w) {
	                        dist[edge.v] = dist[j] + edge.w;
	                        update = true;
	                    }
	                }
	            }
	            
	            if(!update)
	                break;
	        }
	        
	        if(update) {
	            for(int i = 1; i <= n; i++) {
	                for(Edge edge : list[i]) {
	                    if(dist[i] != 987654321 && dist[edge.v] > dist[i] + edge.w)
	                        return true;
	                }
	            }
	        }
	        
	        return false;
	    }
	    
	    static class Edge{
	        int v, w;
	        
	        Edge(int v, int w) {
	            this.v = v;
	            this.w = w;
	        }
	    }
}
/*
2
3 3 1
1 2 2
1 3 4
2 3 1
3 1 3
3 2 1
1 2 3
2 3 4
3 1 8
*/