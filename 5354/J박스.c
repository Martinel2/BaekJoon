#include <stdio.h>

int main()
{
    int T;
    scanf("%d",&T);
    
    while(T--)
    {
        int B,i,j;
        scanf("%d",&B);
        for(i=1; i<=B; i++)
        {
            for(j=1; j<=B; j++)
            {
                if(i==1 || i == B) //�� �Ʒ� �׵θ�
                {
                    printf("#");
                }
                else
                {
                    if(j==1 || j==B) //�翷 �׵θ�
                    {
                        printf("#");
                    }
                    else
                        printf("J"); //���� J�� ä���
                }
            }
            printf("\n");
        }
        printf("\n");
    }
    return 0;
}
