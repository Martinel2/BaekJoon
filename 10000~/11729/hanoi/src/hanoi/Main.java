package hanoi;
import java.io.*;


//11729 하노이 탑 이동 순서
public class Main {
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	static void hanoi(int N, int start, int end, int sub)
	{
		if(N == 1)
		{
			move(start,end);
		}
		else
		{
			hanoi(N-1,start,sub,end);
			move(start,end);
			hanoi(N-1,sub,end,start);
		}
	}
	static void move(int start, int end) {
		cnt++;
		sb.append(start+" "+end+"\n");
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N,1,3,2);
		System.out.println(cnt);
		System.out.println(sb);
	}
}