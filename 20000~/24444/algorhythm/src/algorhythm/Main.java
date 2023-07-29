package algorhythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean visited[];
    static int result[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        result = new int[m+1];

        for(int i=0; i<=m; i++) list.add(new ArrayList<>());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1; i<=m; i++){
            var pos = list.get(i);
                Collections.sort(pos);
            }


        bfs(start, m);

        for(int i=1; i<=m; i++)
            System.out.println(result[i]);
    }

    public static void bfs(int start, int m){
        int cnt = 1;
        visited = new boolean[m+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        result[start] = cnt++;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int num : list.get(cur)){
                if(!visited[num]){
                    queue.add(num);
                    visited[num] = true;
                    result[num] = cnt++;
                }
            }
        }
    }
}