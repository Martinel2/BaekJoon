import java.io.*;
import java.util.*;

//1339 단어 수학
public class Main {
	
	static 	int max = 0;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] alpacnt = new int[8][26];
		int[] sum = new int[26];
		
		for(int i = 0 ; i<N; i++)
		{
			char[] alpa = br.readLine().toCharArray();
			int len = alpa.length;
			for(int j = 0; j<len; j++)
			{
				int col = alpa[j] - 'A';
				alpacnt[ (len - 1) - j][col] += 1;
			}
		}
		
		for(int i = 0; i<26; i++)
		{
			for(int j = 0; j<8; j++)
			{
				sum[i] += (int) Math.pow(10, j) * alpacnt[j][i];
			
			}
		}
		
		Arrays.sort(sum);
		int k = 9;
		
		for(int i = 25; i>17; i--)
		{
			max += k * sum[i];
			k--;
		}
		System.out.print(max);
	}
}
