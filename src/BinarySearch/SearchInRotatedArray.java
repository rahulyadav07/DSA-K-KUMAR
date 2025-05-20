package BinarySearch;

public class SearchInRotatedArray {
    public static void main(String[] args) {
       int [] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // Search in the left and right sorted portions of the array
        int left = searchInSorted(nums, 0, pivot, target);
        if (left != -1) return left;
        return searchInSorted(nums, pivot + 1, nums.length - 1, target);
    }

    // Function to search in a sorted portion of the array
    public static int searchInSorted(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Function to find the pivot (index of the largest element)
    public static int findPivot(int[] nums) {
        int low = 0;
        int high = nums.length - 1;


// 7 8 9 10 1 2 3 4


        while (low < high) {
            int mid = low + (high - low) / 2;

            // Pivot is the point where nums[mid] > nums[mid + 1]
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // If nums[mid] >= nums[low], move right
            if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
