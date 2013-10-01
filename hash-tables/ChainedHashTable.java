import java.util.LinkedList;
import java.util.Date;
import java.util.Calendar;

public class ChainedHashTable<K, V> {
	
	private Chain<V>[] rows;
	private int m;

	public HashTable(int size){
		rows = new Chain[size];
		this.m = size;
	}

	public void insert(K k, V v){
		int key = hash(k);
		if(rows[key]==null){
			rows[key] = new Chain<V>();
		} 
		rows[key].put(key, v);
	}

	public V get(K k) {
		int key = hash(k);
		Chain<V> chain = rows[key];
		if(chain!=null){
			return chain.get(key);
		} 
		return null;
	}

	// int
	private int hash(int k){
		return k % m;
	}

	// string
	private int hash(String k){
		int total = 0; 
		for(int i=0;i<k.length();i++){
			total += k.charAt(i);
		}
		return (total % m);
	}

	// anything else
	private int hash(Object k){
		String key = k.toString();
		return hash(key);
	}

	private class Chain<V> {
		private ChainNode<V> head;

		private void put(int key, V v){
			if(head==null){
				head = new ChainNode<V>(key, v);
			} else {
				ChainNode<V> newHead = new ChainNode<V>(key, v);
				newHead.next = head;
				head.prev = newHead;
				head = newHead;
			}
		}

		private V get(int key) {
			ChainNode<V> currentNode = head;
			while(currentNode!=null){
				if(currentNode.getKey()==key){
					return currentNode.getValue();
				} 
			}
			return null;
		}
	}

	private class ChainNode<V> {
		private int key;
		private V value;

		private ChainNode<V> prev;
		private ChainNode<V> next;

		private ChainNode(int key, V value) {
			this.key = key;
			this.value = value; 
		}

		private int getKey(){
			return this.key;
		}

		private V getValue(){
			return this.value;
		}

		private ChainNode<V> getPrev(){
			return this.prev;
		}
		private void setPrev(ChainNode<V> prev){
			this.prev = prev;
		}

		private ChainNode<V> getNext(){
			return this.next;
		}
		private void setNext(ChainNode<V> next) {
			this.next = next;
		}
	}

}
