#include <stdio.h>

// a3 = {(a2-a1) + a2 }
// a4 = {(a3-a2) + (a2-a1) + a3 (+2) } = 2*a3-a1 + 2
//a5 = {(a4-a3) + (a3-a2) + (a2-a1) + a4} = 2*a4 - a1
	
int main()
{
	int N;
	scanf("%d", &N);
	
	int d[N+1];
	d[1] = 1;
	d[2] = 3;
	
	for(int i =3; i<=N; i++)
	{
		if(i%2 == 0)
			d[i] = (2*d[i-1] - d[1] + 2)%10007;
		else
			d[i] = (2*d[i-1] - d[1])%10007;
	}
	
	printf("%d", d[N]);
	
	return 0;
}
