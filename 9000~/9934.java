package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] tree;
	static int n;
	static int[] t;
	static int idx=0;
	
	static void travel(int level) {
		//리프노드를 넘어섬
		if(n < level) return;
		
		travel(level+1);
		tree[level].add(t[idx++]);
		travel(level+1);
	}
	
	//모든 집은 리프가 아닌이상 왼쪽 오른쪽 자식이 존재
	//집의 갯수가 2^n-1
	//모든 레벨에서 2^l개의 노드가 존재 (l은 레벨)
	//따라서 첫번째로 방문하는 노드의 위치는 2^(n-1)-1 (루트가 0일때 기준)
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n+1];
		
		for(int i =0; i<=n; i++) {
			tree[i]= new ArrayList<>();
		}
		
		t = new int[(int)Math.pow(2, n)-1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<(int)Math.pow(2, n)-1; i++) {
			int v = Integer.parseInt(st.nextToken());
			t[i] = v;
		}
		

		travel(1);
		
		for(int i =1; i<=n; i++) {
			for(int val : tree[i]) {
				sb.append(val).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}