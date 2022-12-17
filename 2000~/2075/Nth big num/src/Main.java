import java.io.*;
import java.util.*;

//2075 N번째 큰수
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int j = 0; j<N; j++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j<N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
				pq.remove();
			}
		}
		
		System.out.println(pq.poll());
		
	}
}
