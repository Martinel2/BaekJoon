package tomato;

import java.io.*;
import java.util.*;

class tomat{
	int x;
	int y;
	
	tomat(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class tomato {

	static int res = 0;
	static int M,N;
	int to[][] = new int[1001][1001];
	static Queue<tomat> queue;
	static int[][] bor;
	static int BFS()
	{
		while(!queue.isEmpty()){
			int s = queue.size();
				tomat t = queue.remove();
				int x = t.x;
				int y = t.y;
				
				if(y+1<M)
					if(bor[x][y+1] == 0) {
						queue.add(new tomat(x,y+1));
                        bor[x][y+1] = bor[x][y] + 1;
					}

				if(y-1>=0)	
					if(bor[x][y-1] == 0){
						queue.add(new tomat(x,y-1));
                        bor[x][y-1] = bor[x][y] + 1;
					}	
					
				if(x+1<N)
					if(bor[x+1][y] == 0){
						queue.add(new tomat(x+1,y));
                        bor[x+1][y] = bor[x][y] + 1;
					}
					
				if(x-1>=0)
					if(bor[x-1][y] == 0){
						queue.add(new tomat(x-1,y));
                        bor[x-1][y] = bor[x][y] + 1;
					}

		}
        for(int i=0; i<N; i++)
		{
			for(int j =0; j<M; j++)
            {
				if(bor[i][j] == 0){
					return -1;
				}
                if(res<bor[i][j])
                    res=bor[i][j];
			}
		}
        return res-1;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		queue = new LinkedList<tomat>();
		bor = new int[N][M];
		for(int i=0; i<N; i++)
		{
			for(int j =0; j<M; j++)
			{
				bor[i][j] = sc.nextInt(); // 토마토 정보 주어짐 
				if(bor[i][j] == 1){
					queue.add(new tomat(i,j));
				}
			}
		}
		
		System.out.println(BFS());
			
		
	}
}
