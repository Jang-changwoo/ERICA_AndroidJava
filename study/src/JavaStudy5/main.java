package JavaStudy5;

//

class main {
	public static int kthbig(int[] arr, int k) {
		int size = arr.length;
		int[] rank = new int[size];
		for (int i = 0; i < size; i++) {
			int n_largerthan_me = 0;
			for (int j = 0; j < size; j++) {
				if (arr[i] < arr[j]) {
					n_largerthan_me++;
				}
			}
			rank[i] = n_largerthan_me;
		}
		for (int i = 0; i < size; i++) {
			if (rank[i] == k - 1)
				return arr[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 5, 11, 9, 18 };
		System.out.println(kthbig(arr, 2));
	}
}
