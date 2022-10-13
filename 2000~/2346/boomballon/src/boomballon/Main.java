package boomballon;

//2346 ǳ�� �Ͷ߸���
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Deque<int[]> q = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("1 ");
		int in = arr[0];
		
		for(int i=1; i<n; i++){
			q.add(new int[] {(i+1), arr[i]}); // {ǳ�� idx, ����}
		}
		
		while(!q.isEmpty()) {
			// ����� ��� 
			if(in >0) {
				// ���� �ڷ� ������ 
				for(int i=1; i<in; i++) {
					q.add(q.poll());
				}
				
				int[] nxt = q.poll();
				in = nxt[1];
				sb.append(nxt[0]+" ");
			}
			// ������ ��� 
			else {
				for(int i=1; i<-in; i++	) {
					q.addFirst(q.pollLast());
				}
				
				int[] nxt = q.pollLast();
				in = nxt[1];
				sb.append(nxt[0]+" ");
			}
		}
				
		System.out.println(sb.toString());
		
	}
}