import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		h = Integer.parseInt(br.readLine());
		house = new int[h][3];
		for(int i = 0; i<h; i++)
		{
			String[] s = br.readLine().split(" ");
			house[i][0] = Integer.parseInt(s[0]);
			house[i][1] = Integer.parseInt(s[1]);
			house[i][2] = Integer.parseInt(s[2]);
			
		}
		
		for(int i =0; i<3; i++)
		{
			Search(0,i,0);
		}
		System.out.print(min);
		
	}
	static int min = -1;
	static int h;
	static int[][] house;
	static void Search(int x, int y, int sum)
	{
		sum += house[x][y];
		if(x+1 == h)
		{
			if(min>sum || min == -1)
				min = sum;
			return;
		}
		else
		{
			if(y == 0)
			{
				Search(x+1,1,sum);
				Search(x+1,2,sum);
			}

			else if(y == 1)
			{
				Search(x+1,0,sum);
				Search(x+1,2,sum);
			}
			
			else // y == 2
			{
				Search(x+1,0,sum);
				Search(x+1,1,sum);
			}
		}
	}
}
