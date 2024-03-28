package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] u;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] list = new int[n+1][n+1];
		u = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			u[i]=i;
		}
		
		for(int i = 1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=n; j++) {
				int v = Integer.parseInt(st.nextToken());
				
				if(v == 1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		boolean clear = true;
		for(int i = 1; i<m; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if(start != find(now)) {
				clear = false;
				break;
			}
		}
		
		String ans = clear? "YES\n" : "NO\n";
		System.out.println(ans);
		
		//���������� �ش� ���ÿ� ���������ϴٸ�
		//�߰����ó����� ���� ��������
		//�������� ��ǥ�� unionfind���ؼ� �ش� ���ð� ��� �������� ���� �����̸� ����
	}
	
	static int find(int x) {
		if(x == u[x]) return x;
		else return u[x] = find(u[x]);
	}
	
	static void union(int x, int y) {
		x= find(x);
		y= find(y);
		if(x != y) {
			if(x < y)
				u[y] = x;
			else u[x] = y;
		}
	}
}