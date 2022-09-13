#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int compare(const void *a, const void *b)
{
	int num1 = *(int*)a;
	int num2 = *(int*)b;
	
	if(num1 < num2)
		return -1;
	if(num1 > num2)
		return 1;
	
	return 0;		
}

int main()
{
	int N;
	scanf("%d", &N);
	
	if(N == 1)
	{
		int c;
		scanf("%d", &c);
		printf("%d\n%d\n%d\n%d\n", c, c,c,0); 
	}
	else{
		int a[N];
		int cnt[8001] = {0,};
		int sum = 0;
		int mc=4001;
		int max = 0;
		
		for(int i = 0; i<N; i++)
		{
			scanf("%d", &a[i]);
			cnt[a[i] +4000]++;
		
			sum+= a[i];
			
			if(mc == 4001 || mc == a[i]){
				mc = a[i];
				max++;
			}
			else if(max < cnt[a[i] + 4000])
			{
					mc = a[i];
					max = cnt[a[i] + 4000];
			}
	 
		}	
		
		int ccnt = 0;
		for(int i = 0; i<=8000; i++)
		{
			if(max == cnt[i])
			{
				mc = i-4000;
				ccnt++;
			}
			if(ccnt == 2)
				break;
		}
		
		qsort(a, sizeof(a)/sizeof(int), sizeof(int), compare);
		int avr  = floor( ( (double)sum/(double)N )+0.5);
		int mid = a[ (int)floor( double(N/2) ) ];
		int range = (a[N-1]-a[0]);
		printf("%d\n%d\n%d\n%d\n", avr, mid,mc,range); 
	}
	return 0;
}
