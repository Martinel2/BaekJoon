package hill;
import java.io.*;
import java.util.*;


//2846 오르막길
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int fir = 0, fin = 0, hill = 0;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
			
		for(int i = 0; i<N-1; i++)
		{
			fir = arr[i];
			for(int j = i; j<N-1; j++)
			{
				if(arr[j]<arr[j+1]) {
					fin = arr[j+1];
					if(hill < fin-fir)
						hill = fin - fir;
				}
				else
					break;
			}
		}
		
		if(hill<0)
			System.out.println(0);
		else
			System.out.println(hill);
	}
	
}