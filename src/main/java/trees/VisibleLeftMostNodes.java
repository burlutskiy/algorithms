package trees;

import java.io.IOException;

/*
 * Number of Visible Nodes
There is a binary tree with N nodes. You are viewing the tree from its left side and can see only the leftmost nodes at each level. Return the number of visible nodes.
Note: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes. The leftmost node at a level could be a right node.
Signature
int visibleNodes(Node root) {
Input
The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node is between 0 and 1,000,000,000
Output
An int representing the number of visible nodes.
Example
            8  <------ root
           / \
         3    10
        / \     \
       1   6     14
          / \    /
         4   7  13            
output = 4
 */
public class VisibleLeftMostNodes {
	class Node {
		int data;
		Node left;
		Node right;

		Node() {
			this.data = 0;
			this.left = null;
			this.right = null;
		}

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	// Add any helper functions you may need here
	private int depth(Node node, int depth) {
		if (node.left == null && node.right == null)
			return depth;
		int mleft, mright;
		mleft = mright = 0;
		if (node.left != null) {
			mleft = depth(node.left, depth + 1);
		}
		if (node.right != null) {
			mright = depth(node.right, depth + 1);
		}
		return Math.max(mleft, mright);
	}

	int visibleNodes(Node root) {
		return depth(root, 1);
	}

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void check(int expected, int output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printInteger(expected);
			System.out.print(" Your output: ");
			printInteger(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printInteger(int n) {
		System.out.print("[" + n + "]");
	}

	public void run() throws IOException {

		Node root_1 = new Node(8);
		root_1.left = new Node(3);
		root_1.right = new Node(10);
		root_1.left.left = new Node(1);
		root_1.left.right = new Node(6);
		root_1.right.right = new Node(14);
		root_1.left.right.left = new Node(4);
		root_1.left.right.right = new Node(7);
		root_1.right.right.left = new Node(13);
		int expected_1 = 4;
		int output_1 = visibleNodes(root_1);
		check(expected_1, output_1);

		Node root_2 = new Node(10);
		root_2.left = new Node(8);
		root_2.right = new Node(15);
		root_2.left.left = new Node(4);
		root_2.left.left.right = new Node(5);
		root_2.left.left.right.right = new Node(6);
		root_2.right.left = new Node(14);
		root_2.right.right = new Node(16);

		int expected_2 = 5;
		int output_2 = visibleNodes(root_2);
		check(expected_2, output_2);
		  
	    // Add your own test cases here
	    /*
	    10
	   /  \
	  8    15
	 /    /  \
	4    14   16
	 \
	  5
	   \
	    6
	
	    */
	}

	public static void main(String[] args) throws IOException {
		new VisibleLeftMostNodes().run();
	}
}
