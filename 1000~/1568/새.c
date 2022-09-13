#include <stdio.h>

int main(){

    int N;
    scanf("%d",&N);
    int cnt=0;
    int song=1;
    while(N!=0){
        if((N-song) >=0)
            N = N-song;
        else{
            song=1;
            N=N-song;
        }
        song++;
        cnt++;
    }
    printf("%d",cnt);
    
    return 0;
}
