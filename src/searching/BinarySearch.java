package searching;

public class BinarySearch {

	private void binarySearchUsingIteration(int[] arr, int value) {

		int size = arr.length;
		int beg = 0, end = size, mid = 0;

		while (beg <= end) {

			mid = (beg + end) / 2;

			if (arr[mid] == value) {
				System.out.println("Value " + value + "  found at index: " + mid);
				return;
			} else if (arr[mid] > value) {
				end = mid - 1;
			} else {
				beg = mid + 1;
			}
		}

		System.err.println("Value " + value + "  not found at any index");

	}

	private void binarySearchUsingRecursion(int[] arr, int value, int beg, int end) {

		int mid = (beg + end) / 2;

		if(beg>end){
			System.err.println("Value " + value + "  not found at any index");
			return;
		}
			
		if (arr[mid] == value) {
			System.out.println("Value " + value + "  found at index: " + mid);
			return;
		} else if (arr[mid] > value) {
			binarySearchUsingRecursion(arr, value, beg, mid - 1);
		} else {
			binarySearchUsingRecursion(arr, value, mid + 1, end);
		}

	}

	public static void main(String args[]) {

		BinarySearch bsearch = new BinarySearch();
		int[] arr = new int[] { 1, 28, 46, 54, 88, 140, 141 };
		bsearch.binarySearchUsingIteration(arr, 28);
		bsearch.binarySearchUsingIteration(arr, 29);
		bsearch.binarySearchUsingIteration(arr, 141);
		bsearch.binarySearchUsingRecursion(arr, 28, 0, arr.length);
		bsearch.binarySearchUsingRecursion(arr, 29, 0, arr.length);
		bsearch.binarySearchUsingRecursion(arr, 141, 0, arr.length);

	}

}
