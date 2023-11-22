import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int max = 0;
		String longWord = "";
		
		outer:
	        while (true) {
	            String[] splited = br.readLine().trim().split(" ");

	            for (int i = 0; i < splited.length; i++) {
	                splited[i] = splited[i].replaceAll("[^a-zA-Z-]", " ").trim();
	                String[] tmp = splited[i].split(" ");

	                for (int j = 0; j < tmp.length; j++) {
	                    if (tmp[j].equals("E-N-D")) break outer;

	                    if (tmp[j].length() > max) {
	                        max = tmp[j].length();
	                        longWord = tmp[j].toLowerCase();
	                    }
	                }
	            }
	        }
		
		System.out.println(longWord);
	}
}
