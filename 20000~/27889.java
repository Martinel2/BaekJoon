package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashMap<String, String> hm = new HashMap<>();
		hm.put("NLCS", "North London Collegiate School");
		hm.put("BHA", "Branksome Hall Asia");
		hm.put("KIS","Korea International School");
		hm.put("SJA", "St. Johnsbury Academy");
		
		String s = br.readLine();
		System.out.println(hm.get(s));
	}
}