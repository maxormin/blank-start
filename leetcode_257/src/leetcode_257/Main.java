package leetcode_257;
import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){ 
		val = x; 
	}
}

public class Main {
	static void deep_find(List<String> list,TreeNode root,String str){
		int m = 0;
		if(root.left!=null){
			deep_find(list,root.left,str+"->"+String.valueOf(root.left.val));
			m+=1;
		}
			
		if(root.right!=null){
			deep_find(list,root.right,str+"->"+String.valueOf(root.right.val));
			m+=1;
		}
		if(m==0){
			list.add(str);
		}
	}
	
	static List<String> binaryTreePaths(TreeNode root) {
		List<String> list1 = new ArrayList<String>();
		String str = String.valueOf(root.val);
		deep_find(list1,root,str);
		System.out.print(list1);
		return list1;
    }
	
//	static void see_tree(TreeNode new_tree){
//		if(new_tree.left!=null)
//			see_tree(new_tree.left);
//		if(new_tree.right!=null)
//			see_tree(new_tree.right);
//	}
	
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
//		see_tree(tree);
		binaryTreePaths(tree);
	}
}
