import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean checkMou(char sc){
		return sc == 'a' || sc == 'e' || sc == 'i' || sc == 'o' || sc == 'u';
	}
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        
	        String s = br.readLine();
	        while(!s.equals("end")) {
	        	
	        	boolean mou = false;
	        	boolean notSeq = true;
	        	boolean notSame = true;
	        	
	        	for(int i = 0; i<s.length(); i++) {
	        		char sc = s.charAt(i);
	        		
	        		if(checkMou(sc)) {
	        			mou = true;
	        		}
	        		
	        		if(i < s.length()-1 && sc == s.charAt(i+1)) {
	        			if(sc != 'e' && sc != 'o')
	        				notSame = false;
	        		}
	        		
	        		if(i < s.length()-2 && 
	        				(checkMou(sc) == checkMou(s.charAt(i+1)) 
	        				&& checkMou(sc) == checkMou(s.charAt(i+2)))) {
	        			notSeq = false;
	        		}
	        	}
	        	
	        	sb.append("<").append(s).append("> is ");
	        	if(mou && notSame && notSeq) 
	        		sb.append("acceptable.\n");
	        	else
	        		sb.append("not acceptable.\n");
	        	
	        	s = br.readLine();
	        }
	        System.out.println(sb);
	 }
}
