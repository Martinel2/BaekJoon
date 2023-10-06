package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> d = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		while(N--> 0) {
			st = new StringTokenizer(br.readLine());
			String com = st.nextToken();
			int num=0;
			switch(com) {
			case "1":
				num = Integer.parseInt(st.nextToken());
				d.addFirst(num);
				break;
			case "2":
				num = Integer.parseInt(st.nextToken());
				d.addLast(num);
				break;
			case "3":
				if(!d.isEmpty())
					sb.append(d.pollFirst()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "4":
				if(!d.isEmpty())
					sb.append(d.pollLast()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "5":
				sb.append(d.size()).append('\n');
				break;
			case "6":
				if(!d.isEmpty())
					sb.append(0).append('\n');
				else
					sb.append(1).append('\n');
				break;
			case "7":
				if(!d.isEmpty())
					sb.append(d.peekFirst()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			case "8":
				if(!d.isEmpty())
					sb.append(d.peekLast()).append('\n');
				else
					sb.append(-1).append('\n');
				break;
			}
		}
		
		System.out.println(sb);
	}
}
