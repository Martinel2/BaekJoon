#include <iostream>
#include <stdio.h>
#include <queue>
#include <memory.h>
#include <algorithm>
using namespace std;

int arr[1001][1001];
int visit[1001];
int N, M, V;
int u, v;

void dfs(int x) // 재귀 dfs
{
	int i = 0;

	visit[x] = 1; // 방문 표시
	printf("%d ", x); // 방문한 점 출력

	for (i = 1; i <= N; i++)
		if (arr[x][i] == 1 && visit[i] == 0)
		{
			
			dfs(i);
		}
	if (i == N) return; // i가 N개의 모든 점을 검사했다면 반환
}

void bfs(int x)
{
	queue<int> q; // 큐 생성
	int i = 0;

	q.push(x); // 시작점 큐에 삽입

	while (!q.empty()) // 큐에 원소가 하나도 없을 시 탈출
	{
		int next_x = q.front(); // 큐 맨앞의 원소를 다음 탐색할 점으로 지정
		visit[next_x] = 1; // 방문 표시
		printf("%d ", next_x); // 방문 한 점 출력
		q.pop(); // 큐 맨 앞 데이터 삭제

		for (i = 1; i <= N; i++)
			if (arr[next_x][i] == 1 && visit[i] == 0)
			{
				//next_x점과 i점이 연결되어있고 i점은 방문기록이 없다면 
				q.push(i); // 큐에 i점 삽입
				visit[i] = 1; // i점은 미리 방문표시(미리 하지 않으면 중복으로 방문할 수도 있음)
			}
	}
}

int main()
{
	scanf("%d %d %d", &N, &M, &V);

	for (int i = 0; i < M; i++)
	{
		scanf("%d %d", &u, &v);
		// arr = 각 점의 연결 정보를 알려주는 행렬
		arr[u][v] = 1;
		arr[v][u] = 1;
	}

	dfs(V);

	printf("\n");
	memset(visit, 0, sizeof(visit)); // 방문기록 초기화

	bfs(V);



}

