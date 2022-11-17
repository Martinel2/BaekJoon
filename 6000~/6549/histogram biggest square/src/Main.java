import java.io.*;
import java.util.*;
import java.math.*;

//6549 히스토그램에서 가장 큰 직사각형
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		while(N != 0) {
			Stack<Integer> stack = new Stack<>();
			Stack<Integer> index = new Stack<>();
			int right=0,left=0;
			int histo = Integer.parseInt(st.nextToken());
			stack.add(histo);
			index.add(0);
			BigInteger ans = BigInteger.ZERO;
			for(int i = 1; i<N; i++)
			{
				histo = Integer.parseInt(st.nextToken());
				right = i;
				while(!stack.isEmpty() && stack.peek() > histo) { // 다음 막대가 더 작으면
					BigInteger V = BigInteger.ONE;
					V = V.multiply(new BigInteger(String.valueOf(stack.pop())));
					index.pop();
					if(!index.isEmpty()) {
						left = index.peek()+1;
					}
					else
						left = 0;
					int L = right - left;
					V = V.multiply(new BigInteger(String.valueOf(L)));
					if(ans.compareTo(V) == -1)
						ans = V;
					
				}
				stack.add(histo);
				index.add(i);
			}
			right = N;
			while(!stack.isEmpty()) {
				BigInteger V = BigInteger.ONE;
				V = V.multiply(new BigInteger(String.valueOf(stack.pop())));
				index.pop();
				if(!stack.isEmpty()) {
					left = index.peek()+1;
				}
				else
					left = 0;
				int L = right - left;
				V = V.multiply(new BigInteger(String.valueOf(L)));
				if(ans.compareTo(V) == -1)
					ans = V;
			}
			sb.append(ans).append("\n");
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	
		}
		System.out.print(sb);
	}
}

/*
7 2 1 4 5 1 3 3
4 1000 1000 1000 1000
0
*/