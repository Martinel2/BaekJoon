import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11328
public class Main {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	        StringBuilder sb = new StringBuilder();
	        
	        int T = Integer.parseInt(br.readLine());
	        
	        for(int t = 0; t<T; t++) {
	        	int[] count = new int[26];
	        	boolean poss = true;
	        	st = new StringTokenizer(br.readLine());
	        	String origin = st.nextToken();
	        	String strfry = st.nextToken();
	        	if(origin.length() != strfry.length()) {
	        		sb.append("Impossible\n");
	        	}
	        	else {
	        		int len = origin.length();
		        	for(int i = 0; i<len; i++) 
		        		count[origin.charAt(i)-'a']++;
		        	
		        	
		        	for(int i = 0; i<len; i++) {
		        		int idx = strfry.charAt(i)-'a';
		        		if(count[idx] == 0) {
		        			poss = false;
		        			break;
		        		}
		        		else
		        			count[idx]--;
		        	}
		        	if(poss)
		        		sb.append("Possible\n");
		        	else
		        		sb.append("Impossible\n");
	        	}
	        	
	        }
	        System.out.println(sb);
	 }
}
