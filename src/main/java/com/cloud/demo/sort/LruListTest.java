package com.cloud.demo.sort;

import java.util.LinkedList;

/**
 * @author: wangjing
 * @date 2023/3/28
 **/
public class LruListTest {
	public static void main(String[] args) {
		LruList lruList = new LruList(new LinkedList<>());
		for (int i = 0; i < 22; i++) {
			lruList.push(i);
		}
		System.out.println(lruList);

		Integer integer = lruList.get(2);

		System.out.println(integer);
		System.out.println(lruList);

		lruList.push(55);
		System.out.println(lruList);
	}
}
