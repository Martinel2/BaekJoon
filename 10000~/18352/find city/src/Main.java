import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//18352 Ư�� �Ÿ��� ���� ã��
public class Main {

	static Map<Integer, ArrayList<Integer>> E = new HashMap<>(); // ���� ����
	static int[] dis; // �ִܰŸ� ����
	static int K; // �ִܰŸ� K
	static boolean[] visit; // �湮���� Ȯ��
	static PriorityQueue<Integer> ans = new PriorityQueue<>(); // ������¿�
	
	static void dfs(int idx, int cnt) {
		visit[idx] = true;
		if(dis[idx] > cnt || dis[idx] == 0) // �ִ� �Ÿ� ����
			dis[idx] = cnt;
		if(cnt > K) // K���� ū ���� �ʿ䰡 ����
			return;
		else {
			if(E.get(idx) != null) { // ���� ���ÿ��� �ٸ� ���÷� ���� �ִٸ�
				ArrayList<Integer> go = E.get(idx); // �� �� �ִ� ���� �ޱ�
				Iterator<Integer> e = go.iterator();
				while(e.hasNext()) { // �� �� �ִ� ���� ��� �湮
					int k = e.next();
					//System.out.println(idx + " "+ k+ " cnt: "+(cnt+1));
					if(!visit[k] || dis[k] > cnt+1) //�湮�� ���� ���ų�, �ִܰŸ��� �� ���ִٸ�
						dfs(k,cnt+1);				// �湮�ϱ�
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
		
		//���� �Է¹ޱ�
		for(int i = 0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> hs; // �� ���ִ� ���� �迭�� ����
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
			if(dis[i] == K) //�ִܰŸ��� K���
				ans.add(i); // ����
		}
		
		// ���� ���
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
