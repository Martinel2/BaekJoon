#include <stdio.h>

int main(){
	int T;
	scanf("%d",&T);
	
	while(T--)
	{
		int chick,leg;
		scanf("%d %d", &leg, &chick); // 다리갯수, 닭의 수 
		int orileg = (chick*2); //있어야할 다리 수 
		printf("%d %d\n", orileg-leg, chick-(orileg-leg)); // 잘린 닭의 수 = 전체 다리 수 - 다리 수
		
	}
	return 0; 
}
