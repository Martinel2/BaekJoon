#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//���ڼ� ������� �׳� 3���� ���� �ȴٰ� �Ѵ�...


int main()
{
    char hong[21];//���̵�
    scanf("%s", hong);
    
//    int len = strlen(hong);//���̵� ����üũ
//   int n,i,j;//n�� ���̵��� ����
    
/*    if(len<=3)
        n=1;
    else if(len>3 && len<=8)
        n=2;
    else if(len>8 && len<=13)
        n=3;
    else if(len>13 && len<=18)
        n=4;
    else
        n=5;
*/    
    for(int i=0; i<3; i++)
    {
        for(int j=0; j<3; j++)
        {
            if(i==1 && j==1){
                printf(":%s:",hong);
            }
            else
                printf(":fan:");
        }
        printf("\n");
    }  
    
    return 0;
}
        if(N==0)
        {
            printf("1");
        }
    }
    
	return 0; 
}
