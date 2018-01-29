package class17HashMapImplementation;

import java.util.Arrays;

/**
 * 
 * @author guoyifeng
 * The implementation of custom HashMap<br>
 * HashMap:<br>
 * 		A collection that maps keys to values<br>
 * 		A map cannot contain duplicate keys<br>
 * 		Each key can map to one value<br>
 *	A collection that stores <key, value> pairs, such that no duplicate keys are allowed<br>
 *		In java:<br>
 *			HashMap<br>
 *			TreeMap<br>
 *			LinkedHashMap<br>
 *
 *	Common APIs:                       Average complexity                           Worst complexity   <br>
 *  V put(K key, V value)                     O(1)                                   O(n)              bad hashcode() make it degrade to LinkedList<br>
 *  V get(K key)                              O(1)                                   O(n)<br>
 *  V remove(K key)                           O(1)                                   O(n)<br>
 *  boolean containsKey(K key)                O(1)                                   O(n)<br>
 *  
 *  Set<Map.Entry<K, V>> entrySet() - get the set view of all the entries in the HashMap<br>
 *  Set<K> keySet() - get the set view of all the keys in the HashMap<br>
 *  Collection<V> values - get the collection view of all the valus in the HashMap<br>
 *  boolean containsValue(V value)            O(n)<br>
 *  void clear()<br>
 *  int size()<br>
 *  boolean isEmpty()<br>
 *  <br>
 *  HashMap allows one null key existing in the map while hashtable cannot<br>
 *  hashtable is thread safe but the performance is much worse than HashMap so we do not use hashtable any more<br>
 *  
 *  Implementation of HashMap:<br>
 *  	1. A table of buckets (an array of buckets), using the array index to denote each bucket<br>
 *  	2. For each <K, V>, it goes to one of the buckets, the bucket index is determined by a hash function<br>
 *         applied on key and the size of array<br>
 *         ******** hash function ********<br>
 *         int hashcode = hash(key)  hash() result is associated with key's memory address<br>
 *         int index = shorten(hashcode)  get a shorten hash which will be used as the location of key's information in the table(index)<br>
 *         		shorten(): int index = hashcode % array.length<br>
 *         
 *  Collision control:<br>
 *  	- collision: two keys map to the same bucket<br>
 *  	- solution strategy:<br>
 *  		1. separate chaining: the element (Entry) of each bucket is actually a single LinkedList<br>
 *          2. open addressing - put the <K, V> into the "next" available bucket<br>
 *          	next: linear/quadratic/exponential probing, hash again<br>
 *          	challenge: handling removed keys in the map, so java use separate chaining strategy<br>
 *          
 *  Rehashing factor:<br>
 *  	be called when too many <K,V> pairs in the map   --> high chance get collision<br>
 *      load factor: threshold of rehashing, if percentage pairs > load factor, expand the array and move all 
 *      the <K,V> pairs to the new array(HashMap by default double size of array)<br>
 *      load factor by default is 0.75<br>
 *      global wise: all the pairs need to participate<br>
 *      
 *  Contract of hashCode() and equals()<br>
 *  	if (a.equals(b))  then hashCode must be the same<br>
 *  	if (a.hashCode() == b.hashCode()), a and b may not be equaled<br>
 *  
 *  Now implement the MyHashMap<br>
 *  supported APIs:<br>
 *  	size()<br>
 *  	isEmpty()<br>
 *  	clear()<br>
 *  	put(K key, V value)<br>
 *  	get(K key)<br>
 *  	containsKey(K key)<br>
 *  	containsValue(V value)<br>
 *  	remove(K key) <br>
 */
public class MyHashMap<K, V> {
	// 1. define a class Entry for each Entry in the HashMap
	// since it is closely bounded with MyHashMap<K, V> and we
	// may need access it from outer class, so we need to use 
	// inner static class
	public static class Entry<K, V> {
		final K key; // ket cannot be changed
		V value;
		Entry<K, V> next;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
	}
	
	public static final int DEFAULT_SIZE = 16;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	// maintain an array of Entries
	private Entry<K, V>[] array;
	private float loadFactor;
	private int size; // record how many pairs of Entry is in the HashMap
	
	/**
	 * default constructor
	 */
	public MyHashMap() {
		this(DEFAULT_SIZE, DEFAULT_LOAD_FACTOR);
	}
	
	/**
	 * constructor with customized initial capacity and loadFactor
	 * @param cap initial capacity of MyHashMap
	 * @param loadFactor initial loadFactor of MyHashMap
	 */
	public MyHashMap(int cap, float loadFactor) {
		if (cap <= 0) {
			throw new IllegalArgumentException("Initial capacity cannot be <= 0");
		}
		this.array = (Entry<K, V>[])(new Entry[cap]);
		this.size = 0;
		this.loadFactor = loadFactor;
	}

