//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1697 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
        while (left <= right) {
            int idx = partition(nums, left, right);
            if (idx == k) {
                return nums[k];
            } if (idx > k) {
                right = idx - 1;
            } else {
                left = idx + 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = findPivot(nums, left, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (nums[i] >= pivot) {
                swap(nums, i, j);
                j--;
            } else if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            } else {
                i++;
                j--;
            }
        }
        swap(nums, right, i);
        return i;
    }

    private int findPivot(int[] nums, int left, int right) {
        int pivotIndex = left + (int)((right - left) * Math.random());
        swap(nums, pivotIndex, right);
        return nums[right];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
