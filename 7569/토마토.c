#include <stdio.h>
#include <stdlib.h>
#define MAX 9000000

int front= -1,rear = -1;
int res = 0;
int d;
int to[101][101][101];
int dx[6] = {1,0,-1,0,0,0};
int dy[6] = {0,1,0,-1,0,0};
int dz[6] = {0,0,0,0,1,-1};
typedef struct queue{
	int x,y,z;
}queue;

struct queue Q[MAX];


void push(int z, int y, int x)
{
	rear=(rear+1)%MAX;
	Q[rear].x = x;
	Q[rear].y = y;
	Q[rear].z = z;
}

void pop()
{
	Q[front].x = -1;
	Q[front].y = -1;
	Q[front].z = -1;
}

int BFS(int H, int N, int M)
{
	int nx,ny,nz;
	while(rear != front){
			front=(front+1)%MAX;
			int x = Q[front].x;
			int y = Q[front].y;
			int z = Q[front].z;
			pop();
			
		for(d = 0; d<6; d++)
		{
			nx = x+dx[d];
			ny = y+dy[d];
			nz = z+dz[d];
			
			if(0<=z && z<H && 0<=y && y<N && 0<=x && x<M)
			{
				if(to[z][y][x] == 0)
					push(z,y,x);
			}
		}	
    }
	int i,j,k;
	for(k=0; k<H; k++)
	{
	
		for(i=0; i<N; i++)
		{
			for(j =0; j<M; j++)
			{
				if(to[k][i][j] == 0){
					return -1;
				}
            	if(res<to[k][i][j]){
					res = to[k][i][j];
				}
			}
		}
	}
    return res-1;
}

int main(){
	
	int M,N,H;
	scanf("%d %d %d", &M,&N, &H);
	
	int i,j,k;
	for(int k = 0; k<H; k++)
	{
		for(i=0; i<N; i++)
		{
			for(j =0; j<M; j++)
			{
				scanf("%d", &to[k][i][j]); // 토마토 정보 주어짐 
				if(to[k][i][j] == 1){
					push(k,i,j);
				}
			}
		}
	}
	printf("%d", BFS(H,N,M));	
	
	return 0;
}

