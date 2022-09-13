#include <stdio.h>

//더 큰 사람이 승자
int main()
{
    int N; //라운드 수
    scanf("%d", &N);
    
    int wina =0, winb =0;
    while(N--)
    {
        int a,b;
        scanf("%d %d",&a,&b);
        
        if(a>b) //무승부는 둘다 
            wina++;
        else if(a<b)
            winb++;
    }
    printf("%d %d",wina,winb);
}
