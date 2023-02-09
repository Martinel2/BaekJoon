import java.io.*;


//6588 ∞ÒµÂπŸ»Â¿« √ﬂ√¯
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] che = new boolean[1000001];
		StringBuilder sb = new StringBuilder();
	
		for(int i = 2; i*i<1000000; i++) {
			for(int j = 2; j*i<1000000; j++) {
				che[i*j] = true;
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		while(n != 0){
			int small = 3;
			int big = n-3;
			while(true) {
				if(!che[big] && !che[small] && n == small+big)
					break;
				small+=2;
				big-=2;
				if(small>big)
					break;
			}
			if(small>big)
				sb.append("Goldbach's conjecture is wrong.\n");
			else
				sb.append(n).append(" = ").append(small).append(" + ").append(big).append("\n");
			n = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
	}
}