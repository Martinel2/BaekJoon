#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void AC0(char *p)
{
	int plen = strlen(p);
	int j;
	bool r = false;
	for(j = 0; j<plen; j++)
	{
		if(p[j] == 'D')
			break;
	}
	if(j<plen)
		printf("error\n");
	else
	{
		printf("[]\n");
	}	
}

void AC(char *p, int *a, int front, int behind, int n)
{
	int plen = strlen(p);
	int j;
	bool r = false;
	for(j = 0; j<plen; j++)
	{
		if(p[j] == 'R') //뒤집기 
		{
			r = !r;
			int tmp = front;
			front = behind;
			behind = tmp;
		}
		else if(p[j] =='D')// 버리기 
		{
			if(a[front] != 0)
			{
				n--;
				a[front] = 0;
				if(!r) // 짝수로 뒤집음  == 원상태 
				{
					front++; 
				}
				else // 홀수로 뒤집음  == 뒤집힌 상태
				{
					front--; 
				} 
			}
			else
			{
				printf("error\n");
				break;
			}
		}
	}
	if(j == plen) // 끝까지 돎 
	{
		printf("[");
		if(!r)
		{
			for(int i = front; i<=behind; i++)
			{
				if(a[i] == 0)
					break;
				else
				{
					if(i<behind && a[i+1] != 0)
						printf("%d,", a[i]);
					else
						printf("%d", a[i]);	
				}	
			}
		}
		else
		{
			
			for(int i = front; i>=behind; i--)
			{
				if(a[i] == 0)
					break;
				else
				{
					if(i>behind && a[i-1] != 0)
						printf("%d,", a[i]);
					else
						printf("%d", a[i]);	
				}	
			}
		}
		printf("]\n");
	}
}

int main()
{
	int T;
	scanf("%d", &T);

	while(T--)
	{
		char p[100001];
		scanf("%s", &p);
		fgetc(stdin);
		
		int n;
		scanf("%d", &n);

		
		char xi[300005];
		scanf("%s", &xi);
		fgetc(stdin);

		if(n == 0)
		{
			AC0(p);
		}
		else
		{	
			char *t = strtok(xi, "[,]");
			int a[n];
			int front = 0;
			int behind = -1;
			while(t != NULL)
			{
				a[++behind] = atoi(t);
				t = strtok(NULL, "[,]");
			}
		
			AC(p,a,front,behind,n);
		}
	}
	
	return 0;
}

