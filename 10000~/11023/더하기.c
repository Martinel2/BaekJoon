#include <stdio.h>
#include <string.h>

int pow(int num, int ex)//10�����ϱ��
{
	int i;
	int n = num;
	for(i = 1; i<ex; i++)
	{
		num = num*n;
	}
	return num;
}

int main(){
	char a[601];
	
	scanf("%[^s\n]", &a);
	
	char *ptr = strtok(a," ");
	int sum = 0;
	while(ptr != NULL)
	{
		int len = strlen(ptr);// ���ڸ� �� ���� �ľ� 
		int ber=0,i; //ber = ���������� ���ڹޱ� 
		for(i = 0; i<len; i++)// ������ ġȯ 
		{
			if(i == len-1){//���ڱ��� ���� �������������Ƿ� ex) 10�� 1�� ��������
				ber = ber + (ptr[i]-'0');
			}
			else
			{
				ber = ber + (ptr[i]-'0')*pow(10,len-1-i);
			}
		}
		sum = sum + ber;
		ptr = strtok(NULL, " ");
	}
	printf("%d", sum);
	
	return 0;
}
