package hockey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1358
public class Main {
	static int W,H,X,Y,P;
	static double R;
	static boolean inRect(int px, int py) {
		return ((X <= px && px <= (X+W)) && (Y <= py && py <= (Y+H)));
	}
	
	static boolean inCir(int px, int py){
		double line = Math.sqrt( ( Math.pow((px-X),2) + (Math.pow(py-(Y+R),2) )) );
		double line2 = Math.sqrt( ( Math.pow((px-(X+W)),2) + (Math.pow(py-(Y+R),2) )) );
		return (line <= R || line2 <= R);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		//���簢�� ���� ���� (x <= px <= x+W) (y <= py <= y + H)
		//�ݿ����� ���� (x,y+R)�� ���� ������ ���� <= R (x+W,y+R)�� ���� ������ ���� <= R
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		P = Integer.parseInt(st.nextToken());
		R = (double)H/2;
		for(int i = 0; i<P; i++) {
			st = new StringTokenizer(br.readLine());
			int px = Integer.parseInt(st.nextToken());
			int py = Integer.parseInt(st.nextToken());
			
			if(inRect(px,py) || inCir(px,py))
				ans++;
		}
		
		System.out.println(ans);
	}
}
