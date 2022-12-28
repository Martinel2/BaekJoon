import java.io.*;
import java.util.*;

//11404 �÷��̵�
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // ��������
		int m = Integer.parseInt(br.readLine()); // ��������
		int[][] bus = new int[n][n]; // ��������Ʈ
		int INF = 987654321;
		//�ʱ�ȭ
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(i==j)
					bus[i][j] = 0;
				else
					bus[i][j] = INF;
			}
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			if(bus[a][b] > weight)
				bus[a][b] = weight;
		}
		
		//�÷��̵� �˰���
		for(int k = 0; k<n; k++) {
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					bus[i][j] = Math.min(bus[i][j],bus[i][k]+bus[k][j]);
				}
			}
		}
		
		//���
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(bus[i][j] == INF)
					bus[i][j] = 0;
				System.out.print(bus[i][j]+" ");
			}
			System.out.println();
		}
	}
}
