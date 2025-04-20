package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] room = new int[2][7]; // 성별 , 학년
		int count = 0 ;
		int s , g;
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			room[s][g]++;			
		}
		
        	// 수용 인원으로 나누어주며 계산 
		for(int i = 0 ; i < 2 ; i ++) {
			for(int j = 1 ; j <7 ; j++) {
				count += room[i][j] / K ;
				if(room[i][j]% K !=0) {
					count++;
				}
			}
		}
		System.out.print(count);
    }
}