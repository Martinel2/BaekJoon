#include <stdio.h>

int main() {
	int arr[100001] = {0,};
	int n, max = 0, result = 0;
	scanf("%d", &n);
	for(int i=0; i<n; i++) {
		scanf("%d", &arr[i]);
	}
	for(int i=0; i<n-1; i++) {
		if(arr[i] != 0) {
			int count = 1;
			while(arr[i] > arr[i+count]) {
				if(arr[i+count] == 0)
					break;
				arr[i+count] = 0;
				result ++;
				count ++;
			}
		}
		if (result > max) {
			max = result;
		}
		result = 0;
	}
	printf("%d", max);
}
