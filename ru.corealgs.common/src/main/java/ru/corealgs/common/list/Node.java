package ru.corealgs.common.list;

public class Node {

	public Node next = null;
	private int data;

	public Node(int i) {
		this.data = i;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = this;
		while (node != null) {
			sb.append(node.data + (node.next != null ? ", " : ""));
			node = node.next;
		}
		return "List [" + sb.toString() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Node)) {
			return false;
		}

		Node other = (Node) obj;
		Node node = this;
		while (node != null) {
			if (other == null) {
				return false;
			}

			if (other.data != node.data) {
				return false;
			}
			other = other.next;
			node = node.next;
		}

		return other == null;
	}

}
