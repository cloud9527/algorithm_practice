package com.cloud.demo.leetcode;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: wangjing
 * @date 2023/4/24
 **/
public class reverseWords151 {
	public static void main(String[] args) {
		String s = "a good   example";
		String s1 = "  hello world  ";
		String s2 = "the sky is blue";
		System.out.println(reverseWords2(s));
		//System.out.println(reverseWords(s1));
		//System.out.println(reverseWords(s2));
	}


	public static String reverseWords(String s) {
		s = s.trim();
		List<String> strings = Arrays.asList(s.split("\\s+"));
		Collections.reverse(strings);
		return String.join(" ",strings);
	}

	public static String reverseWords2(String s) {
		s = ' ' + s;
		int n = s.length();
		StringBuilder ans = new StringBuilder();
		for (int left = n - 1, right = n; left >= 0; left--) {
			char ch = s.charAt(left);
			if (ch == ' ') {
				if (left + 1 < right) {
					ans.append(s, left + 1, right).append(' ');
				}
				right = left;
			}
		}
		return ans.substring(0, ans.length() - 1);
	}
}
