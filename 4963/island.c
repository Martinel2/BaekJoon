#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void dfs(int map[][50], bool visit[][50], int x, int y, int w, int h)
{
	visit[y][x] = true;
	if(x-1>=0) //<-
	{
		if(map[y][x-1] == 1 && !visit[y][x-1])
			dfs(map,visit,x-1,y,w,h);
	}
	if(y-1>=0)//down
	{
		if(map[y-1][x] == 1 && !visit[y-1][x])
			dfs(map,visit,x,y-1,w,h);
	}
	if(y+1<h) // up
	{
		if(map[y+1][x] == 1 && !visit[y+1][x])
			dfs(map,visit,x,y+1,w,h);
	}
	if(x+1<w) // ->
	{
		if(map[y][x+1] == 1 && !visit[y][x+1])
			dfs(map,visit,x+1,y,w,h);
	}
	if(x-1>=0 && y+1<h) // <- up
	{
		if(map[y+1][x-1] == 1 && !visit[y+1][x-1])
			dfs(map,visit,x-1,y+1,w,h);
	}
	if(x-1>=0 && y-1>=0) // <- down
	{
		if(map[y-1][x-1] == 1 && !visit[y-1][x-1])
			dfs(map,visit,x-1,y-1,w,h);
	}
	if(x+1<w && y+1<h) // -> up
	{
		if(map[y+1][x+1] == 1 && !visit[y+1][x+1])
			dfs(map,visit,x+1,y+1,w,h);
	}
	if(x+1<w && y-1>=0) // -> down
	{
		if(map[y-1][x+1] == 1 && !visit[y-1][x+1])
			dfs(map,visit,x+1,y-1,w,h);
	}
}

int main()
{
	int w,h;
	scanf("%d %d", &w, &h);
	
	while(w != 0 && h !=0)
	{
		int map[h][50] = {0, };
		bool visit[h][50]  = {false, };
		int is = 0;
		int x = 0;
		int y = 0;
		for(int i = 0; i<h; i++) //지도입력 
		{
			for(int j = 0; j<w; j++)
			{
				scanf("%d", &map[i][j]);
			}
		}
		for(int i = 0; i<h; i++) //지도입력 
		{
			for(int j = 0; j<w; j++)
			{
				if(map[i][j] == 1 && !visit[i][j])
				{
					x = j;
					y = i;
					is++;
					dfs(map,visit,x,y,w,h);
				}
			}
		}
		printf("%d\n", is);
		scanf("%d %d", &w, &h);
	}
	
	return 0;
}

