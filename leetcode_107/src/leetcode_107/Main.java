package leetcode_107;

import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Main {
	
	static void see_tree(TreeNode new_tree,List<List<Integer>> s){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> m = new ArrayList<Integer>();
		if(new_tree.left!=null){
			m.add(new_tree.left.val);
			see_tree(new_tree.left,s);
		}
		
		if(new_tree.right!=null){
			m.add(new_tree.right.val);
			see_tree(new_tree.right,s);
		}
		
		if(m.size()==0) 
			return ;
		else
			s.add(m);
	}
	
	static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> s = new ArrayList<List<Integer>>();
		if(root==null) return s;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> m = new ArrayList<Integer>();
		int i,j,size;
		queue.add(root);
		j = 1;
		i = 0;
		size = 0;
		while(queue.size() != 0){
			TreeNode new_tree = queue.poll();
			m.add(new_tree.val);
			i++;
			if(new_tree.left != null){
				queue.add(new_tree.left);
				size++;
			}
			if(new_tree.right != null){
				queue.add(new_tree.right);
				size++;
			}
			if(i == j){
				s.add(m);
				j = size;
				i = 0;
				size = 0;
				m = new ArrayList<Integer>();
			}
		}
		if(i!=j)
			s.add(m);
		Collections.reverse(s);
		return s;
    }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a[] = new int[10];
		int i,n,m;
		m = in.nextInt();
		n = in.nextInt();
		TreeNode tree = new TreeNode(n);
		tree.left = null;
		tree.right = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(tree);
		TreeNode new_tree = queue.poll();
		for(i=0;i<m-1;i++){
			String str = in.next();
			try {
				n = Integer.parseInt(str);
			} catch (NumberFormatException e) {
				if(i % 2 != 0)
					new_tree = queue.poll();
				continue;
			}
			TreeNode tree_2 = new TreeNode(n);
			tree_2.left = null;
			tree_2.right = null;
			if(i % 2 == 0){
				new_tree.left = tree_2;
				queue.add(tree_2);
			}
			else{
				new_tree.right = tree_2;
				queue.add(tree_2);
				new_tree = queue.poll();
			}
		}
		List<List<Integer>> s = new ArrayList<List<Integer>>();
		s = levelOrderBottom(tree);
		System.out.print(s);
	}

}
