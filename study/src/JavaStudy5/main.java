package JavaStudy5;

// 입력되는 값들중에 n번째로 큰 값을 출력한다.

class main {
	public static int kthbig(int[] arr, int k) {
		//입력된 수들의 개수
		int size = arr.length;
		int[] rank = new int[size];
		for (int i = 0; i < size; i++) {
			//매번 n_largerthan_me를 초기화
			int n_largerthan_me = 0;
			for (int j = 0; j < size; j++) {
				//i번째보다 j번째 수가 더크면 1씩 더해준다
				if (arr[i] < arr[j]) {
					n_largerthan_me++;
				}
			}
			// i번째 수의 크기 순위 입력
			rank[i] = n_largerthan_me;
		}
		for (int i = 0; i < size; i++) {
			//k번째의 크기의 수 찾기
			if (rank[i] == k - 1)
				return arr[i];
		}
		//못찾았을때 리턴값 -1
		return -1;
	}

	public static void main(String[] args) {
		//입력값
		int[] arr = { 1, 4, 2, 5, 11, 9, 18 };
		System.out.println(kthbig(arr, 2));
	}
}
