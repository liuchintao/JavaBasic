package Algorithm.pacakgeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
	/**
	 * Given a set of candidate numbers (candidates) (without duplicates) and a
	 * target number (target), find all unique combinations in candidates where the
	 * candidate numbers sums to target. The same repeated number may be chosen from
	 * candidates unlimited number of times. 
	 * Note: All numbers (including target)will be positive integers. 
	 * The solution set must not contain duplicate
	 * combinations. 
	 * Input: candidates = [2,3,6,7], target = 7, 
	 * A solution set is: [[7], [2,2,3]]
	 */
	
//	public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> conbinations = new ArrayList<>();
//        Arrays.sort(candidates);
//		traceback(conbinations, new ArrayList<Integer>(), candidates, target, 0);
//		return conbinations;
//    }
//
//	private void traceback(List<List<Integer>> conbinations, List<Integer> arrayList, 
//			int[] candidates, int target, int idx) {
//		if(target < 0)
//			return;
//		else if(target == 0) 
//			conbinations.add(new ArrayList<>(arrayList));
//		else {
//			for(int i = idx; i < candidates.length; i++) {
//				arrayList.add(candidates[i]);
//				traceback(conbinations, arrayList, candidates, target - candidates[i], idx);
//				arrayList.remove(arrayList.size() - 1);
//			}
//		}
//	}
	public List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
}
