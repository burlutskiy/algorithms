package trees;

/**
 * @author burlutal
 *
 */
public class BST<T extends Comparable<T>> {
	TreeNode root;
	long size;

	class TreeNode {
		TreeNode left, right;
		T value;
		public TreeNode(TreeNode left, TreeNode right, T value) {
			super();
			this.left = left;
			this.right = right;
			this.value = value;
		}
		@Override
		public String toString() {
			return "[" + value + "," + left + "," + right + "]";
		}
	}

	public boolean contains(T value) {
		return contains(root, value);
	}

	private boolean contains(TreeNode node, T value){
		if(node == null)
			return false;
		int compareTo = value.compareTo(node.value);
		if(compareTo < 0) {
			return contains(node.left, value);
		} else if (compareTo > 0) {
			return contains(node.right, value);
		} else
			return true;
	}
	
	public void put(T value) {
		put(root, value);
	}

	private TreeNode put(TreeNode node, T value){
		if(node == null){
			return new TreeNode(null, null, value);
		} else {
			int compareTo = value.compareTo(node.value);
			if(compareTo <= 0){
				node.left = put(node.left, value);
			} else {
				node.right = put(node.right, value);
			}
		}
		return node;
	}
	
	public T min() {
		TreeNode node = root;
		while(node.left != null){
			node = node.left;
		}
		return node.value;
	}

	public T max() {
		TreeNode node = root;
		while(node.right != null){
			node = node.right;
		}
		return node.value;
	}

	@Override
	public String toString() {
		return "BST [root=" + root + "]";
	}
	
}
