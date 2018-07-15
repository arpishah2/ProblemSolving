package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
