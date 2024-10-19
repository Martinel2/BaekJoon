package solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<t; i++) {
        	int num = Integer.parseInt(br.readLine());
        	
        	int squ = (int)Math.pow(num, 2);
        	String ssqu = String.valueOf(squ);
        	String snum = String.valueOf(num);
        	boolean flag = true;
        	for(int j = 0; j<snum.length(); j++) {
        		if(snum.charAt(snum.length()-1-j) != ssqu.charAt(ssqu.length()-1-j)) {
        			flag = false;
        			break;
        		}
        	}
        	String ans = flag? "YES":"NO";
        	sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}