#include <stdio.h>

int main(){
	int T;
	scanf("%d",&T);
	
	while(T--)
	{
		int chick,leg;
		scanf("%d %d", &leg, &chick); // �ٸ�����, ���� �� 
		int orileg = (chick*2); //�־���� �ٸ� �� 
		printf("%d %d\n", orileg-leg, chick-(orileg-leg)); // �߸� ���� �� = ��ü �ٸ� �� - �ٸ� ��
		
	}
	return 0; 
}
