import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class ROT13 {

	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder st = new StringBuilder();
        
        String S = reader.readLine();
        int len = S.length();
        for(int i = 0; i<len; i++) {
        	char R = S.charAt(i);
        	if(R >= 'a' && R <= 'z') {
        		if(R <= 'm') {
        			st.append((char)(R + 13));
        		}
        		else
        		{
        			st.append((char)(R-13));
        		}
        			
        	}
        	else if(R >= 'A' && R <= 'Z') {
        		if(R <= 'M') {
        			st.append((char)(R + 13));
        		}
        		else
        		{
        			st.append((char)(R-13));
        		}
        			
        	}
        	else
        		st.append(R);
        }
        System.out.println(st);
	}

}
