package com.cloud.demo.twopoint;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针练习
 * 中间数字代表第六题 m代表 自己写的不带是书中源码
 *
 * @author: wangjing
 * @date 2023/5/16
 **/
public class TwoPointTest {


	//题目：输入一个递增排序的数组和一个值k，请问如何在数组中找出两个和为k的数字并返回它们的下标？
	//假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
	//例如，输入数组[1，2，4，6，10]，k的值为8，数组中的数字2与6的和为8，它们的下标分别为1与3
	@Test
	public void Test6() {
		int[] arr = {1, 2, 4, 6, 10};
		int k = 8;

		System.out.println(Arrays.toString(offer6(arr, k)));
		offer6M(arr, k);
	}

	public int[] offer6(int[] arr, int k) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j && arr[i] + arr[j] != k) {
			if (arr[i] + arr[j] > k) {
				j--;
			} else {
				i++;
			}
		}
		return new int[]{i, j};
	}

	public void offer6M(int[] arr, int k) {
		int l = arr.length - 1;
		int i = 0;
		while (l >= i) {
			if (arr[i] + arr[l] > k) {
				l--;
			} else if (arr[i] + arr[l] < k) {
				i++;
			} else {
				System.out.println(i);
				System.out.println(l);
				return;
			}
		}
	}

	/**
	 * 题目：输入一个数组，如何找出数组中所有和为0的3个数字的三元组？
	 * 需要注意的是，返回值中不得包含重复的三元组。
	 * 例如，在数组[-1，0，1，2，-1，-4]中有两个三元组的和为0，它们分别是[-1，0，1]和[-1，-1，2]。
	 */
	@Test
	public void test7() {
		int[] arr = {-1, -1, 0, 1, 2, 2, -1, -4};
		System.out.println(threeSumM(arr));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums); // 对数组进行排序
		List<List<Integer>> result = new ArrayList<>(); // 存储结果的集合
		for (int i = 0; i < nums.length - 2; i++) { // 进行枚举
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue; // 去重（如果当前数和上一个数相同，则跳过）
			}
			int left = i + 1, right = nums.length - 1;
			while (left < right) { // 双指针的方式寻找符合条件的三个数
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
						left++; // 去重（如果当前数和上一个数相同，则跳过）
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--; // 去重（如果当前数和上一个数相同，则跳过）
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return result;
	}

	public List<List<Integer>> threeSumM(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					//跳过重复元素
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}

	//题目：输入一个正整数组成的数组和一个正整数k，
	//请问数组中和大于或等于k的连续子数组的最短长度是多少？如果不存在所有数字之和大于或等于k的子数组，则返回0。
	//例如，输入数组[5，1，4，3]，k的值为7，和大于或等于7的最短连续子数组是[4，3]，因此输出它的长度2。
	@Test
	public void test8() {
		int[] arr = {5, 1, 4, 3};
		System.out.println(minSubArrayLen(7,arr));
	}

	public int minSubArrayLen(int k, int[] nums) {
		int left = 0, right = 0, sum = 0, minLen = Integer.MAX_VALUE;

		while (right < nums.length) {
			sum += nums[right];
			right++;

			while (sum >= k) {
				minLen = Math.min(minLen, right - left);
				sum -= nums[left];
				left++;
			}
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
