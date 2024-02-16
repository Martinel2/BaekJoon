import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		HashSet<String> hm = new HashSet<>();
		
		String ans = "";
		String bef = " ";
		char start = ' ';
		char end = ' ';
		for(int i = 0; i<n; i++) {
			String aft = br.readLine();
			if(bef.equals("?")) 
				end = aft.charAt(0);
			if(aft.equals("?")) 
				start = bef.charAt(bef.length()-1);
			
			hm.add(aft);
			bef = aft;
		}
		//System.out.println(start+ " " +end);
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i<m; i++) {
			String s = br.readLine();
			if(hm.contains(s)) continue;
			if((s.charAt(0) == start || start == ' ') 
					&& (s.charAt(s.length()-1) == end || end == ' ')) {
				ans = s;
				break;
			}
		}
		System.out.println(ans);
	}
}
