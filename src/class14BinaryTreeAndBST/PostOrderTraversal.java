package class14BinaryTreeAndBST;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversal {
	public List<Integer> postOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while(!stack.isEmpty()) {
			TreeNode current = stack.peekFirst();//just initialize cur node. DON'T POP STACK HERE!!!!!
			if(prev == null || current == prev.left || current  == prev.right) {//going down cases
				if(current.left != null) {//if going down, left subtree has priority
					stack.offerFirst(current.left);
				} else if(current.right != null) {
					stack.offerFirst(current.right);
				} else {//if we cannot go down on either way, we reach the leaf node
					stack.pollFirst();
					result.add(current.key);
				}
			} else if(prev == current.left) { //going up from left subtree
				if(current.right != null) {//means we have to go right afterwards
					stack.offerFirst(current.right);
				} else { // current node has no right child, keep going up
					stack.pollFirst();
					result.add(current.key);
				}
			} else {//going up from right subtree
				stack.pollFirst();
				result.add(current.key);
			}
			prev = current;//after each going down or going up, update last traversed node as prev
		}
		return result;
	}
}
