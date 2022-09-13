#include <stdio.h>

int main()
{    
    int a1,a2,a3,AP,GP;
    scanf("%d %d %d",&a1,&a2,&a3);
    while(a1 != 0 || a2 != 0 || a3 != 0)
    {    
        AP = a2-a1;
        GP = a2/a1;
        if(a2+AP == a3)
        {
            printf("AP %d\n",a3+AP);
        
        }//AP
        else
            printf("GP %d\n",a3*GP);
        scanf("%d %d %d",&a1,&a2,&a3); 
    }
    return 0;
}
