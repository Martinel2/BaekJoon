import java.io.*;

//9656 µπ ∞‘¿” 2
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N%2 == 0)
			System.out.print("SK");
		else
			System.out.print("CY");
	}
}