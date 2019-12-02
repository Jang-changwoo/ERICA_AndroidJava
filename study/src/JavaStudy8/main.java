package JavaStudy8;

public class main {
	public static int[] merge(int[] arr1, int[] arr2) {
		// fill here!
		int index1 = 0;
		int index2 = 0;
		int[] merged = new int[arr1.length + arr2.length];

		for (int index = 0; index < merged.length; index++) {
			if (index2 >= arr2.length || arr1[index1] < arr2[index2]) {
				merged[index] = arr1[index1];
				index1++;
			} else {
				merged[index] = arr2[index2];
				index2++;
			}
		}

		return merged;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 4, 8, 16 };
		int[] arr2 = { 3, 6, 9, 12 };
		int[] merged = merge(arr1, arr2);
		for (int i = 0; i < merged.length; i++) {
			System.out.println(merged[i]);

		}

	}
}
