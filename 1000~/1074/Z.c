#include <stdio.h>

int pow(int x, int n)
{
	int i;
	int num = 1;
	for(i = 1; i<=n; i++)
	{
		num = num*x;
	}
	return num;
}
int cnt = 0;
void Z(int xst, int xend, int yst, int yend, int x, int y, int n, int i)
{//2사분면 
	int power = pow(2,n-i);
	
	if( (xst <= x && x <= xst + power-1) && (yst <= y && y <= yst + power-1) )
	{
		if(xst == x && yst == y)
			return;
		else
			Z(xst, xst+power, yst, yst+power, x, y, n, i+1);		
	}
	else if( (x >= xst + power-1) && (yst <= y && y <= yst + power-1) )
	{//1사분면 
		cnt = cnt + power*power;
		if(xend + power-1 == x && yst == y)
			return;
		else
			Z(xst+power,power*2-1,yst,yst+power,x,y,n,i+1);	
	}
	else if( (xst <= x && x <= xst + power-1) && (y >= yst + power-1) )
	{//3사분면 
		cnt = cnt + (power*power)*2;
		if(xst == x && yst + power-1 == y)
			return;
		else
			Z(xst,xst+power,yst+power,power*2-1,x,y,n,i+1);
	}
	else if( (x >= xst + power-1) && (y >= yst + power-1) )
	{//4사분면 
		cnt = cnt + (power*power)*3;
		if(xst + power -1 == x && yst + power -1 == y)
			return;	
		else
			Z( xst+power, power*2-1, yst+power, power*2-1, x,y,n,i+1);
	}
}


int main()
{
	
	int n,x,y;
	
	scanf("%d %d %d", &n, &y, &x);
	
	Z(0,0,0,0,x,y,n,1);
	printf("%d", cnt);
	
	return 0;
} 
