package stacks;

/**
 * 
 * @author burlutal
 *
 * @param <T>
 */
public class Stack<T extends Comparable<T>> {
	INode<T> top;
	
	interface INode<T> {
		public INode<T> getPrev();
		public T getValue();
	}
	class Node implements INode<T> {
		INode<T> prev;
		T value;
		public Node(INode<T> prev, T value) {
			this.prev = prev;
			this.value = value;
		}
		public String toString() {
			return String.valueOf(value);
		}
		public INode<T> getPrev() {
			return prev;
		}
		public T getValue() {
			return value;
		}
	}
	
	public T pop(){
		if(top == null)
			return null;
		INode<T> node = top;
		top = top.getPrev();
		return node.getValue();
	}
	
	public void push(T newValue){
		top = new Node(top, newValue);
	}
	
	@Override
	public String toString() {
		INode<T> node = top;
		StringBuffer sb = new StringBuffer();
		do {
			sb.append(node.getValue());
			node = node.getPrev();
			if (node != null)
				sb.append(",");
		} while (node != null);
		return sb.toString();
	}
	
	public boolean isEmpty(){
		return top == null;
	}
}