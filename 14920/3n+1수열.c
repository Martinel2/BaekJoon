/*   C(n+1) = C(n)/2     (C(n)ÀÌ Â¦¼öÀÏ ¶§)
            = 3*C(n)+1   (C(n)ÀÌ È¦¼öÀÏ ¶§)
*/

#include <stdio.h>

int main(){
    
    int n;
    scanf("%d", &n);
    int cnt=1;
    
    while(n != 1)
    {
        if(n%2==0) // Â¦¼ö
        {
            n = n/2;
        }
        else // È¦¼ö
        {
            n = 3*n+1;
        }
        cnt++;
    }
    printf("%d", cnt);
    
    
    
    return 0;
}