	/**
	 * check current map's size
	 * @return
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * determine if current map is empty or not
	 * @return
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	/**
	 * remove all the entries in the map
	 */
	public void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}
	
	/**
	 * calculate given key's hashcode
	 * @param key
	 * @return hashcode of given key
	 */
	public int hash(K key) {
		// if key is null, by default its hashcode == 0
		if (key == null) {
			return 0;
		}
		// for we need to call hash(key) % array.length to 
		// get index of bucket, so hash(key) must be non-negative
		// so we use a bit operation trick here
		// 7FFFFFFF = 01111111 11111111 11111111 11111111
		// key.hashCode() & 0X7FFFFFFF can flop negative bit 1 to 0
		// without change other bits 1 or 0
		return key.hashCode() & 0X7FFFFFFF;
	}
	
	/**
	 * get the index of given key in the Entry array (index of bucket)
	 * @param key
	 * @return
	 */
	public int getIndex(K key) {
		int hashcode = hash(key);
		return hashcode % this.array.length;
	}
	
	/**
	 * determine if two value of given type is equal or not<br>
	 * containsValue() will use this API to check if two values are equal
	 * @param v1
	 * @param v2
	 * @return
	 */
	public boolean equalsValue(V v1, V v2) {
		// null check
		if (v1 == null && v2 == null) {
			return true;
		}
		if (v1 == null || v2 == null) {
			return false;
		}
		return v1.equals(v2);
	}
	
	/**
	 * determine if given value is in the map
	 * @param value
	 * @return
	 */
	public boolean containsValue(V value) {
		// special case
		if (this.isEmpty()) {
			return false;
		}
		for (Entry<K, V> e : this.array) { // iterate bucket
			while (e != null) { // iterate each entry in each chain
				if (equalsValue(e.getValue(), value)) {
					return true;
				}
				e = e.next;
			}
		}
		return false;
	}
	
	/**
	 * determine if two keys of given type is equal or not<br>
	 * containsKey() will use this API to check if two values are equal
	 * @param k1
	 * @param k2
	 * @return
	 */
	public boolean equalsKey(K k1, K k2) {
		if (k1 == null && k2 == null) {
			return true;
		}
		if (k1 == null || k2 == null) {
			return false;
		}
		return k1.equals(k2);
	}
	
	/**
	 * determine if given key is in the map
	 * @param key
	 * @return
	 */
	public boolean containsKey(K key) {
		// get index of given key
		// hash() has already considered null case
		int index = getIndex(key);
		Entry<K, V> e = array[index];
		while (e != null) {
			if (equalsKey(e.getKey(), key)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * return mapped value of given key of map
	 * @param key
	 * @return
	 */
	public V get(K key) {
		// if key is not in the map, return null
		if (!this.containsKey(key)) {
			return null;
		}
		int index = hash(key);
		Entry<K, V> e = array[index];
		while (e != null) { // several keys may map to the same bucket, so we need to iterate the whole LinkedList
			if (equalsKey(e.getKey(), key)) {
				return e.getValue();
			}
			e = e.next;
		}
		return null;
	}
	
	/**
	 * insert / update Entry in the map
	 * if the key already exists, update its value and return old value
	 * if the key does not exist before, put it into the map and return null
	 * @param key
	 * @param value
	 * @return
	 */
	public V put(K key, V value) {
		int index = getIndex(key);
		Entry<K, V> head = array[index];
		Entry<K, V> node = head;
		while (node != null) {
			// if given key is in the map bucket
			// update its value and return old value
			if (equalsKey(node.key, key)) {
				V res = node.value;
				node.value = value;
				return res;
			}
			node = node.next;
		}
		// if given key does not exist in the map bucket
		// we need to put the new Entry<K, V> before the 
		// current head Entry and update each Entry in the bucket
		Entry<K, V> newE = new Entry<K, V>(key, value);
		newE.next = head;
		array[index] = newE; // newE is new head now
		size++; // update size
		if (needRehashing()) {
			rehashing();
		}
		return null; // no older value of given key exists before
	}
	
	/**
	 * determine if map needs rehashing
	 * @return
	 */
	public boolean needRehashing() {
		// loadFactor is float number
		float ratio = (size + 0.0f) / array.length;
		if (ratio >= loadFactor) {
			return true;
		}
		return false;
	}
	
	/**
	 * rehash whole map<br>
	 */
	public void rehashing() {
		// new a doubled size array
		// for each element in the old array
		// do the put() operation to the new larger array
		Entry<K, V>[] oldArray = array;
		Entry<K, V>[] newArray = (Entry<K, V>[]) new Entry[array.length * 2];
		array = newArray;
		for (Entry<K, V> e : oldArray) {
			put(e.key, e.value);
		}
	}
	
	/**
	 * if given key is in the map, remove the pair and return the value of key
	 * if not, return null
	 * @param key
	 * @return
	 */
	public V remove(K key) {
		int index = getIndex(key);
		Entry<K, V> head = array[index];
		Entry<K, V> prev = head;
		Entry<K, V> cur = head;
		while (cur != null) {
			// find the key in the map
			if (equalsKey(cur.key, key)) {
				prev.next = cur.next;
				if (cur == head) { // delete head
					V res = head.value;
					head = head.next;
					array[index] = head;
					size--;
					return res;
				} else {
					// deletion in the middle
					V res = cur.value;
					size--;
					return res;
				}
			}
			prev = cur;
			cur = cur.next;
		}
		// cannot find given key in the map, return null
		return null;
	}
}
