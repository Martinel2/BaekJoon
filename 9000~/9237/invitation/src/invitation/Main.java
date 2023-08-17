package invitation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] tree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken())+1; //�� �ڶ�� �ð� + ������ ������ ���� 1��
		}
		
		Arrays.sort(tree);
		
		int cnt = tree[0] + 1; //ù��° ������ �������� 2�����̴�.
		
		for(int i = N-2; i>=0; i--) {
			if(cnt < tree[i] + (N-i)) //������ ������ ���� 1�� �̹Ƿ�, �ι�° ������ �ɴ³��� 3�������ȴ�.
				cnt = tree[i] + (N-i);
			//System.out.println(tree[i] + "  "+ cnt);
		}
		
		System.out.println(cnt);
	}
}
