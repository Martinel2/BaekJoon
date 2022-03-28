#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int a,b;
    scanf("%d %d",&a, &b);
    int sum =0;    
    int d = b%4;//¨ù¨ù¡¤IAU
    int c = a%4;
    if(d==0)
        d=4;
    if(c==0)
        c=4;
    int row = abs(c-d);
    int m = a/4;//¡Æ¢®¡¤IAU
    int n = b/4;
    if(a%4 ==0)
        m--;
    if(b%4 ==0)
        n--;
    int col = abs(m-n);
    sum = row+col;
    printf("%d",sum);
    
    return 0;
}
