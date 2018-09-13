package SwordToOffer;

public class CreateMirrorTree {
	
	public static void main(String[] args) {
		CreateMirrorTree cmt = new CreateMirrorTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right= new TreeNode(3);
		root.left.right = new TreeNode(4);
		cmt.Mirror(root);
	}
	
	public void Mirror(TreeNode root) {
        rebuild(root);
        System.out.println(root.val);
    }
	
    private void rebuild(TreeNode node){
        if(node == null)
            return ;
        else{
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            rebuild(node.left);
            rebuild(node.right);
        }
    }
}