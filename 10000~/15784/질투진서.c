#include <stdio.h>


int main(){

    
    int N;
    int x,y,i,j;
    scanf("%d %d %d", &N,&x,&y);
    int a[N][N];
    x=x-1;
    y=y-1;
    for(i=0; i<N; i++){
        for(j=0; j<N; j++){
            scanf("%d", &a[i][j]);
        }
    }
    int jin=a[x][y];
    for(i=0; i<N; i++){
        if(jin<a[i][y])
            break;
    }
    for(j=0; j<N; j++)
    {
         if(jin<a[x][j])
             break;
    }
    
    if(i<N || j<N)
        printf("ANGRY");
    else
        printf("HAPPY");
    return 0;
}
