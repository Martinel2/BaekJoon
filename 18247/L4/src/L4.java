import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;



public class L4 {
	 public static void main(String args[]) throws IOException{
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder st = new StringBuilder();
	        
	        int T = Integer.parseInt(reader.readLine());
	        String[] Seat;
	        while(T-- != 0) {
	        	Seat = reader.readLine().split(" ");
	        	int N = Integer.parseInt(Seat[0]);
	        	int M = Integer.parseInt(Seat[1]);
	        	if(N < 12 || M<4) {
	        		st.append("-1\n");
	        	}
	        	else
	        	{
	        		st.append((11*M+4) + "\n"); // L�� 12��° ���̹Ƿ� 11*M�� K�������� �¼���
	        	}
	        }
         System.out.println(st);
	 }
}
