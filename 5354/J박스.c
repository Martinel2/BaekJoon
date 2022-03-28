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
                if(i==1 || i == B) //위 아래 테두리
                {
                    printf("#");
                }
                else
                {
                    if(j==1 || j==B) //양옆 테두리
                    {
                        printf("#");
                    }
                    else
                        printf("J"); //안은 J로 채우기
                }
            }
            printf("\n");
        }
        printf("\n");
    }
    return 0;
}
