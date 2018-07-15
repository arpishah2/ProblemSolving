package HashMap;

public class HashMap {

	int size;
	HashEntry hashmap[];
	
	public HashMap() {
		size = 5;
		hashmap = new HashEntry[size];
	}

	public HashMap(int size, HashEntry[] hashmap){
		this.size = size;
		this.hashmap = hashmap;
	}
	
	public void put(HashEntry hashEntry){
		int index = hashCode(hashEntry.key);
		
		if(hashmap[index] != null) {
			//collision
			index++;
			index = index%size;
		}
		hashmap[index] = hashEntry;
	}
	
	public int hashCode(int key){
		int index = key%size;
		return index;
	}
	
	public HashEntry get(int key){
		int index = hashCode(key);
		HashEntry temp = hashmap[index];
		if(temp.key == key){
			return temp;
		}else{
			index++;
			index = index%size;
			return hashmap[index];
		}
	}
	
	public static void main(String[] args){
		HashMap h1 = new HashMap();
		
		
	}
	

}
