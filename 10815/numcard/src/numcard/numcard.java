package numcard;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.Arrays;

public class numcard {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();
        
        int num;
        int N = Integer.parseInt(br.readLine());
        boolean[] count =  new boolean[20000001];
        Arrays.fill(count, false);
        String s[];
        
        s = br.readLine().split(" ");
        for(int i = 0; i<N; i++)
        {
        	num = Integer.parseInt(s[i]);
        	count[num+10000000] = true;
        }
        int M = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");
        for(int i = 0; i<M; i++)
        {
        	num = Integer.parseInt(s[i]);
        	if(count[num+10000000])
        	{
        		st.append("1 ");
        	}
        	else
        		st.append("0 ");
        }
	
        System.out.println(st);
	}
}
