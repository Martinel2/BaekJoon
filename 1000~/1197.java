package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
       
        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>((o1, o2) -> o1.weight- o2.weight);
        A = new int[N];

        for(int i=1; i<N; i++){
            A[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.offer(new Edge(a, b, w));
        }

        int answer = 0;
        while (!edges.isEmpty()){
            Edge e = edges.poll();
            if(find(e.start) != find(e.destination)){
                union(e.start, e.destination);
                answer += e.weight;
            }
        }
        System.out.println(answer);
    }

    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        A[y] = x;
    }

    static int find(int a){
        if(A[a] == a) return a;
        else{
            A[a] = find(A[a]);
            return A[a];
        }
    }

    static class Edge{
        int start;
        int destination;
        int weight;

        Edge(int start, int destination, int weight){
            this.start = start;
            this.destination = destination;
            this.weight = weight;
        }

    }
}
