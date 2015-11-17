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
	}

	public boolean contains(T value) {
		return false;
	}

	private TreeNode lookup(T value){
		TreeNode node = root;
		while(node != null){
			if(node.value.compareTo(value) <= 0){
				if(node.left != null)
				node = node.left;
			} else {
				node = node.right;
			}
		}
	}
	public void put(T value) {
		if(root == null){
			root = new TreeNode(null, null, value);
		} else {
			if(root.value.compareTo(value) <= 0){
				TreeNode node = new TreeNode(root, null, value);
				root = node;
			}
		}
	}

	public T min() {

	}

	public T max() {

	}
}
