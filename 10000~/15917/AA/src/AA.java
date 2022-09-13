import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class AA {
	public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();
        
        int Q = Integer.parseInt(reader.readLine());
        
        for(int i = 0; i<Q; i++)
        {
        	int a = Integer.parseInt(reader.readLine());
        	if((a&(-a)) == a)
        		st.append("1\n");
        	else
        		st.append("0\n");
        }
        System.out.println(st);
	}
}
