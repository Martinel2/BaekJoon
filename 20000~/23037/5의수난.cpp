#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int pow5(int num){
    int ret = 1;
    for(int i=0; i<5; i++)
        ret = ret*num;
    return ret;
}



int main(){

    char a[7];
    
    scanf("%s", &a);
    int len = strlen(a);
    int sum=0;
    for(int i =0; i<len; i++){
        
        int num = a[i]-'0';
        sum += pow5(num);
          
    }
    printf("%d", sum);

    return 0;
}
