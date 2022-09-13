#include <stdio.h>
#include <string.h>

int main(){

    char ah[1000];
    char dah[1000];
    
    scanf("%s", ah);
    scanf("%s", dah);
    if(strlen(ah) >= strlen(dah))
        printf("go");
    else
        printf("no");
    
    
    return 0;
}
