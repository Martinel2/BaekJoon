import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Rnum {
	 public static void main(String args[]) throws IOException{
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        
	        String s = reader.readLine();
	        
	        int[] count = new int[10];
	        Arrays.fill(count, 0);
	        int max = 0;
	        int len = s.length();
	        for(int i =0;  i<len; i++)
	        {
	        	count[s.charAt(i)-'0']++;
	        	if(max<count[s.charAt(i)-'0'] && s.charAt(i)-'0' != 6 && s.charAt(i)-'0' != 9)
	        		max = count[s.charAt(i)-'0'];
	        }
	        if(max >= Math.ceil( (double)(count[6]+count[9])/2 ) )
	        	System.out.println(max);
	        else
	        {
	        	System.out.println((int)Math.ceil( (double)(count[6]+count[9])/2 ));
	        }
	        
	 }
}
