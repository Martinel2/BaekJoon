#include <stdio.h>

int main(){

    int t;
    scanf("%d", &t);
    
    while(t--)
    {
        int sum1=0,sum2=0;
        int N,i;
        scanf(" %d", &N);
        char p1,p2;
        for(i=0; i<N; i++)
        {
            scanf(" %c %c", &p1, &p2);
            
            if(p1==p2)
                continue;
            
            else if(p1 == 'R' && p2 == 'S')
                sum1++;
            else if(p1 == 'S' && p2 == 'P')
                sum1++;
            else if(p1 == 'P' && p2 == 'R')
                sum1++;
            
            else if(p1 == 'S' && p2 == 'R')
                sum2++;
            else if(p1 == 'R' && p2 == 'P')
                sum2++;
            else if(p1 == 'P' && p2 == 'S')
                sum2++;
            
           
        }
        if(sum1>sum2)
            printf("Player 1\n");
        else if(sum1<sum2)
            printf("Player 2\n");
        else
            printf("TIE\n");
    }
    return 0;
}
