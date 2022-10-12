package ymelon;
import java.io.*;
import java.util.*;


//2477 Âü¿Ü¹ç
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int mel = Integer.parseInt(br.readLine());
		int[][] arr = new int[6][2];
		int[] cnt = new int[5];
		int tot = 1;
		int bordor = 1;
		for(int i = 0; i<6; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			cnt[arr[i][0]]++;
		}
		
		for(int i = 1; i<=4; i++)
		{
			if(cnt[i] != 2)
				for(int j = 0; j<6; j++)
				{
					if(i == arr[j][0])
						tot *= arr[j][1];
				}
			else
			{
				for(int j = 0; j<6; j++)
				{
					if(i == arr[j][0])
					{
						if(i == 1 && cnt[3] == 2 && arr[(j+1)%6][0] == 3){//1,3 ¤¡
							bordor *= arr[j][1] * arr[(j+1)%6][1];
						}
						else if(i == 4 && cnt[1] == 2 && arr[(j+1)%6][0] == 1){//4,1 ¦®
							bordor *= arr[j][1] * arr[(j+1)%6][1];
						}
						else if(i == 2 && cnt[4] == 2 && arr[(j+1)%6][0] == 4){//2,4 ¤¤
							bordor *= arr[j][1] * arr[(j+1)%6][1];
						}
						else if(i == 3 && cnt[2] == 2 && arr[(j+1)%6][0] == 2){//3,2 ¦°
							bordor *= arr[j][1] * arr[(j+1)%6][1];
						}
					}
				}
			}
		}
		System.out.println(mel*(tot-bordor));
	}
}