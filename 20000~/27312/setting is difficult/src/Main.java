import java.io.*;
import java.util.*;

//27312 ������� ���� ¥��� �����
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int M,N,Q;
		M = Integer.parseInt(st.nextToken()); // ĳ���� ��
		N = Integer.parseInt(st.nextToken()); // �Ӽ� ����
		Q = Integer.parseInt(st.nextToken()); // ���� ����
		
		int[] arr = new int[N]; // i��° �Ӽ���
		int[] newC = new int[N]; // ���ο� ĳ���� �Ӽ���
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			newC[i] = arr[i];
		}
		
		for(int i = 1; i<=M; i++) {
			System.out.println("? "+(i)+" "+(i));
			System.out.flush();
			int ans = Integer.parseInt(br.readLine());
			if(newC[i-1] == ans)
				newC[i-1]--;
		}
		
		sb.append("! ");
		for(int val : newC)
			sb.append(val+" ");
		System.out.print(sb);
		System.out.close();
		System.exit(0);
	}
}