// t*t + t <= T

#include <stdio.h>

int main(){

    int n;
    scanf("%d", &n);
    
    while(n--){
        
        int d;
        scanf("%d", &d);
        
        int max=0;
        for(int i=1; i<d; i++){

            if(i*i + i <= d)
                max = i;
            else
                break;
        }
        printf("%d\n", max);
    }
    
    
    return 0;
}
