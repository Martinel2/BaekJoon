import java.io.*;
import java.util.HashSet;



//11478 서로 다른 부분 문자열의 개수
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hs = new HashSet<>();
		String s = br.readLine();
		int slen = s.length();
		for(int i = 0; i<slen; i++)
		{
			for(int j = i+1; j<=slen; j++){
				hs.add(s.substring(i, j));
			}
		}
		System.out.println(hs.size());
	}
}