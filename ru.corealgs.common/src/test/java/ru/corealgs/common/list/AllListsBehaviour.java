package ru.corealgs.common.list;

import ru.corealgs.common.list.Node;

public class AllListsBehaviour {

	protected Node newList(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}

		Node curr = new Node(arr[0]);
		Node head = curr;
		for (int i = 1; i < arr.length; i++) {
			Node node = new Node(arr[i]);
			curr.next = node;
			curr = node;
		}
		return head;
	}

}
