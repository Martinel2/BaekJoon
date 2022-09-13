#include <stdio.h>
#include <string.h>

int pow(int num, int ex)//10제곱하기용
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
		int len = strlen(ptr);// 몇자리 수 인지 파악 
		int ber=0,i; //ber = 정수형으로 숫자받기 
		for(i = 0; i<len; i++)// 정수로 치환 
		{
			if(i == len-1){//문자기준 수는 뒤집혀져있으므로 ex) 10은 1이 먼저보임
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
