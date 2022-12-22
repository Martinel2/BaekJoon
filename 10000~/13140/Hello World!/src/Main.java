import java.io.*;

//13140 Hello World!
public class Main {
	
	static long N;
	static int[] helowrd = new int[7];
	static boolean[] visit = new boolean[10];
	static boolean flag = false;
	
	static void BT(int cnt) {
		if(flag)
			return;
		else if(cnt == 7) {
			long hello = helowrd[0]*10000 + helowrd[1]*1000 + helowrd[2]*110 + helowrd[3];
			long world = helowrd[4]*10000 + helowrd[3]*1000 + helowrd[5]*100 + helowrd[2]*10 + helowrd[6];
			
			if(hello + world == N && helowrd[0] != 0 && helowrd[4] != 0)
			{
				flag = true;
				System.out.println("  "+hello);
				System.out.println("+ "+world);
				System.out.println("-------");
				if(N>=100000)
					System.out.println(" " + N);
				else
					System.out.println("  " + N);
			}
		}
		else {
			for(int i = 0; i<=9; i++) {
				if(flag)
					return;
				if(!visit[i]){
					visit[i] = true;
					helowrd[cnt] = i;
					BT(cnt+1);
					visit[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Long.parseLong(br.readLine());
		BT(0);
		if(!flag)
			System.out.println("No Answer");
	}
}
