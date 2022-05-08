#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int dfs(int map[][64], bool visit[][64], int x, int y, int N)
{
	if(x>N || y>N) //������ �Ѿ�� ���ӿ��� 
		return 0;
	else
	{
		int z = map[x][y];
		visit[x][y] = true;
		if(z == -1) // ������ ���� 
			return 1;
		else
		{
			if(x+z<=N && y+z<=N) //�Ѵ� Ž���ؾ��� 
			{
				if(!visit[x+z][y] && !visit[x][y+z]) // �Ѵ� �������� 
					return dfs(map, visit, x+z, y, N) + dfs(map, visit, x, y+z, N);
				else if(!visit[x+z][y]) // �Ʒ��δ� ���� 
					return dfs(map, visit, x+z, y, N);
				else if(!visit[x][y+z]) // ���������δ� ���� 
					return dfs(map, visit, x, y+z, N);
				else // ���ٸ��� 
					return 0;
			}
			else if(x+z<=N) //�Ʒ��δ� ���� 
			{
				if(!visit[x+z][y])
					return dfs(map, visit, x+z, y, N);
				else 
					return 0;	
			}
			else if(y+z<=N)// ���������δ� ���� 
			{
				if(!visit[x][y+z])
					return dfs(map, visit, x, y+z, N);
				else 
					return 0;	
			}
			else // ������ ���� 
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
