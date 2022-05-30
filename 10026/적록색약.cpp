#include <stdio.h>
#include <string.h>
#define MAX 1001

int front = -1,rear = -1;
int res = 0;
int cres = 0;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
char Color[MAX][MAX];
char CColor[MAX][MAX];

typedef struct Q{
	int x,y;
};

Q que[MAX];

void add(int x, int y)
{
	rear = (rear+1)%MAX;
	que[rear].x = x;
	que[rear].y = y;
}



void BFS(char C, int N)
{
	while(rear != front){
		front = (front+1)%MAX;
		int x = que[front].x;
		int y = que[front].y;
		Color[x][y] = 'T';
		int i,nx,ny;
		for(i = 0; i<4; i++)
		{
			nx = x + dx[i];
			ny = y + dy[i];
		
			if(0<=nx && nx<N && 0<=ny && ny<N){
				if(Color[nx][ny] == C){
					add(nx,ny);
					Color[nx][ny] = 'T';
				}
			}
		}
	}
}


int BBFS(int N)
{
	int i,j;
	for(i = 0; i<N; i++){
		for(j = 0; j<N; j++)
		{
			if(Color[i][j] == 'R' || Color[i][j] == 'G' || Color[i][j] == 'B')
			{
				add(i,j);
				BFS(Color[i][j],N);
				res++;
			}
		}
	}
	
	return res;
}

void CBFS(char C, int N)
{
	while(rear != front){
		front = (front+1)%MAX;
		int x = que[front].x;
		int y = que[front].y;
		int i,nx,ny;
		for(i = 0; i<4; i++)
		{
			nx = x + dx[i];
			ny = y + dy[i];
		
			if(0<=nx && nx<N && 0<=ny && ny<N){
				if(CColor[nx][ny] == C){
					add(nx,ny);
					CColor[nx][ny] = 'T';
				}
				else if(C == 'R' && CColor[nx][ny] == 'G')
				{
					add(nx,ny);
					CColor[nx][ny] = 'T';
				}
				else if(C == 'G' && CColor[nx][ny] == 'R'){
					add(nx,ny);
					CColor[nx][ny] = 'T';
				}
			}
		}
		CColor[x][y] = 'T';
	}
}


int CCBFS(int N)
{
	int i,j;
	for(i = 0; i<N; i++){
		for(j = 0; j<N; j++)
		{
			if(CColor[i][j] == 'R' || CColor[i][j] == 'G' || CColor[i][j] == 'B')
			{
				add(i,j);
				CBFS(CColor[i][j],N);
				cres++;
			}
		}
	}
	
	return cres;
}



int main(){
	
	int N,i,j;
	scanf("%d", &N);
	
	for(i = 0; i<N; i++)
	{
		scanf("%s", Color[i]);
		strcpy(CColor[i],Color[i]);
	}
	printf("%d %d", BBFS(N), CCBFS(N));
	
	return 0;
}
