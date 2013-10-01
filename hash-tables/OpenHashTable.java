public class OpenHashTable<K, V> {
	
	private HashNode<K, V>[] rows;
	private int m;

	public OpenHashTable(int size){
		rows = new HashNode[size];
		this.m = size;
	}

	public int insert(K k, V v) throws Exception{
		int i = 0;
		while(i<m){
			int probe = linearProbe(k, i);
			if(rows[probe]==null){
				rows[probe] = new HashNode<K, V>(k, v);
				return probe;
			}
			i++;
		}
		throw new Exception("Hash table overflow");
	}

	public V get(K k) throws Exception{
		int i = 0;
		while(i<m){
			int probe = linearProbe(k, i);
			if(k.equals(rows[probe].getKey())){
				return rows[probe].getValue();
			}
			i++;
		}
		throw new Exception("Item not found");
	}

	// string
	private int linearProbe(K k, int i){
		String key = k.toString();
		int total = 0; 
		for(int j=0;j<key.length();j++){
			total += key.charAt(j);
		}
		return (hash(total) +i) % m;
	}

	// int
	private int hash(int k){
		return k % m;
	}

	public int size(){
		return m;
	}

	private class HashNode<K, V> {
		private K key;
		private V value;

		public HashNode(K key, V value){
			this.key = key;
			this.value = value;
		}

		public K getKey(){
			return this.key;
		}

		public V getValue(){
			return this.value;
		}
	}

}
