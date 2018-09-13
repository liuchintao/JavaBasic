package datastructure.tree;

public class PathSumEqTgt<In> {
/*
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */
	public int getPath(BasicTree<Integer> root, Integer target) {
		if(root == null)
			return 0;
		int ret = pathSumWithRoot(root.left, target) 
				+ pathSumWithRoot(root.right, target) 
				+ pathSumWithRoot(root, target);
		return ret;
	}

    private int pathSumWithRoot(BasicTree<Integer> root, Integer target) {
    	if(root == null)
    		return 0;
    	int ret = 0;
    	if(target == root.val)
    		ret++;
    	Integer tmp = (int) target - (int) root.val;
		ret += pathSumWithRoot(root.left, tmp) + pathSumWithRoot(root.right, tmp);
		return ret;
	}
}
