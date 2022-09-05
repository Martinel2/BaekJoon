package wood;
import java.io.*;
import java.util.*;


//2947 나무 조각 -버블정렬
public class Main {
	
	static void SWAP(int a, int b)
	{
		int temp = bubble[a];
		bubble[a] = bubble[b];
		bubble[b] = temp;
	}
	static int[] bubble;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		bubble = new int[5];
		for(int i = 0; i<5; i++)
			bubble[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 4; i>=0; i--)
		{
			for(int j = 0; j<i; j++)
			{
				if(bubble[j] > bubble[j+1]) {
					SWAP(j,j+1);
					sb.append(bubble[0] + " " + bubble[1] + " " + bubble[2] + " " 
							+ bubble[3] + " " + bubble[4] + "\n");
				}
			}
		}
		System.out.print(sb);
	}
}