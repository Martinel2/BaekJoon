import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//14582
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] gemini = new int[9];
		int[] startlink = new int[9];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<9; i++) {
			gemini[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<9; i++) {
			startlink[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean win = false;
		
		int gem = 0;
		int slink = 0;
		for(int i = 0; i<9; i++) {
			gem += gemini[i];
			
			if(gem > slink) {
				win = true;
				break;
			}
			
			slink += startlink[i];
		}
		
		if(win) System.out.println("Yes");
		else System.out.println("No");
	}
}
