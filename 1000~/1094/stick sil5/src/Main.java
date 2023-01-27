import java.io.*;


//1094 ¸·´ë±â
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		int tot = 64;
		int a = 64;
		int stick = 1;
		
		while(tot != X) {
			a = a/2;
			stick++;
			if(tot-a >= X) {
				stick--;
				tot -= a;
			}
		}
		
		System.out.println(stick);
	}
}