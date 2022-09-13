#include <stdio.h>

int main(){
    
    int n,m;
    scanf("%d", &n);//조사한 시간
    scanf("%d", &m); //처음 조사시에 존재하고있는 차량수
    int max = m;
    int sum = m;
    int i;
    for(i = 0; i<n; i++){
        int a,b;
        scanf("%d %d" , &a,&b); // a:들어온 차량수 b: 나간 차량수
        sum = sum + a - b ;
        if(sum>max)
            max = sum;
        else if(sum < 0)
        {
            printf("0");
            break;
        }
    }
    
    if(i == n)
        printf("%d", max);
    
    return 0;
}
