import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static private int n,q;
	static private ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();//����,�������� ����Ʈ
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
		
		//n+1���� �游���(0�� ������ �����ϱ� ������ n+1)
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<Node>());
		
		//n-1�� ��ŭ ���� �� ���� ǥ��
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			//�����
			list.get(v1).add(new Node(v2,cost));
			list.get(v2).add(new Node(v1,cost));
		}
		
		//���� ������ŭ �����ְ� ���.
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			sb.append(findVideo(k, v)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	//������ v����� k�̻� ������ ������ ���� ã��, ���� ��ȯ.
	public static int findVideo(int k, int v) {
		Queue<Node> q = new LinkedList<>();
		boolean[] check = new boolean[n+1];
		q.add(new Node(v, Integer.MAX_VALUE));//���� �����߰�
		check[v] = true;//���� ����Ȯ��
		
		int cnt = 0, linkMinCost = 0;
		//v�� k�̻� ������ ���� ��� ã��. 
		while(!q.isEmpty()) {
			Node cur = q.poll();//���� ����
			ArrayList<Node> link = list.get(cur.v);//����� �����
			
			//����� ����� ��� Ž��(foreach������ �ص� �������)
			for(int i=0; i<link.size(); i++) {
				//�̹� Ȯ���� ������ ����
				if(check[link.get(i).v]) continue;
				
				//���� ����� ����� ������ �ּ� ���絵.
				linkMinCost = Math.min(link.get(i).cost, cur.cost);
				
				//k�̻� ������ ���� �Ʒ��� ���ǹ��� �����Ѵ�.
				//���� ���� ����� ������ ���絵�� k���� �۾����ٸ�,
				//�� �ڷ� ����� ��� ������ k���� �۾����ٴ� ���̵ȴ�. (���絵�� �ּҰ��̹Ƿ�)
				//�׷��� ���� �׳� ���絵�� k�̻�Ǵ°͸� Ȯ���ϸ鼭 ť�� �߰� �� �ݺ����ָ� �ȴ�.
				if(linkMinCost>=k) {
					check[link.get(i).v] = true;//���� Ȯ��
					cnt++;//����� ���� ī��Ʈ �߰�
					q.add(new Node(link.get(i).v,linkMinCost));//ť���� ����� ���� ���� �߰�
				}
			}
		}
		return cnt;
	}
}