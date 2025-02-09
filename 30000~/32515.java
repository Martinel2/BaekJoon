package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        String tae = br.readLine();
        String t = br.readLine();
        String ian = br.readLine();
        String ia = br.readLine();
        
        String ans = "";
        boolean htg = false;
        for(int i = 0; i<n; i++) {
        	if(tae.charAt(i) == ian.charAt(i)) {
        		if(t.charAt(i) == ia.charAt(i)) ans += t.charAt(i);
        		else {
        			ans = "htg!";
        			htg = true;
        			break;
        		}
        	}
        }
        System.out.println(ans);
        
    }
}