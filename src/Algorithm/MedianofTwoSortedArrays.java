package Algorithm;

public class MedianofTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		int[] nums3 = {1, 3};
		int[] nums4 = {};
		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out.println(findMedianSortedArrays(nums3, nums4));
	}
	
	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0)
			if(nums2.length % 2 == 0)
				return (nums2[nums2.length/2] + nums2[(nums2.length - 1) / 2])/2.0;
			else
				return nums2[nums2.length/2];
		if(nums2 == null || nums2.length == 0)
			if(nums1.length % 2 == 0)
				return (nums1[nums1.length/2] + nums1[(nums1.length - 1) / 2])/2.0;
			else
				return nums1[nums1.length/2];
		int length = nums1.length + nums2.length;
		int idx = 0, idx1 = 0, idx2 = 0, a = 0, b = a;
		while (true) {
			if (idx == length/2 + 1)
				break;
			b = a;
			if(idx1 >= nums1.length) {
				a = nums2[idx2];
				idx2++;
			}
			else if(idx2 >= nums2.length) {
				a = nums1[idx1];
				idx1++;
			}
			else if(nums1[idx1] < nums2[idx2]) {
				a = nums1[idx1];
				idx1++;
			}
			else {
				a = nums2[idx2];
				idx2++;
			}
			idx++;
		}
		if(length % 2 == 0)
			return (a + b) / 2.0;
		else
			return a;
	}
	public double findMedianSortedArraysAns(int[] nums1, int[] nums2) {
        int M = nums1.length, N = nums2.length;
        if (M > N) return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = M;
        int mid = (M + N + 1) / 2;
        while (low <= high) {
            int i = low + ((high - low) >> 1);
            int j = mid - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) high = i - 1;
            else if (i < M && nums1[i] < nums2[j - 1]) low = i + 1;
            else {
                int maxOfLeft = 0;
                if (i == 0) maxOfLeft = nums2[j - 1];
                else if (j == 0) maxOfLeft = nums1[i - 1];
                else maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if (((M + N) % 2) == 1) return maxOfLeft;
                int minOfRight = 0;
                if (i == M) minOfRight = nums2[j];
                else if (j == N) minOfRight = nums1[i];
                else minOfRight = Math.min(nums1[i], nums2[j]);
                return ((double)(maxOfLeft + minOfRight)) / 2.0;
            }
        }
        return 0.0;
	}
}
