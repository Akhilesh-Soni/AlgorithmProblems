package l7;


public class Pair<T> {
	int priority;
	T value;
	
	public Pair(int p, T v) {
		this.priority = p;
		this.value = v;
	}
}
