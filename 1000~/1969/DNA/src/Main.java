import java.io.*;
import java.util.*;


//1969 DNA
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String ans = "";
		int sum = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] s = new char[N][M+1];
		for(int i = 0; i<N; i++)
			s[i] = br.readLine().toCharArray();
		
		//세로줄로 보았을때 가장 빈번하게 나오는 알파벳 채택-같을시 알파벳기준 가장 빠른것
		for(int i = 0; i<M; i++)//세로
		{
			int[] alpa = new int[26];
			int max = 1;
			char maxalpa = 'A';
			for(int j = 0; j<N; j++)//가로
				alpa[s[j][i]-'A']++;
				
			for(int k = 0; k<26; k++)
			{
				if(alpa[k] > max)
				{
					max = alpa[k];
					maxalpa = (char)('A'+ k);
				}
			}
			sum += N-max;
			ans += maxalpa;
		}
		System.out.print(ans+ "\n" + sum);
	}
}