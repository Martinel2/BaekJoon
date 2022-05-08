#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int dfs(int map[][64], bool visit[][64], int x, int y, int N)
{
	if(x>N || y>N) //밖으로 넘어가서 게임오버 
		return 0;
	else
	{
		int z = map[x][y];
		visit[x][y] = true;
		if(z == -1) // 목적지 도착 
			return 1;
		else
		{
			if(x+z<=N && y+z<=N) //둘다 탐색해야함 
			{
				if(!visit[x+z][y] && !visit[x][y+z]) // 둘다 가봐야함 
					return dfs(map, visit, x+z, y, N) + dfs(map, visit, x, y+z, N);
				else if(!visit[x+z][y]) // 아래로는 가봄 
					return dfs(map, visit, x+z, y, N);
				else if(!visit[x][y+z]) // 오른쪽으로는 가봄 
					return dfs(map, visit, x, y+z, N);
				else // 막다른길 
					return 0;
			}
			else if(x+z<=N) //아래로는 못감 
			{
				if(!visit[x+z][y])
					return dfs(map, visit, x+z, y, N);
				else 
					return 0;	
			}
			else if(y+z<=N)// 오른쪽으로는 못감 
			{
				if(!visit[x][y+z])
					return dfs(map, visit, x, y+z, N);
				else 
					return 0;	
			}
			else // 갈수가 없음 
				return 0;
		}	
	}	
}

int main()
{
	int N;
	scanf("%d", &N);

	int map[N][64];
	bool visit[N][64] = {false, };
	for(int i = 0; i<N; i++)
	{
		for(int j = 0; j<N; j++)
		{
			scanf("%d", &map[i][j]);
		}
	}
	
	int z1 = 0;
	int z2 = 0;
	int c = dfs(map, visit, z1, z2, N-1);
	if(c > 0)
		printf("HaruHaru");
	else
		printf("Hing");	
	
	return 0;
}
