// t*t + t <= T

#include <stdio.h>

int main()
{
    int a,b; // a/b
    scanf("%d %d", &a,&b);
    while(a!=0 || b != 0)
    {
        int n = a/b;
        a = a%b;
        printf("%d %d / %d\n", n,a,b);
        
        scanf("%d %d", &a,&b);
    }
    return 0;
}
