#include <stdio.h>

int main(){

    int N;
    scanf("%d", &N);
    int max=-1, min=1001;
    for(int i=0; i<N; i++)
    {
        int a;
        scanf("%d", &a);
        if(max<a)
            max =a;
        if(min>a)
            min = a;

    }
    printf("%d", max-min);
    return 0;
}
