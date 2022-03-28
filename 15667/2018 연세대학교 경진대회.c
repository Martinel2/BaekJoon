// 대형+중형+소형 = 1 + K + K*K ex) 21 = 1 + 4 + 4*4(16)

#include <stdio.h>

int main(){
    
    int f;
    scanf("%d", &f);
    int cnt;
    while(cnt+(cnt*cnt)+1 < f)
    {
        cnt++;
    }
    printf("%d", cnt);
    
    return 0;
}
