package solved;

import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static List<List<Integer>> list;

    static boolean [] check;
    static boolean [] visited;
    static int answer = 1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(N==1) answer = 1;
        else if(M==0) answer = 1;
        else{
            list = new ArrayList<>();
            check = new boolean[N+1];
            visited = new boolean[N+1];
            for(int i=0;i<N+1;i++) list.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
            check[from] = true;

            for(int i=1;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                from = Integer.parseInt(st.nextToken());
                to  = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                list.get(to).add(from);
            }

            bfs(from);
        }
        System.out.println(answer);
    }

    static void bfs(int start){
        visited[start] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty()){
            int node = q.poll();

            for(int next :list.get(node)){
                if(visited[next] && check[node]==check[next]){
                    answer = 0;
                    return;
                }
                if(!visited[next]){
                    visited[next] = true;
                    check[next] = !check[node];
                    q.offer(next);
                }
            }
        }
    }
}