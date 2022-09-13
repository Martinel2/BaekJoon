import java.io.*;
import java.util.*;

// 1916 �ּҺ�� ���ϱ�
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
        
        // 1. �Ÿ��迭 ���Ѵ�� �ʱ�ȭ
        dist = new int[V+1];
        for (int i=1; i<=V; i++) {
        	dist[i] = Integer.MAX_VALUE;
        }
        
        // 2. ��������Ʈ �ʱ�ȭ
        adjList = new ArrayList[V+1];
        for (int i=1; i<=V; i++) {
        	adjList[i] = new ArrayList<Edge>();
        }
        
        // 3. ���Ⱓ�� ��������Ʈ �Է�
        for (int i=1; i<=E; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	u = Integer.parseInt(st.nextToken());//���
        	v = Integer.parseInt(st.nextToken());//����
        	w = Integer.parseInt(st.nextToken());///����ġ
        	
        	adjList[u].add(new Edge(v,w));
        }
        
        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        // 4. ��������� ���ͽ�Ʈ�� ����
        dijkstra(D,T);
        
        // 5. ���
        bw.write(Integer.toString(ans));
        
        bw.flush();
        bw.close();
        br.close();
    }    

    static void dijkstra(int start, int end) {
    	// 1. ����� ����� 0���� �ϰ� ������� PQ�� �ְ� ����
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); 
        dist[start] = 0;
        pq.add(new Edge(start,0));
        
        while(!pq.isEmpty()) {
        	Edge now = pq.poll();
        	
        	// * Ư�� �������� �����ϴ� �����̹Ƿ�, ������ ������ break
        	if(now.id == end) {
        		if(dist[now.id] > now.cost)
        			ans = now.cost;
        		else
        			ans = dist[now.id];
        		break;
        	}
        	
        	
        	// 2. �� ū ����ġ�� ������ ��� �н�
        	if (now.cost > dist[now.id]) continue;
        	
        	// 3. ���� ��ġ�� ����� ���� Ž��
        	int len = adjList[now.id].size();
        	for (int i = 0; i<len; i++) {
        		Edge next = (Edge) adjList[now.id].get(i);
        		
        		// 4. cost�� �� �������� �����ϰ� PQ�� �ֱ�
        		if (dist[next.id] > now.cost + next.cost ) {
        			dist[next.id] = now.cost + next.cost;
        			pq.add(new Edge(next.id, dist[next.id]));
        		}
        	}
        	
        }
    }

}