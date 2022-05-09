#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int compare(const void* first, const void* second)
{
	if(*(int*)first > *(int*)second)
		return 1;
	else if(*(int*)first < *(int*)second)
		return -1;
	else
		return 0;	
}

int dfs(char map[][26], bool visit[][25], int x, int y, int MAX)
{
	visit[x][y] = true;
	int sum = 1;
	if(x+1<=MAX)
	{
		if(!visit[x+1][y] && map[x+1][y] == '1')
			sum = sum + dfs(map,visit,x+1,y,MAX);
	}
	if(y+1<=MAX)
	{
		if(!visit[x][y+1] && map[x][y+1] == '1')
			sum = sum + dfs(map,visit,x,y+1,MAX);
	}
	if(x-1>=0)
	{
		if(!visit[x-1][y] && map[x-1][y] == '1')
			sum = sum + dfs(map,visit,x-1,y,MAX);
	}
	if(y-1>=0)
	{
		if(!visit[x][y-1] && map[x][y-1] == '1')
			sum = sum +	dfs(map,visit,x,y-1,MAX);
	}
	return sum;
}

int main()
{
	int N;
	scanf("%d", &N);
	
	char map[26][26];
	bool visit[25][25] = {false, };
	
	for(int i = 0; i<N; i++)
	{
		scanf("%s", &map[i]);
	}
	
	int cnt = 0;
	int h[13*25]= {0,};
	
	for(int i  = 0; i<N; i++)
	{
		for(int j = 0; j<N; j++)
		{
			if(map[i][j] == '1')
			{
				if(!visit[i][j])
				{
					h[cnt] = dfs(map,visit,i,j,N);
					cnt++;
				}
			}
		}
	}
	
	qsort(h,13*25,sizeof(int),compare);
	printf("%d\n", cnt);
	for(int i  = 0 ; i<13*25; i++)
	{
		if(h[i] != 0)
		{
			printf("%d\n", h[i]);
			
		}
	}
	return 0;
}


