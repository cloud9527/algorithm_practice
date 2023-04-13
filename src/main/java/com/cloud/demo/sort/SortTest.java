package com.cloud.demo.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: wangjing
 * @date 2023/3/28
 **/
public class SortTest {

	public static void main(String[] args) {
		//List<Integer> list = createList();
		//System.out.println("old= " + list);
		//int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
		//bubbleSort(ints, ints.length);
		//selectSort(ints, ints.length);
		//insertSort(ints, ints.length);
		//printArr(ints);

		int[] nums = {1, 3, 5, 7, 9,10};
		//int target = 1;
		int index = binarySearch2(nums, 22);
		System.out.println(index); 

	}

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ",");
		}
	}

	public static void bubbleSort(int[] arr, int n) {
		if (n == 1) {
			return;
		}
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
	}

	public static void selectSort(int[] arr, int n) {
		if (n == 1) return;

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}


	public static void insertSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}


	public static List<Integer> createList() {
		Random random = new Random();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			arr.add(i, random.nextInt(100));
		}
		return arr;
	}

	public static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (target == arr[mid]) {
				return mid;
			} else if (target > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;

	}


	public static int binarySearch2(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;
		int index = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;
			} else {
				index = mid;
				break;
			}
		}
		if (index == -1){
			index = start;
		}
		return index;
	}
}
