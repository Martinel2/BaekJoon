#include <stdio.h>

int main(){
    
    int T;
    scanf("%d", &T);
    
    while(T--)
    {
        int max,min;
        int N;
        scanf("%d", &N);
        int num;
        for(int i=0; i<N; i++)
        {
            scanf("%d", &num);
            if(i==0)
            {
                max=num;
                min=num;
            }
            if(max<num)
                max = num;
            if(min>num)
                min = num;
        }
        printf("%d %d\n", min,max);

    }

    return 0;
}
