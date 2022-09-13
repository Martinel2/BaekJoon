#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b)
{
    if(*(int*)a > *(int*)b)
        return 1;
    else if(*(int*)a < *(int*)b)
        return -1;
    else
        return 0;
    
}

int main(){

    int T;
    int i=1;
    scanf("%d",&T);
    while(T--){
        int a[3];
        scanf("%d %d %d", &a[0], &a[1], &a[2]);
        qsort(a,3,sizeof(int),compare);
        printf("Scenario #%d:\n",i);
        if(a[0]*a[0] + a[1]*a[1] == a[2]*a[2]){
            printf("yes\n\n");
        }
        else
            printf("no\n\n");
        i++;
    }
    
    return 0;
}
