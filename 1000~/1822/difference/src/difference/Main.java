package difference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//1822
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashSet<Integer> hs = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		
		int sizeA = Integer.parseInt(st.nextToken());
		int sizeB = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<sizeA; i++)
			hs.add(Integer.parseInt(st.nextToken()));
			
		st = new StringTokenizer(br.readLine());	
		for(int i = 0; i<sizeB; i++) {
			int B = Integer.parseInt(st.nextToken());
			
			if(hs.contains(B)) {
				hs.remove(B);
			}
		}
		
		if(hs.size() == 0) {
			System.out.println("0");
		}
		else {
			System.out.println(hs.size());
			for(int val : hs) {
				System.out.print(val + " ");
			}
		}
	}
}
