import java.io.*;
import java.util.*;


//14888 연산자 끼워넣기
public class Main {
	
	static int N;
	static int[] num;
	static int[] op;
	static int max = Integer.MIN_VALUE; 
	static int min = Integer.MAX_VALUE;
	
	static void search(int sum, int cnt) {
		if(cnt == N) {
			if(max < sum)
				max = sum;
			if(min > sum)
				min = sum;
			return;
		}
		else {
			for(int i = 0; i<4; i++){ 
				if(op[i] > 0) {
					op[i]--;
					if(i == 0) {  // +
						search(sum + num[cnt], cnt+1);	
					}
					else if(i == 1) { // -
						search(sum - num[cnt], cnt+1);
					}
					else if(i == 2) { // *
						search(sum * num[cnt], cnt+1);
					}
					else if(i == 3){ // /
						search(sum / num[cnt], cnt+1);
					}
					op[i]++;
				}
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		op = new int[4];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i< N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<4; i++)
			op[i] = Integer.parseInt(st.nextToken());
		search(num[0],1);
		System.out.print(max + "\n" + min);
	}
}