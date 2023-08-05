import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String s = br.readLine();
	        int len = s.length();
	        int ans = 0;
	        int square; 
	        int pow = 0;
	        
	        if(s.contains("0x")){
	        	square = 16;
	        	for(int i = len - 1; i >= 2; i--) {
	        		int n;
	        		char sc = s.charAt(i);
	        		if('0' <= sc && sc <= '9')
	        			n = sc - '0';
	        		else
	        			n = 10 + (sc - 'a');
	        		
	        		ans += n * Math.pow(square, pow);
	        		pow++;
	        	}
	        	
	        }
	        else if(s.contains("0")) {
	        	square = 8;
	        	for(int i = len - 1; i >= 1; i--) {
	        		int n;
	        		char sc = s.charAt(i);
	        		n = sc - '0';

	        		ans += n * Math.pow(square, pow);
	        		pow++;
	        	}
	        }
	        else {
	        	square = 10;
	        	ans = Integer.valueOf(s);
	        }
	        
	        System.out.println(ans);
	 }
}
