
// non-duplicate keys
// any left-child subtree node < parent < any right-child subtree node 

public class Main {

	public class BinaryNode {
		int key;
		BinaryNode left, right, parent;
		BinaryNode(int k) {
			key = k;
		}
	}
	
	BinaryNode root = null;
	
	// returns null if the tree is empty
	// returns node if key matches
	// returns potential parent if key doesn't match (convenient for insertion)
	public BinaryNode search(int k) {
		if (root == null) return null;
		BinaryNode u = root;
		while (k != u.key) {
			if (k < u.key) {
				if (u.left == null) return u;
				else u = u.left;
			} else {
				if (u.right == null) return u;
				else u = u.right;
			}
		}
		return u;
	}
	
	// adds a new key to the tree (if possible)
	// returns success of failure
	public boolean add(int k){
		if (root == null) {
		    root = new BinaryNode(k);
		    return true;
		}
		BinaryNode u = search(k);
		if (k == u.key) { // element exists; do not add
		    return false;
		}
		if (k < u.key) {
			BinaryNode v = new BinaryNode(k);
			v.parent = u;
		    u.left = v;
		} else {
			BinaryNode v = new BinaryNode(k);
			v.parent = u;
		    u.right = v;
		}
		return true;
	}
	
	// deletes leaf node, or node that has one child
	// used in general remove() method
	public void cut(BinaryNode v) {
		BinaryNode childOfV = null;
		if (v.left != null) childOfV = v.left;
		if (v.right != null) childOfV = v.right;
		if (v.parent != null) {
			if (v.parent.left == v) { // v is a left child
				v.parent.left = childOfV;
			} else { // v is right child
				v.parent.right = childOfV;
			}
			if (childOfV != null) {
				childOfV.parent = v.parent;
			}
		} else { // deleting root
			if (childOfV == null) {
				root = null;
			} else {
				root = childOfV;
				root.parent = null;
			}
		}
	}
	
	// returns node of minimum key in subtree
	// used in general remove() method
	public BinaryNode min(BinaryNode node) {
		BinaryNode returnNode = node;
		while (returnNode.left != null) {
			returnNode = returnNode.left;
		}
		return returnNode;
	}
	
	// removes node from tree (if possible)
	// returns success of failure
	public boolean remove(int k) {
		BinaryNode u = search(k);
		if (u == null || u.key != k) return false;
		BinaryNode nodeToCut = u;
		if (u.left != null && u.right != null) { // tricky case
			nodeToCut = min(u.right);
			u.key = nodeToCut.key; // save nodeToCut's key in u
		}
		cut(nodeToCut);
		return true;
	}
	
	public void inorder(BinaryNode u){
		if (u == null) return;
		inorder(u.left);
		System.out.printf(" %d", u.key);
		inorder(u.right);
	}

	public void preorder(BinaryNode u){
		if (u == null) return;
		System.out.printf(" %d", u.key);
		preorder(u.left);
		preorder(u.right);
	}
	
	public void postorder(BinaryNode u){
		if (u == null) return;
		postorder(u.left);
		postorder(u.right);
		System.out.printf(" %d", u.key);
	}

	// in-order traversal
	public void inorder(){
		inorder(root);
		System.out.printf("\n");
	}

	// pre-order traversal
	public void preorder(){
		preorder(root);
		System.out.printf("\n");
	}

	// post-order traversal
	public void postorder(){
		postorder(root);
		System.out.printf("\n");
	}
	
	public static void main(String[] args) {
		int[] keys = {5, 3, 7, 2, 4, 6, 8, 1, 9, 0};
		Main bst = new Main();
		for (int i = 0; i < keys.length; i++)
			bst.add(keys[i]);
		
		System.out.println("in-order traversal: ");
		bst.inorder();
		
		System.out.println("pre-order traversal: ");
		bst.preorder();
		
		System.out.println("post-order traversal: ");
		bst.postorder();
		
		System.out.println("removing 3, 2, 6, 1...");
		bst.remove(3);
		bst.remove(2);
		bst.remove(6);
		bst.remove(1);
		
		System.out.println("new in-order traversal: ");
		bst.inorder();
	}
	
}
