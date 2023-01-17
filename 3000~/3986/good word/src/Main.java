import java.io.*;

//3986 좋은 단어
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0; i<N; i++) {
			String s = br.readLine();
			while(true) {
				if(!s.contains("AA") && !s.contains("BB"))
					break;
				if(s.contains("AA"))
					s = s.replaceAll("AA", "");
				if(s.contains("BB"))
					s = s.replaceAll("BB", "");
			}
			if(s.isEmpty())
				ans++;
		}
		System.out.println(ans);
	}
}