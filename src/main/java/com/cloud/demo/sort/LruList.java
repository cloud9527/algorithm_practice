package com.cloud.demo.sort;

import java.util.LinkedList;

/**
 * @author: wangjing
 * @date 2023/3/28
 **/
public class LruList {
	private int maxSize = 20;

	private LinkedList<Integer> list;

	public LruList(LinkedList<Integer> list) {
		this.list = list;
	}

	public void push(Integer data) {
		//是否存在，存在删除旧的，将新的一到第一个
		if (list.contains(data)) {
			list.remove(data);
			list.addFirst(data);
		} else {
			//不存在判断是否已满，满了删除最后一个，新的添加到第一个
			if (list.size() == maxSize) {
				list.removeLast();
				list.addFirst(data);
			}else{
				list.addFirst(data);
			}
		}
	}

	public Integer get(int index) {
		if (index > list.size()){
			throw new RuntimeException("out of size");
		}
		Integer integer = list.get(index);
		list.remove(integer);
		list.addFirst(integer);
		return integer;
	}

	@Override
	public String toString() {
		return "LruList{" +
				"list=" + list +
				'}';
	}
}
