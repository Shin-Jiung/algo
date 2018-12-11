#이진트리구현 및 전위순회, 중위순회, 후위순회

import java.util.*;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeNode[] node = new TreeNode[16];
		for (int i = 1; i <= 15; i++) {
			node[i] = new TreeNode(i);
		}

		for (int i = 2; i <= 15; i++) {
			if (i % 2 == 0) {
				node[i / 2].left = node[i];
			} else {
				node[i / 2].right = node[i];
			}
		}

		preorder(node[1]);

	}

	public static void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
}
