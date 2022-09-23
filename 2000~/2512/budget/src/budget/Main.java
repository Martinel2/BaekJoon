package budget;
import java.io.*;
import java.util.*;


//5676 음주코딩
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		int[] req = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i<N; i++) {
			req[i] = Integer.parseInt(st.nextToken());
			sum += req[i];
		}
		int total = Integer.parseInt(br.readLine());
		Arrays.sort(req);
		if(total >= sum)// 다 줄수 있으면
			System.out.println(req[N-1]); // 가장 큰 수
		else // 상한액을 지정해야 하면
		{
			int min = total/N;
			int i = 0;
			while(req[i] <= min)
			{
				total -= req[i];
				i++;
			}
			System.out.println(total/(N-i));
		}
		
	}
}