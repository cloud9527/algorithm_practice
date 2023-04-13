package com.cloud.demo.leetcode;

/**
 * @author: wangjing
 * @date 2023/4/10
 **/
public class leetcode {
	public static void main(String[] args) {
		//int[] arr = {1, 2, 0, 0, 5, 0, 7};
		//int[] arr = {0, 2, 0, 0, 5, 9, 0};
		int[] arr ={0,1,0,3,12};
		printArr(arr);
		//int[] res = sortedSquares997(arr);
		//int[] res = rotate189(arr, 3);
		//printArr(res);
		//rotate189_2(arr, 3);
		moveZeroes283(arr);
	}

	private static void printArr(int[] a) {
		for (int i : a) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public static int[] sortedSquares997(int[] a) {
		int n = a.length;
		int[] result = new int[n];
		int i = 0, j = n - 1;
		for (int p = n - 1; p >= 0; p--) {
			if (Math.abs(a[i]) > Math.abs(a[j])) {
				result[p] = a[i] * a[i];
				i++;
			} else {
				result[p] = a[j] * a[j];
				j--;
			}
		}
		return result;
	}

	public static int[] rotate189(int[] nums, int k) {
		int l = nums.length;
		int realK = k % l;
		int[] result = new int[l];
		for (int i = 0; i < l; i++) {
			int index;
			if (realK + i >= l) {
				index = realK + i - l;
			} else {
				index = realK + i;
			}
			result[index] = nums[i];
		}
		System.arraycopy(result, 0, nums, 0, result.length);
		return nums;
	}


	public static void rotate189_2(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		printArr(nums);
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void moveZeroes283(int[] nums) {
		int slow = 0;
		for (int fast = 0; fast < nums.length; fast++) {
			if (nums[fast]!=0){
				int temp = nums[slow];
				nums[slow] = nums[fast];
				nums[fast] =temp;
				slow++;
			}
		}
		printArr(nums);
	}

}
