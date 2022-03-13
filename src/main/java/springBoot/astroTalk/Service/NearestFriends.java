package springBoot.astroTalk.Service;

import java.io.*;
import java.util.*;

class TreeNode {    
    int value; 
        TreeNode left, right; 
        TreeNode targate;
        TreeNode(){}
        TreeNode(int value){ 
            this.value = value; 
            left = null; 
            right = null; 
        }
		@Override
		public String toString() {
			return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + ", targate=" + targate + "]";
		} 
        
 }

class NearestFriends {
	TreeNode root;
	
	public void insert(TreeNode node, int value) {
        if (value < node.value) { 
        	if (node.left != null) { 
        		insert(node.left, value);
        	} 
        	else { 
        	node.left = new TreeNode(value); 
        	} 
        }
        else if (value > node.value) {
          if (node.right != null) {
            insert(node.right, value);
          } else {
            node.right = new TreeNode(value);
          }
          root=node;
        }
	}
      
	
	
	List<TreeNode> path = null;
	//Finding all the nodes at a distance K from target
	//node.
	public List<Integer> distanceK(
								TreeNode target, int K)
	{
		
//		System.out.println("rootPawan : "+root);
		
		path = new ArrayList<>();
		findPath(root, target);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < path.size(); i++) {
			findKDistanceFromNode(
				path.get(i), K - i, result,
				i == 0 ? null : path.get(i - 1));
		}
		//Returning list of all nodes at a distance K
		return result;
	}


	public void findKDistanceFromNode(TreeNode node,
									int dist,
									List<Integer> result,
									TreeNode blocker)
	{
		if (dist < 0 || node == null
			|| (blocker != null && node == blocker)) {
			return;
		}

		if (dist == 0) {
			result.add(node.value);
		}

		findKDistanceFromNode(node.left, dist - 1, result,
							blocker);
		findKDistanceFromNode(node.right, dist - 1, result,
							blocker);
	}
	//Finding the path of target node from root node
	public boolean findPath(TreeNode node, TreeNode target)
	{
		if (node == null)
			return false;

		if (node == target || findPath(node.left, target)
			|| findPath(node.right, target)) {
			path.add(node);
			return true;
		}

		return false;
	}
		
}
