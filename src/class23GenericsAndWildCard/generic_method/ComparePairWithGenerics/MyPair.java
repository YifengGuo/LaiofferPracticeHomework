package class23GenericsAndWildCard.generic_method.ComparePairWithGenerics;

/*
 * <> means this is a generic class
 * it can receive a pair of generic type parameter
 * K is key and V is value
 */
public class MyPair<K, V> {
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	private K key;
	private V value;

	public MyPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyPair [key=" + key + ", value=" + value + "]";
	}
}
