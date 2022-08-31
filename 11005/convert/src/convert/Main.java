package convert;
import java.io.*;
import java.util.*;


//11005 진법 변환 2
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashMap<Integer, Character> convert = new HashMap<>();
		char alpa = 'A';
		for(int i = 10; i<36; i++)
		{
			convert.put(i, alpa);
			alpa = (char) (alpa + 1);
		}
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		String s = "";
		while(N != 0)
		{
			int num =  N%B;
			if(num >= 10)
				s += String.valueOf(convert.get(num));
			else
				s += String.valueOf(num);
			N /= B;
		}
		for(int j = s.length()-1; j>=0; j--)
			System.out.print(s.charAt(j));
	}
}