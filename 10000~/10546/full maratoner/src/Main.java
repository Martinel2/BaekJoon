import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> list = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N; i++) {
			String name = br.readLine();
			
			list.put(name, list.getOrDefault(name, 0)+1);
		}
		
		for(int i = 0; i<N-1; i++) {
			String name = br.readLine();
			
			if(list.containsKey(name)) {
				list.replace(name, list.get(name)-1);
				
				if(list.get(name) == 0)
					list.remove(name);
			}
		}
		
		for(String val : list.keySet())
			System.out.println(val);
	}
}
