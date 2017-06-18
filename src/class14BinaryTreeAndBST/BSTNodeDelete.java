package class14BinaryTreeAndBST;

public class BSTNodeDelete {
	public TreeNode delete(TreeNode root,int target) {
		if(root == null) {
			return root;
		}
		
		if(root.key > target) {
			root.left = delete(root.left,target);
			return root;
		} else if(root.key < target) {
			root.right = delete(root.right,target);
			return root;
		}
		//case 1:guarantee root != null && root.key == target
		//directly link root.non-null-child to its parent node(return value will 
		//be return to last recursion layer)
		if(root.left == null) {
			return root.right;
		} else if(root.right == null) {
			return root.left;
		}
		
		//case 2: root.left != null && root.right != null && root.right.left == null
		//directly move root.left to root.right.left and return root.right
		if(root.right.left == null) {
			root.right.left = root.left;
			return root.right;
		}
		
		//case 3: most complex condition, the root.left and root.right are both not null and
		//        root.right.left is not null as well, at this point we choose to find the smallest
		//        node in root's right-subtree to replace root,and update smallest's right child node 
		//        if exists
		TreeNode rightSubtreeMin = deleteSmallest(root.right);
		rightSubtreeMin.left = root.left;
		rightSubtreeMin.right = root.right;
		return rightSubtreeMin;
	}
/*
 *      3   
 *     / \ 
 *    2   8
 *       / \
 *      6   10
 *          / \
 *         9   12 
 *        /
 *       8.5 
 *         \
 *         8.75
 *         
 *          to delete 8, find the smallest node in the right subtree, subtree's root is 10
 *          find 8.5 which is the min and move 8.75 which is 8.5's right(if exists)
 *          to 8.5's prev parent 9's left
 *          At last, 8.5 replace 8 and link it with 8's left and right child 
 */   
	private TreeNode deleteSmallest(TreeNode cur) {
		// TODO Auto-generated method stub
		TreeNode prev = cur;//prev is cur node's parent node
		cur = cur.left;
		while(cur.left != null) {
			prev = cur;
			cur = cur.left;//to find the left-most node which has min value
		}
		//now,cur.left == null
		prev.left = prev.left.right;//link min's right child to prev's left if it exists
		return cur;//cur is the min in right subtree 
	}
}
