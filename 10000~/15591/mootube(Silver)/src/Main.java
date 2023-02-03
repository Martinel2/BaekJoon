import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static private int n,q;
	static private ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();//정점,간선저장 리스트
	static private class Node{
		int v;
		int cost;
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		//n+1개의 방만들기(0번 정점은 제외하기 때문에 n+1)
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<Node>());
		
		//n-1개 만큼 정점 및 간선 표현
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//양방향
			list.get(v1).add(new Node(v2,cost));
			list.get(v2).add(new Node(v1,cost));
		}
		
		//질문 개수만큼 답해주고 출력.
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			sb.append(findVideo(k, v)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	//질문의 v영상과 k이상 연관된 동영상 전부 찾고, 개수 반환.
	public static int findVideo(int k, int v) {
		Queue<Node> q = new LinkedList<>();
		boolean[] check = new boolean[n+1];
		q.add(new Node(v, Integer.MAX_VALUE));//질문 영상추가
		check[v] = true;//질문 영상확인
		
		int cnt = 0, linkMinCost = 0;
		//v와 k이상 연관된 영상 모두 찾기. 
		while(!q.isEmpty()) {
			Node cur = q.poll();//현재 영상
			ArrayList<Node> link = list.get(cur.v);//연결된 영상들
			
			//연결된 영상들 모두 탐색(foreach문으로 해도 상관없음)
			for(int i=0; i<link.size(); i++) {
				//이미 확인한 영상은 제외
				if(check[link.get(i).v]) continue;
				
				//현재 영상과 연결된 영상의 최소 유사도.
				linkMinCost = Math.min(link.get(i).cost, cur.cost);
				
				//k이상 연관된 영상만 아래의 조건문을 실행한다.
				//따라서 현재 연결된 영상의 유사도가 k보다 작아진다면,
				//그 뒤로 연결된 모든 영상은 k보다 작아진다는 뜻이된다. (유사도는 최소값이므로)
				//그러면 나는 그냥 유사도가 k이상되는것만 확인하면서 큐에 추가 후 반복해주면 된다.
				if(linkMinCost>=k) {
					check[link.get(i).v] = true;//영상 확인
					cnt++;//연결된 영상 카운트 추가
					q.add(new Node(link.get(i).v,linkMinCost));//큐에는 연결된 영상 정보 추가
				}
			}
		}
		return cnt;
	}
}