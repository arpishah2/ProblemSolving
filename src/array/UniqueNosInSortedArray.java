package array;

import java.util.ArrayList;

public class UniqueNosInSortedArray {
	
	public void getUniqueNosInSortedArrayLessThanOn(int[] arr, int beg, int end, ArrayList<Integer> result, boolean skipValue) {
		if(arr.length == 0){
			return;
		}
		
		if(arr[beg] == arr[end]){
			if(!skipValue){
				result.add(arr[beg]);
			}
		} else{
			int mid = (beg+end)/2;
			getUniqueNosInSortedArrayLessThanOn(arr, beg, mid, result, skipValue);
			getUniqueNosInSortedArrayLessThanOn(arr, mid+1, end, result, arr[mid]==arr[mid+1]);
		}
	}
	
	public static void main(String[] args) {
		UniqueNosInSortedArray uni = new UniqueNosInSortedArray();
		int[] arr = new int[]{ 1,1,1,1,2,2,2,2,2,3,3,3,3,4,8,8,9,9,11,13,15 };
		ArrayList<Integer> result = new ArrayList<Integer>();
		uni.getUniqueNosInSortedArrayLessThanOn(arr, 0, 20, result, false);
		System.out.println(result);
	}
}
