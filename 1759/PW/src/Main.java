import java.io.*;
import java.util.*;


public class Main {
	static int L,C;
	static char[] pw;
	static char[] code;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(tk.nextToken());
		C = Integer.parseInt(tk.nextToken());
		code = new char[L];
		pw = new char[C];
		tk = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i<C; i++)
		{
			pw[i] = tk.nextToken().charAt(0);
		}
		
		Arrays.sort(pw);
		
		MC(0,0);
	
		
	}
	public static void MC(int x, int index)
	{
		if(index == L)
		{
			if(isVaild()) {
				System.out.println(code);
			}
			return;
		}
		
		for(int i = x; i < C; i++) {
			code[index] = pw[i];
			MC(i+1, index + 1);
		}
	}
	
	public static boolean isVaild() {
		int m = 0;
		int z = 0;
		
		for(char x : code) {
			if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')
				m++;
			else
				z++;
		}
		if(m>=1 && z >= 2)
			return true;
		else
			return false;
	}
	
}
