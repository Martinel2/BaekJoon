import java.io.*;

//1543 문서 검색
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String pat = br.readLine();
		String[] ans = s.split(pat);
		System.out.println(ans.length-1);
	}
}