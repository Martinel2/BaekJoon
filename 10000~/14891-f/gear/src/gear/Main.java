package gear;
import java.util.*;
import java.io.*;

//톱니바퀴 -2진수 사용하기
public class Main {

	static int toD(String s) {
		int gg = 0;
		for(int i = 0; i<8; i++) {
			if(s.charAt(i) == '1')
				gg += Math.pow(2, 7-i);
		}
		return gg;
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] gear_NS = new String[4];
		gear_NS[0] = br.readLine(); gear_NS[1] = br.readLine();
		gear_NS[2] = br.readLine(); gear_NS[3] = br.readLine();
		int[] G = new int[4];
		G[0] = toD(gear_NS[0]); G[1] = toD(gear_NS[1]);
		G[2] = toD(gear_NS[2]); G[3] = toD(gear_NS[3]);
		int ans = 0;
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i<K; i++) {
			int[] isRotate = new int[4];
			st = new StringTokenizer(br.readLine(),  " ");
			int num = Integer.parseInt(st.nextToken())-1;
			isRotate[num] = Integer.parseInt(st.nextToken());
			
			for(int j = num-1; j>=0; j--) {
				if(gear_NS[j].charAt(2) != gear_NS[j+1].charAt(6)) {
					if(isRotate[j+1] == 1)
						isRotate[j] = -1;
					else if(isRotate[j+1] == -1)
						isRotate[j] = 1;
				}
				else
					break;
			}
			for(int j = num; j+1<=3; j++) {
				if(gear_NS[j].charAt(2) != gear_NS[j+1].charAt(6)) {
					if(isRotate[j] == 1)
						isRotate[j+1] = -1;
					else if(isRotate[j] == -1)
						isRotate[j+1] = 1;
					else
						break;
				}
				else
					break;
			}
			
			for(int j = 0; j<4; j++) {
				boolean flag = false;
				if(isRotate[j] == 1) {
					if(gear_NS[j].charAt(7) == '1')
						flag = true;
					G[j] = (G[j] >>> 1);
					String s = Integer.toBinaryString(G[j]);
					int len = Math.abs(gear_NS[j].length()-s.length());
					for(int k= 0; k<len; k++) {
						if(flag && k == 0)
							gear_NS[j]+="1";
						else
							gear_NS[j]+="0";
					}
					gear_NS[j]+= s;
					gear_NS[j] = gear_NS[j].substring(8, 16);
					System.out.println("idx: "+ j+ " tot:  " + gear_NS[j]);
					G[j] = toD(gear_NS[j]);
				}
				else if(isRotate[j] == -1) {
					if(gear_NS[j].charAt(0) == '1') {
						flag = true;
					G[j] = (G[j] << 1);
					String s = Integer.toBinaryString(G[j]);
					System.out.println(" s:  " + s);
					int len = Math.abs(s.length()-gear_NS[j].length());
					gear_NS[j]+=s;
					for(int k= 0; k<len; k++) {
						gear_NS[j]+="0";
					}
					gear_NS[j] = gear_NS[j].substring(9, gear_NS[j].length());
					System.out.println("idx: "+ j+ " tot:  " + gear_NS[j]);
					G[j] = toD(gear_NS[j]);
				}
			}
		}
		for(int i = 0; i<4; i++) {
			System.out.println(gear_NS[i]);
			if(gear_NS[i].charAt(0) == '1') {
				if(i == 0)
					ans += 1;
				else if(i == 1)
					ans += 2;
				else if(i == 2)
					ans += 4;
				else {
					ans += 8;
				}
			}
		}
		System.out.println(ans);
	}
}

/*
10101111
01111101
11001110
00000010
2
3 -1
1 1
*/