import java.io.*;

//4375 1
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s==null)
				break;
			else {
				int n = Integer.parseInt(s);
				int num = 0;
				
				for(int i = 0; ; i++) {
					num = (num * 10 + 1)% n;
					
					if(num == 0) {
						System.out.println(i+1);
						break;
					}
				}
			}
		}
		
	}
}
