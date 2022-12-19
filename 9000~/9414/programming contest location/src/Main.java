import java.io.*;
import java.util.*;

//9414 프로그래밍 대회 전용 부지
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int bud = 5000000;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
			int val = Integer.parseInt(br.readLine());
			while(val != 0) {
				pq.add(val);
				val = Integer.parseInt(br.readLine());
			}
			int ans = 0;
			int p = 1;
			while(!pq.isEmpty()) {
				int num = pq.poll();
				num = (int) Math.pow(num,p);
				ans+= 2*num;
				p++;
				if(ans>bud)
					break;
			}
			if(pq.isEmpty() && ans<=bud)
				sb.append(ans).append("\n");
			else
				sb.append("Too expensive").append("\n");
		}
		System.out.print(sb);
	}
}

/*
3
7
2
10
0
20
29
31
0
42
41
40
37
20
0
*/