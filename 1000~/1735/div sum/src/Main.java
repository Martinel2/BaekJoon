import java.io.*;
import java.util.*;


//1735 ºÐ¼ö ÇÕ
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] son = new int[2];
		int[] mom = new int[2];
		int sumson = 0;
		int summom = 0;
		
		for(int i = 0; i<2; i++)
		{
			st = new StringTokenizer(br.readLine()," ");
			son[i] = Integer.parseInt(st.nextToken());
			mom[i] = Integer.parseInt(st.nextToken());
		}
		
		sumson += son[0]*mom[1] + son[1]*mom[0];
		summom = mom[0]*mom[1];
		int a = summom;
		int b = sumson;
		while(b != 0)
    	{
    		int r = a%b;
    		a = b;
    		b = r;
    	}
		System.out.println((int)(sumson/a) + " " + (int)(summom/a));
	}
}