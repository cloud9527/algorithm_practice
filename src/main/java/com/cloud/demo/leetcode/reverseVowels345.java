package com.cloud.demo.leetcode;

/**
 * @author: wangjing
 * @date 2023/4/23
 **/
public class reverseVowels345 {

	public static void main(String[] args) {
		reverseVowels345 reverseVowels345 = new reverseVowels345();
		String s = "hello";
		System.out.println(reverseVowels345.reverseVowels(s));
	}

	public String reverseVowels(String s) {
		int n = s.length();
		char[] chars = s.toCharArray();
		int i = 0, j = n - 1;
		while (i < j) {
			while (i < n & !isVowel(chars[i])) {
				++i;
			}
			while (j > 0 & !isVowel(chars[j])) {
				--j;
			}
			if (i<j){
				swap(chars,i,j);
				++i;
				--j;
			}
		}
		return new String(chars);
	}

	public boolean isVowel(char ch) {
		return "aeiouAEIOU".indexOf(ch) >= 0;
	}

	public void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
