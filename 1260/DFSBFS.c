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

void dfs(int x) // ��� dfs
{
	int i = 0;

	visit[x] = 1; // �湮 ǥ��
	printf("%d ", x); // �湮�� �� ���

	for (i = 1; i <= N; i++)
		if (arr[x][i] == 1 && visit[i] == 0)
		{
			
			dfs(i);
		}
	if (i == N) return; // i�� N���� ��� ���� �˻��ߴٸ� ��ȯ
}

void bfs(int x)
{
	queue<int> q; // ť ����
	int i = 0;

	q.push(x); // ������ ť�� ����

	while (!q.empty()) // ť�� ���Ұ� �ϳ��� ���� �� Ż��
	{
		int next_x = q.front(); // ť �Ǿ��� ���Ҹ� ���� Ž���� ������ ����
		visit[next_x] = 1; // �湮 ǥ��
		printf("%d ", next_x); // �湮 �� �� ���
		q.pop(); // ť �� �� ������ ����

		for (i = 1; i <= N; i++)
			if (arr[next_x][i] == 1 && visit[i] == 0)
			{
				//next_x���� i���� ����Ǿ��ְ� i���� �湮����� ���ٸ� 
				q.push(i); // ť�� i�� ����
				visit[i] = 1; // i���� �̸� �湮ǥ��(�̸� ���� ������ �ߺ����� �湮�� ���� ����)
			}
	}
}

int main()
{
	scanf("%d %d %d", &N, &M, &V);

	for (int i = 0; i < M; i++)
	{
		scanf("%d %d", &u, &v);
		// arr = �� ���� ���� ������ �˷��ִ� ���
		arr[u][v] = 1;
		arr[v][u] = 1;
	}

	dfs(V);

	printf("\n");
	memset(visit, 0, sizeof(visit)); // �湮��� �ʱ�ȭ

	bfs(V);



}

