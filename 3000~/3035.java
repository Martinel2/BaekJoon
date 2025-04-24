import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		List<String> list = new ArrayList<>();
		String[] strArr = sc.nextLine().split(" ");
		int[] arr = new int[strArr.length];

		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(strArr[i]);

		while (sc.hasNextLine()) {
			String book = sc.nextLine();
			if (book == "")
				break;
			list.add(book);
		}
		int x = arr[1] * arr[3] / list.get(0).length(); // x
		int y = arr[0] * arr[2] / list.size(); // y

		for (int i = 0; i < list.size(); i++) { // row
			String str = "";
			for (int j = 0; j < list.get(0).length(); j++) { // col
				for (int k = 0; k < x; k++) // copy
					str += list.get(i).charAt(j);
			}
			for (int k = 0; k < y; k++) { // copy
				System.out.print(str);
				if (k != y || k != 0) // \n
					System.out.println();
			}
		}
	}
}
