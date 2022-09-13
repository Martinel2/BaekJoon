#include <stdio.h>

int main(){

    int N,M;
    scanf("%d %d", &N,&M);
    
    int a;
    int m1=0,m2=0;
    
    for(int i=0; i<N; i++){
        scanf("%d", &a);
        if(m1<a)
            m1 = a;
    }
    for(int i=0; i<M; i++){
        scanf("%d", &a);
        if(m2<a)
            m2 = a;
    }
    printf("%d", m1+m2);
    return 0;
}
