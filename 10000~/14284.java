package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class C implements Comparable<C>{
		int v;
		int e;
		
		C(int v, int e){
			this.v=v;
			this.e=e;
		}
		
		@Override
		public int compareTo(C o) {
			return this.e-o.e;
		}
	}
	static ArrayList<C>[] graph;
	static int[] dist;
	static void dijkstra(int str){
		//가중치가 최소인 간선으로 이동하기 위해 우선순위 큐 사용
		PriorityQueue<C> pq = new PriorityQueue<>();
		
		//출발지 추가
		pq.add(new C(str,0));
		dist[str] = 0;
		
		//다익스트라 알고리즘
		while(!pq.isEmpty()) {
			C cur = pq.poll();
			//저장된 값보다 더 많은 가중치가 필요한 경우는 무시
			if(dist[cur.v] < cur.e) continue;
			
			for(C next : graph[cur.v]) {
				int cost = cur.e + next.e;
				// cur까지의 가중치 + 다음 간선 가중치 < 저장된 다음 간선의 가중치
				if(cost < dist[next.v]) {
					dist[next.v] = cost;
					pq.add(new C(next.v,cost));
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	graph = new ArrayList[n+1];
    	
    	dist = new int[n+1];
    	Arrays.fill(dist, Integer.MAX_VALUE);
		
    	for(int i = 1; i<=n; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	
    	for(int i = 0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int str = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		int w = Integer.parseInt(st.nextToken());
    		
    		graph[str].add(new C(end,w));
    		graph[end].add(new C(str,w));
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int s = Integer.parseInt(st.nextToken());
    	int e = Integer.parseInt(st.nextToken());
    	dijkstra(s);
    	
    	System.out.println(dist[e]);
    }
}
