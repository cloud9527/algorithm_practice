package com.cloud.demo.twopoint;

import org.junit.Test;

import java.util.Arrays;

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
}
