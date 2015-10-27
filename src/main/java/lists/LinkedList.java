package lists;

/**
 * 
 * @author burlutal
 */
public class LinkedList<T> implements List<T>{
	Node<T> root;
	Node<T> tail;
	
	private class Node<T>{
		Node<T> next;
		T value;
	}
	
	public void add(T value){
		Node<T> node = new Node<>();
		node.value = value;
		if(root == null){
			root = node;
		} else {
			tail.next = node;
		}
		tail = node;
	}
	
	
}
