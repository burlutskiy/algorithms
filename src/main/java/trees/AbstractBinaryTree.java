package trees;

/**
 * 
 * @author alexey
 *
 */
public abstract class AbstractBinaryTree<K extends Comparable<K>, V, N extends Node<K,V, N>> implements Tree<K,V,N>{
	N root;
	int size;
	
	abstract N createNode(K key, V value);
}
