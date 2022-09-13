#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
#include <functional>         // greater 사용 위해 필요  
#include <string>
#include <map>
#include <math.h>
using namespace std;
 
int main() {
    std::ios::sync_with_stdio(false); cin.tie(0);
 
    int n=3;
    vector<int> arr(n);
 
    for(int i=0; i<n; i++)
        cin >> arr[i];
 
    sort(arr.begin(), arr.end());
 
    int b = arr[2] - arr[1];
    int a = arr[1] - arr[0];
 
    if (b == a)
        cout << arr[2] + b << endl;
    else if (b > a)
        cout << arr[2] - a << endl;
    else
        cout << arr[1] - b << endl;
    return 0;
}

