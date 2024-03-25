package solved;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node> {
	int v;
    int weight;
 
    Node(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
 
    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
 
}


public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        HashSet<Integer> vertex = new HashSet<>();
        LinkedList<Node>[] g = new LinkedList[n];
        
        for(int i = 0; i<n; i++) {
        	g[i] = new LinkedList<>();
        }
        
        for(int i =0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int v1 = Integer.parseInt(st.nextToken())-1;
        	int v2 = Integer.parseInt(st.nextToken())-1;
        	int w = Integer.parseInt(st.nextToken());
        	
        	g[v1].add(new Node(v2,w));
        	g[v2].add(new Node(v1,w));
        }
        
        int ans = 0;
        vertex.add(0);
        for(Node node : g[0]) pq.add(node);
        
        while(!pq.isEmpty()) {
        	Node node = pq.poll();
        	
        	if(!vertex.contains(node.v)) {
        		vertex.add(node.v);
        		ans += node.weight;
        		
        		for(Node next : g[node.v]) {
        			if(!vertex.contains(next.v)) pq.add(next);
        		}
        	}
        }
        
        System.out.println(ans);
    }
}