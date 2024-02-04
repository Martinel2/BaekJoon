package candiate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//1713
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int r = Integer.parseInt(br.readLine());
		
		int[] count = new int[101];
		ArrayList<Integer> can = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<r; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(can.contains(num)) {
				count[num]++;
			}
			else {
				if(can.size() == n) {
					int min = 1001;
					int id = 0;
					for(int val : can) {
						if(count[val] < min) {
							min = count[val];
							id = val;
						}
					}
					can.remove(can.indexOf(id));
					count[id] = 0;
				}
				can.add(num);
				count[num]++;
			}
		}
		
		Collections.sort(can);
		for(int val : can) {
			System.out.print(val + " ");
		}
	}
}
