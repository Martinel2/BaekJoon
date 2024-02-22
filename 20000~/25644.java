import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long in = 0;
        long min = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
        	long price = Integer.parseInt(st.nextToken());
        	if(min < price) {
        		long l = price - min;
        		if(l > in)
        			in = l;
        	}
        	else
        		min = price;
        }
        
        System.out.println(in);
    }
}
