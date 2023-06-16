import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//17356
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int uk = Integer.parseInt(st.nextToken());
		int ze = Integer.parseInt(st.nextToken());
		
		double M = (double)(ze-uk)/400;
		double win = 1/(1+Math.pow(10, M));
		
		System.out.println(win);
	}
}
