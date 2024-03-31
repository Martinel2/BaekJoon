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
		//������带 �Ѿ
		if(n < level) return;
		
		travel(level+1);
		tree[level].add(t[idx++]);
		travel(level+1);
	}
	
	//��� ���� ������ �ƴ��̻� ���� ������ �ڽ��� ����
	//���� ������ 2^n-1
	//��� �������� 2^l���� ��尡 ���� (l�� ����)
	//���� ù��°�� �湮�ϴ� ����� ��ġ�� 2^(n-1)-1 (��Ʈ�� 0�϶� ����)
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