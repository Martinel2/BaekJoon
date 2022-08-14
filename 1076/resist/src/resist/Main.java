package resist;

import java.io.*;
import java.util.*;


//1076 ÀúÇ×
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> val = new HashMap<>();
		HashMap<String, Integer> multi = new HashMap<>();
		
		val.put("black", 0);
		val.put("brown", 1);
		val.put("red", 2);
		val.put("orange", 3);
		val.put("yellow", 4);
		val.put("green", 5);
		val.put("blue", 6);
		val.put("violet", 7);
		val.put("grey", 8);
		val.put("white", 9);
		
		multi.put("black", 1);
		multi.put("brown", 10);
		multi.put("red", 100);
		multi.put("orange", 1000);
		multi.put("yellow", 10000);
		multi.put("green", 100000);
		multi.put("blue", 1000000);
		multi.put("violet", 10000000);
		multi.put("grey", 100000000);
		multi.put("white", 1000000000);
		
		int resist = 0;
		String s;
		s = br.readLine();
		resist = val.get(s);
		s = br.readLine();
		resist = val.get(s) + resist*10;
		s = br.readLine();
		resist *= multi.get(s);
		System.out.print(resist);
	}
}
