package class14BinaryTreeAndBST;

class TreeNode {
	public int key;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int key) {
		this.key = key;
	}
}
public class BinarySearchTreeAPI {
	/**
	 * 
	 * @param root
	 * @param target
	 * @return
	 *  Search if this BST has such node with the target
	 */
	public boolean searchBSTRecursive(TreeNode root,int target) {
		if(root == null) {
			return false;
		}
		if(root.key == target) {
			return true;
		} else if(root.key > target) {
			return searchBSTRecursive(root.right,target);
		} else {
			return searchBSTRecursive(root.left,target);
		}
	}
	
	/**
	 * 
	 * @param root
	 * @param target
	 * @return
	 * Iterative way to insert in BST
	 */
	public boolean searchBSTIterative(TreeNode root,int target) {
		if(root == null) {
			return false;
		}
		TreeNode cur = root;
		while(cur != null) {
			if(cur.key > target) {
				cur = cur.right;
			} else if(cur.key < target) {
				cur = cur.left;
			} else {
				return true;
			}
		}
		return false;
	}
	
	public TreeNode insertBST(TreeNode root, int target) {
		if(root == null) {//if return type is void, the base case will be hard to handle because java is passed by value
			TreeNode newNode = new TreeNode(target);
			return newNode;
		}
		TreeNode cur = root;//current root node
		TreeNode prev = null;
		while(cur != null) {
			if(cur.key > target) {
				prev = cur;
				cur = cur.left;
			} else if(cur.key < target) {
				prev = cur;
				cur = cur.right;
			} else {
				return root;//if this tree already has a node with target, return the root 
			}
		}
		if(prev.key > target) {
			prev.left = new TreeNode(target);
		} else if(prev.key < target) {
			prev.right = new TreeNode(target);
		}
		return root;//after inserting, return the root
	}
}
