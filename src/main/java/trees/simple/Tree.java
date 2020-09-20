package trees.simple;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class Tree {

	class Node {
		Node left;
		Node right;
		int value;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	Node root;
	
	public void put(int value) {
		root = put(root, new Node(value));
	}
	
	private Node put(Node node, Node newNode) {
		if(node == null) 
			return newNode;

		if(newNode.value < node.value)
			node.left = put(node.left, newNode);
		else if(newNode.value > node.value)
			node.right = put(node.right, newNode);
		
		return node;
	}
	
	public boolean contains(int value) {
		return contains(root, value);
	}
	
	private boolean contains(Node node, int value) {
		if(node == null)
			return false;
		if(value < node.value)
			return contains(node.left, value);
		else if(value > node.value)
			return contains(node.right, value);
		else
			return true;
	}
	
	public void delete(int value) {
		if(root == null)
			return;
		root = delete(root, value);
	}
	
	private Node min(Node node) {
		if(node == null)
			return null;
		if(node.left == null)
			return node;
		else
			return min(node.left);
	}
	
	private Node deleteMin(Node node) {
		if (node.left == null)
			return node.right;
		node.left = deleteMin(node.left);
		return node;
	}
	
	private Node _delete(Node node, int value) {
		if(value < node.value) 
			node.left = delete(node.left, value);
		else if(value > node.value) 
			node.right = delete(node.left, value);
		else {
			if(node.right == null)	return node.left;
			if(node.left == null)	return node.right;
			Node min = min(node.right);
			min.left = node.left;
			return node.right;
		}
		return node;
	}
	
	private Node delete(Node node, int value) {
		if(value < node.value) 
			node.left = delete(node.left, value);
		else if(value > node.value) 
			node.right = delete(node.left, value);
		else {
			if(node.right == null)	return node.left;
			if(node.left == null)	return node.right;
			Node min = min(node.right);
			min.left = node.left;
			min.right = deleteMin(node.right);
			
			return node.right;
		}
		return node;
	}
	
}
