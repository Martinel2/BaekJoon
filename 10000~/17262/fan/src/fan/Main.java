package fan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		
		int fast = 0, last=100001;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if(fast < start)
				fast = start; //���� ������ ������
			if(last > end)
				last = end; //���� ���� ����
		}
		int ans = fast-last; //���� ���� ������ ���� ������ ���۽������̿� �����ؾ���.
		if(ans < 0) //�����ϰ� ���� ���� 0���� ����
			ans = 0;
		System.out.println(ans);
	}
}
