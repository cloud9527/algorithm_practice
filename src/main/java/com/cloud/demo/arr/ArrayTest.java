package com.cloud.demo.arr;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.cloud.demo.PrintUtils.print;

/**
 * 数组相关练习
 *
 * @author: wangjing
 * @date 2023/6/2
 **/
public class ArrayTest {

	@Test
	public void init() {
		//数组初始化
		int[] arr = new int[5];// { 0, 0, 0, 0, 0 }
		System.out.println(Arrays.toString(arr));
		int[] arr2 = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(arr2));
	}

	/* 随机返回一个数组元素 */
	@Test
	public void randomAccess() {
		int[] arr2 = {1, 2, 3, 4, 5};
		int randomIndex = ThreadLocalRandom.current().nextInt(0, arr2.length);
		int random = arr2[randomIndex];
		print(random + "");
	}

	/**
	 * 数组扩容
	 */
	@Test
	public void extend() {
		int[] arr = {1, 2, 3, 4, 5};
		print(Arrays.toString(extend(arr, 2)));
	}

	public int[] extend(int[] nums, int enlarge) {
		int[] newArr = new int[nums.length + enlarge];
		for (int i = 0; i < nums.length; i++) {
			newArr[i] = nums[i];
		}
		return newArr;
	}

	/* 在数组的索引 index 处插入元素 num */
	@Test
	public void insert() {
		int[] arr = {1, 2, 3, 4, 5};
		insert(arr, 55, 2);
		print(Arrays.toString(arr));
	}


	public void insert(int[] nums, int num, int index) {
		for (int i = nums.length - 1; i > index; i--) {
			nums[i] = nums[i - 1];
		}
		nums[index] = num;
	}

	@Test
	public void del() {
		int[] arr = {1, 2, 3, 4, 5};
		del(arr, 0);
		print(Arrays.toString(arr));
	}

	public void del(int[] nums, int index) {
		for (int i = index; i < nums.length - 1; i++) {
			nums[i] = nums[i + 1];
		}
	}
}
