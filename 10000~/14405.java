package solved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st;
        String ans = "";
        String s = br.readLine();
        
        s = s.replaceAll("pi", "1");
        s = s.replaceAll("ka","1");
        s = s.replaceAll("chu", "1");
        s= s.replaceAll("1", "");
        ans = s.length()> 0? "NO" : "YES";
        System.out.println(ans);
    }
}