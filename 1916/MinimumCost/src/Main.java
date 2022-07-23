import java.io.*;
import java.util.*;

// 1916 최소비용 구하기
public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
   
    static class Edge implements Comparable<Edge>{
    	int id, cost;

		public Edge(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
    }
    
    static int V,E,D,T;
    static int u,v,w;
    static int [] dist;
    static ArrayList[] adjList;
    static int ans;
    
    public static void main(String[] args) throws Exception  {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        
        // 1. 거리배열 무한대로 초기화
        dist = new int[V+1];
        for (int i=1; i<=V; i++) {
        	dist[i] = Integer.MAX_VALUE;
        }
        
        // 2. 인접리스트 초기화
        adjList = new ArrayList[V+1];
        for (int i=1; i<=V; i++) {
        	adjList[i] = new ArrayList<Edge>();
        }
        
        // 3. 방향간선 인접리스트 입력
        for (int i=1; i<=E; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	u = Integer.parseInt(st.nextToken());//출발
        	v = Integer.parseInt(st.nextToken());//도착
        	w = Integer.parseInt(st.nextToken());///가중치
        	
        	adjList[u].add(new Edge(v,w));
        }
        
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        // 4. 출발지부터 다익스트라 진행
        dijkstra(D,T);
        
        // 5. 출력
        bw.write(Integer.toString(ans));
        
        bw.flush();
        bw.close();
        br.close();
    }    

    static void dijkstra(int start, int end) {
    	// 1. 출발지 비용은 0으로 하고 출발지를 PQ에 넣고 시작
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); 
        dist[start] = 0;
        pq.add(new Edge(start,0));
        
        while(!pq.isEmpty()) {
        	Edge now = pq.poll();
        	
        	// * 특정 목적지에 도착하는 문제이므로, 도착지 도착후 break
        	if(now.id == end) {
        		if(dist[now.id] > now.cost)
        			ans = now.cost;
        		else
        			ans = dist[now.id];
        		break;
        	}
        	
        	
        	// 2. 더 큰 가중치로 도착한 경우 패스
        	if (now.cost > dist[now.id]) continue;
        	
        	// 3. 현재 위치에 연결된 간선 탐색
        	int len = adjList[now.id].size();
        	for (int i = 0; i<len; i++) {
        		Edge next = (Edge) adjList[now.id].get(i);
        		
        		// 4. cost가 더 작을때만 갱신하고 PQ에 넣기
        		if (dist[next.id] > now.cost + next.cost ) {
        			dist[next.id] = now.cost + next.cost;
        			pq.add(new Edge(next.id, dist[next.id]));
        		}
        	}
        	
        }
    }

}