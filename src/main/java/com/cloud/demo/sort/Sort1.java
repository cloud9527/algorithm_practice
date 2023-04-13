package com.cloud.demo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author: wangjing
 * @date 2023/3/29
 **/
public class Sort1 {

	public static int[] createList() {
		Random random = new Random();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			arr.add(i, random.nextInt(100));
		}
		System.out.println("old= " + arr);
		return arr.stream().mapToInt(Integer::intValue).toArray();
	}


	public static void printArr(int[] arr) {
		List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
		for (Integer integer : collect) {
			System.out.print(integer + ",");
		}
	}

	public static void main(String[] args) {
		int[] list = createList();
		buble(list);
		printArr(list);
	}

	//冒泡排序，相邻的两两比较
	public static void buble(int[] arr) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			boolean isSore = false;
			for (int j = 0; j < length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					isSore = true;
				}
			}
			if (!isSore){
				break;
			}
		}

	}

}
