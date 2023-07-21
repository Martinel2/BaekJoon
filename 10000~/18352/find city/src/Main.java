import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//18352 특정 거리의 도시 찾기
public class Main {

	static Map<Integer, ArrayList<Integer>> E = new HashMap<>(); // 간선 집합
	static int[] dis; // 최단거리 저장
	static int K; // 최단거리 K
	static boolean[] visit; // 방문여부 확인
	static PriorityQueue<Integer> ans = new PriorityQueue<>(); // 정답출력용
	
	static void dfs(int idx, int cnt) {
		visit[idx] = true;
		if(dis[idx] > cnt || dis[idx] == 0) // 최단 거리 저장
			dis[idx] = cnt;
		if(cnt > K) // K보다 큰 경우는 필요가 없음
			return;
		else {
			if(E.get(idx) != null) { // 현재 도시에서 다른 도시로 갈수 있다면
				ArrayList<Integer> go = E.get(idx); // 갈 수 있는 도시 받기
				Iterator<Integer> e = go.iterator();
				while(e.hasNext()) { // 갈 수 있는 도시 모두 방문
					int k = e.next();
					//System.out.println(idx + " "+ k+ " cnt: "+(cnt+1));
					if(!visit[k] || dis[k] > cnt+1) //방문한 적이 없거나, 최단거리로 갈 수있다면
						dfs(k,cnt+1);				// 방문하기
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N,M,X;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		dis = new int[N+1];
		
		//간선 입력받기
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> hs; // 갈 수있는 도시 배열에 저장
			if(E.get(x) != null)
				hs = E.get(x);
			else
				hs = new ArrayList<>();
			hs.add(y);
			
			E.put(x, hs);
		}
		dfs(X,0);
		
		for(int i = 1; i<=N; i++) {
			//System.out.println(dis[i]);
			if(dis[i] == K) //최단거리가 K라면
				ans.add(i); // 저장
		}
		
		// 정답 출력
		if(ans.size() > 0) {
			for(int val : ans) {
				System.out.println(val);
			}
		}
		else
			System.out.println(-1);
	}
}

/*
4 4 2 1
1 2
1 3
2 3
2 4 
 */
