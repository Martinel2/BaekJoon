import java.io.*;
import java.util.*;

/*
    위상 정렬 이용 : 선후 관계가 있고, 사이클이 없으면서 순서를 알아야 하기 때문
    건물은 동시에 지을 수 있기에 직전 건물까지 걸린 시간을 알고 있어야 함
 */
public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static ArrayList<Integer> [] graph;
    static int [] inDegree;
    static int N, M;


    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int time [];
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            time = new int[N+1];
            graph = new ArrayList[N+1];
            inDegree = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                graph[i] = new ArrayList<>();
                // 건물 짓는데 걸리는 시간
                time[i] = Integer.parseInt(st.nextToken());
            }

            // 규칙 입력 받음
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                graph[X].add(Y);
                inDegree[Y]++;
            }
            // 출력해야하는 건물
            int W = Integer.parseInt(br.readLine());
            bw.write(sort(time, W)+"\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }

    public static int sort(int [] time, int W){
        Queue<Integer> que = new LinkedList();
        int [] startTime = new int[N+1];

        for(int i=1; i<= N; i++){
            if(inDegree[i] == 0)
                que.add(i);
        }

        while(!que.isEmpty()){
            int cur = que.poll();
            if(cur == W)
                break;

            for(int next : graph[cur]){
                // 가장 늦게 지어진 것이 지어지고 next 건물을 지을 수 있다
                startTime[next] = Math.max(startTime[next], startTime[cur] + time[cur]);
                inDegree[next]--;

                if(inDegree[next] == 0){
                    que.add(next);
                }
            }
        }
        return startTime[W] + time[W];
    }




}