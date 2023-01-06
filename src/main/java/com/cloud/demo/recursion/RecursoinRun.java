package com.cloud.demo.recursion;

/**
 * 递归算法
 * @author: wangjing
 * @date 2023/1/6
 **/
public class RecursoinRun {

	public static void main(String[] args) {
		System.out.println(add(5));
		// 5+ add(5-1)
		// 5 + 4 +(4-1)
		// 5+4+3+(3-1)
		// 5+4+3+2+(2-1)
		// 5+4+3+2+1
		// 5+4+3+3
		// 5+4+6
		// 5+10
	}
	//从自身一直加到1 
	public static int add(int i) {
		if (i == 1) return 1;
		return i + add(i - 1);
	}

}
