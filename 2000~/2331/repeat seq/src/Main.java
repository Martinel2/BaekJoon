import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//2331
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d1, p;
		
		d1 = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> al = new ArrayList<>();
		al.add(d1);
		
		int dn=0;
		int D = d1;
		while(D > 0) {
			dn += (int)Math.pow(D%10, p);
			D /= 10;
		}
		
		while(!al.contains(dn)) {
			al.add(dn);
			
			D = dn;
			dn = 0;
			while(D > 0) {
				dn += (int)Math.pow(D%10, p);
				D /= 10;
			}
		}
		
		System.out.println(al.indexOf(dn));
	}
}
