package com.cloud.demo.link;

import org.junit.Test;

import static com.cloud.demo.PrintUtils.print;


/**
 * 链表相关练习
 *
 * @author: wangjing
 * @date 2023/6/6
 **/
public class LinkTest {


	@Test
	public void linkInit() {

		print(init().toString());

	}

	public ListNode init() {
		//链表初始化
		//1->3->2->4
		ListNode n0 = new ListNode(1);
		ListNode n3 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n4 = new ListNode(4);

		n0.next = n3;
		n3.next = n2;
		n2.next = n4;
		return n0;
	}

	@Test
	public void insert() {
		ListNode link = init();

		ListNode n66 = new ListNode(66);
		insert(link, n66);
	}

	public void insert(ListNode node, ListNode P) {
		P.next = node.next;
		node.next = P;
		print(node.toString());
	}

	@Test
	public void remove() {
		ListNode link = init();
		removeNodeNext(link);
	}

	/* 删除链表的节点 n0 之后的首个节点 */
	public void removeNodeNext(ListNode n0) {
		if (n0.next == null) {
			return;
		}
		ListNode P = n0.next;
		ListNode n1 = P.next;
		n0.next = n1;

		print(n0.toString());
	}

	@Test
	public void access() {
		//1->3->2->4
		ListNode link = init();
		print(access(link, 3).toString());
	}

	ListNode access(ListNode head, int index) {
		for (int i = 0; i < index; i++) {
			if (head == null) {
				return null;
			}
			head = head.next;
		}
		return head;
	}

	@Test
	public void find() {
		//1->3->2->4
		ListNode link = init();

		int i = find(link, 1);
		print(i + "");
	}

	/* 在链表中查找值为 target 的首个节点 */
	int find(ListNode head, int target) {
		int index = 0;
		while (head != null) {
			if (head.val == target) {
				return index;
			}
			head = head.next;
			index++;
		}
		return -1;
	}
	
	@Test
	public void reversal(){
		//1->3->2->4
		ListNode link = init();
		print(reversal(link).toString());
	}

	ListNode reversal(ListNode head){
		ListNode newHead = null;
		while (head !=null){
			ListNode newNode = new ListNode(head.val);
			newNode.next = newHead;
			newHead = newNode;
			head = head.next;
		}
		return newHead;
	}
}
