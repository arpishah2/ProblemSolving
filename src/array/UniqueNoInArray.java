package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



/*
 * 
 * Finding unique numbers from sorted array in less than O(n)
 * 
 * Divide and conquer:
 * look at the first and last element of a sorted sequence (the initial sequence is data[0]..data[data.length-1]).
 * If both are equal, the only element in the sequence is the first (no matter how long the sequence is).
 * If the are different, divide the sequence and repeat for each subsequence.
 * Solves in O(log(n)) in the average case, and O(n) only in the worst case (when each element is different).
 */
public class UniqueNoInArray {

	public void getUniqueNoInArrayUsingHashMap(int[] arr) {
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		
		//insert elements in hmap with count
		
		for(int i=0; i<arr.length; i++){
			if(hmap.containsKey(arr[i])){
				hmap.put(arr[i], hmap.get(arr[i])+1);
			}else{
				hmap.put(arr[i], 1);
			}
		}
		
		//iterate over hashmap to get keys for whom values is 1
		Iterator it = hmap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
			if(entry.getValue().equals(1)){
				System.out.print(entry.getKey()+" ");
			}
		}
	}


	public static void main(String[] args) {
		
		UniqueNoInArray uni = new UniqueNoInArray();
		int[] arr = new int[]{ 1,28,46,46,54,46,7,88,1,140 };
		uni.getUniqueNoInArrayUsingHashMap(arr);
	}

}
