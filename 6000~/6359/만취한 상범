#include <stdio.h>

int main(){

    int T;
    scanf("%d", &T);
    
    while(T--){

        int n;
        scanf("%d", &n);
        bool room[n];
        for(int i = 1; i<=n; i++){
            room[i-1]=true;
        }
        for(int i = 2; i<=n; i++){
            for(int j=1; i*j<=n; j++)
            {
                if(room[i*j-1])
                    room[i*j-1] = false;
                else
                    room[i*j-1] = true;
            }
        }
        int sum=0;
        for(int i=0; i<n; i++)
        {
            if(room[i])
                sum++;
        }
        printf("%d\n", sum);
    }

    return 0;
}
