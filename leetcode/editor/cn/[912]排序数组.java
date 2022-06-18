//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 583 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// Method 1: quick sort
//class Solution {
//    public int[] sortArray(int[] nums) {
//        if (nums == null || nums.length <= 1) {
//            return nums;
//        }
//        quickSort(nums, 0, nums.length - 1);
//        return nums;
//    }
//
//    private void quickSort(int[] nums, int left, int right) {
//        // base case
//        if (left >= right) {
//            return;
//        }
//        // recursion rule
//        int idx = partition(nums, left, right);
//        quickSort(nums, left, idx - 1);
//        quickSort(nums, idx + 1, right);
//    }
//
//    private int partition(int[] nums, int left, int right) {
//        int pivot = findPivot(nums, left, right);
//        int i = left;
//        int j = right - 1;
//        while (i <= j) {
//            if (nums[i] >= pivot) {
//                swap(nums, i, j--);
//            } else if (nums[j] < pivot) {
//                swap(nums, i++, j);
//            } else {
//                i++;
//                j--;
//            }
//        }
//        swap(nums, i, right);
//        return i;
//    }
//
//    private int findPivot(int[] nums, int left, int right) {
//        int pivotIndex = left + (int)((right - left) * Math.random());
//        swap(nums, pivotIndex, right);
//        return nums[right];
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//}

// Method 2: merge sort
//class Solution {
//    public int[] sortArray(int[] nums) {
//        if (nums == null || nums.length <= 1) {
//            return nums;
//        }
//        int[] helper = new int[nums.length];
//        mergeSort(nums, helper, 0, nums.length - 1);
//        return nums;
//    }
//
//    private void mergeSort(int[] nums, int[] helper, int left, int right) {
//        // base case
//        if (left >= right) {
//            return;
//        }
//        // recursion rule
//        int mid = left + (right - left) / 2;
//        mergeSort(nums, helper, left, mid);
//        mergeSort(nums, helper, mid + 1, right);
//        merge(nums, helper, left, right, mid);
//    }
//
//    private void merge(int[] nums, int[] helper, int left, int right, int mid) {
//        for (int i = left; i <= right; i++) {
//            helper[i] = nums[i];
//        }
//
//        int i = left;
//        int j = mid + 1;
//        while (i <= mid && j <= right) {
//            if (helper[i] <= helper[j]) {
//                nums[left++] = helper[i++];
//            } else {
//                nums[left++] = helper[j++];
//            }
//        }
//        while (i <= mid) {
//            nums[left++] = helper[i++];
//        }
//    }
//}

// Method 3: selection sort
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[minIndex] > nums[j] ? j : minIndex;
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
