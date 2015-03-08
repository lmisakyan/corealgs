package ru.corealgs.lists;

import java.util.ArrayList;
import java.util.List;

import ru.corealgs.common.list.Node;

public class Lists {
	private static int cnt = 1;
	private static int result;

	private static int getLength(Node head) {
		if (head == null)
			return 0;

		int cnt = 1;
		Node n = head;
		while (n.next != null) {
			cnt++;
			n = n.next;
		}
		return cnt;
	}

	private static void deleteDuplicatesFromNode(Node node) {
		int data = node.getData();
		Node prev = node;
		Node n = prev.next;
		do {
			if (n.getData() == data)
				prev.next = n.next;
			else
				prev = n;
			n = n.next;
		} while (n != null);
	}

	private static Node doReverseList(Node original, Node child) {
		Node n = new Node(original.getData());
		n.next = child;
		if (original.next == null) {
			return n;
		}

		return doReverseList(original.next, n);
	}

	public static Node reverseList(Node head) {
		if (head == null || head.next == null)
			return head;

		Node cur = head;
		Node prev = head.next;
		Node tmp = prev.next;

		prev.next = cur;
		cur.next = null;
		while (tmp != null) {
			cur = prev;
			prev = tmp;
			tmp = tmp.next;
			prev.next = cur;
		}
		return prev;
	}

	public static Node getReversedList(Node head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new Node(head.getData());

		return doReverseList(head.next, new Node(head.getData()));
	}

	public static void deleteDuplicates(Node head) {
		Node node = head;
		while (true) {
			if (node != null && node.next != null) {
				deleteDuplicatesFromNode(node);
				node = node.next;
			} else {
				return;
			}
		}
	}

	public static int getFromEnd(Node head, int k) {
		if (head == null)
			throw new IllegalArgumentException("Head of list must not be null");

		int index = getLength(head) - k;
		if (index < 0)
			throw new IllegalArgumentException(
					"Number of elements from end must not be greater than length of list");

		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}

		return node.getData();
	}

	public static int getFromEndRecursive(Node head, int k) {
		cnt = 1;
		Node n = head;

		if (n != null) {
			getFromEndRecursive(n.next, k);
			if (cnt == k) {
				result = n.getData();
				cnt++;
			} else if (cnt < k)
				cnt++;
		}
		return result;
	}

	public static void deleteFromList(Node node) {
		if (node.next != null) {
			node.setData(node.next.getData());
			node.next = node.next.next;
		} else
			throw new IllegalArgumentException(
					"Element must not be last element of list");
	}

	public static void moveElements(Node head, int m) {
		Node mid = null;
		Node n = head;
		boolean h = false;

		if (n.getData() >= m)
			h = true;

		while (n.next != null) {
			if (n.next.getData() < m) {
				if (mid != null || h) {
					Node tmp = n.next;
					n.next = tmp.next;
					if (mid != null) {
						tmp.next = mid.next;
						mid.next = tmp;
						mid = mid.next;
					} else {
						int data = tmp.getData();
						tmp.setData(head.getData());
						head.setData(data);
						tmp.next = head.next;
						head.next = tmp;
						mid = head;
					}
				}
			} else {
				if (mid == null && !h)
					mid = n;
			}
			if (n.next != null) {
				n = n.next;
			}
		}

	}

	public static int addTwoListsReverse(Node list1, Node list2) {
		int pow = 0;
		int first = 0;
		int second = 0;

		while (list1 != null) {
			first = first + list1.getData() * (int) Math.pow(10, pow);
			pow++;
			list1 = list1.next;
		}

		pow = 0;
		while (list2 != null) {
			second = second + list2.getData() * (int) Math.pow(10, pow);
			pow++;
			list2 = list2.next;
		}

		return first + second;
	}

	public static int addTwoLists(Node list1, Node list2) {
		StringBuilder first = new StringBuilder();
		StringBuilder second = new StringBuilder();

		while (list1 != null) {
			first.append(list1.getData());
			list1 = list1.next;
		}

		while (list2 != null) {
			second.append(list2.getData());
			list2 = list2.next;
		}
		return Integer.valueOf(first.toString())
				+ Integer.valueOf(second.toString());
	}

	private static boolean listContains(List<Node> list, Node n) {
		for (int i = 0; i < list.size(); i++)
			if (n == list.get(i))
				return true;
		return false;
	}

	public static Node getStartOfLoopAndRemove(Node head) {
		if (head == null)
			return null;

		List<Node> visited = new ArrayList<Node>();
		Node n = head;

		visited.add(n);
		while (n.next != null && !listContains(visited, n.next)) {
			visited.add(n.next);
			n = n.next;
		}

		Node result = n.next;
		n.next = null;
		return result;
	}

	public static boolean isPalindrome(Node list) {
		Node reversed = getReversedList(list);
		return reversed.equals(list);
	}

}
