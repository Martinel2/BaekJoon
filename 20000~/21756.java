package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> num = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			num.add(i);
		}
		while(num.size() > 1){
			int m =  num.size() - 1;
			for (int i = m; i>=0 ; i--) {
				if(i % 2 == 0){
					num.remove(i);
				}
			}
		}
		System.out.println(num.get(0));
	}
}