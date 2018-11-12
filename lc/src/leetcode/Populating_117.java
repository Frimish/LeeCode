package leetcode;

public class Populating_117 {
    public void connect(TreeLinkNode node) {
        if ( node != null ){
            if ( node.left != null && node.right != null){
                node.left.next = node.right;
                node.right.next = getNext(node.next);
            }
            else if ( node.left == null && node.right != null){
                node.right.next = getNext(node.next);
            }
            else if ( node.left != null && node.right == null){
                node.left.next = getNext(node.next);
            }
            connect(node.right);
            connect(node.left);
        }
    }

	private TreeLinkNode getNext(TreeLinkNode cur) {
		while (cur != null) {
			if (cur.left != null) return cur.left;
			if (cur.right != null) return cur.right;
			cur = cur.next;
		}
		return null;
	}
}
