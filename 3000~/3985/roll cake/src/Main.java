import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int l = sc.nextInt();
    int n = sc.nextInt();
    int max_1 = -1;
    int max_2 = -1;
    int first = 0;
    int sec = 0;
    int[] arr = new int[l];
    for(int i = 0; i < n; i++) {
      int count = 0;
      int p = sc.nextInt();
      int k = sc.nextInt();
      if(k - p > max_1) {
        max_1 = k - p;                      //기대 최대값 찾기
        first = i + 1;
      }
      for(int j = p-1; j < k; j++) {
        if(arr[j] == 0) {
          arr[j] = 1;
          count++;
        }
      }
      if(count > max_2) {
        max_2 = count;                     //실제 최대값 찾기
        sec = i + 1;
      }
      
    }
    
    System.out.println(first);
    System.out.println(sec);

  }
}