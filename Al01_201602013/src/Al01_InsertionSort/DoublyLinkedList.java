package Al01_InsertionSort;

import java.util.Iterator;

class DoublyLinkedList<T> {
	private Node head;
	private int size;

	// construct
	public DoublyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	public DoublyLinkedList(Node head) {
		this.head = head;
		this.size = 1;
	}

	// getter & setter
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// public method
	public Node append(Node node) {
		node.setNextNode(head);
		if(head != null) {
			head.setPreNode(node);
		}
		
		head = node;

		size++;

		return head;
	}

	public void sort_insertionSort() {
		DoublyLinkedList<Node> newList = new DoublyLinkedList<Node>();

		Iterator<Node> itr_test_10 = this.ddlIterator();
		while (itr_test_10.hasNext()) {
			newList.insertionSort(new Node(itr_test_10.next().getElement()));
		}

		head = newList.getHead();
	}

	public void sort_BubbleSort() {
		this.bubbleSort();
	}

	public String toString() {
		Iterator<Node> itr = new DLLIterator<Node>();
		String str = "";
		while(itr.hasNext()) {
			str += itr.next().getElement() + "\n";
		}
		return str;
	}

	// private method
	private void insertionSort(Node node) {
		int element = node.getElement();
		Node p = head;
		Node preNode = null;

		while (p != null && element > p.getElement()) {
			preNode = p;
			p = p.getNextNode();
		}

		if (p == head) {
			node.setNextNode(head);
			head = node;
		} else if (p == null) {
			preNode.setNextNode(node);
			node.setPreNode(preNode);
		} else {
			node.setNextNode(p);
			p.setPreNode(node);
			preNode.setNextNode(node);
			node.setPreNode(preNode);
		}

		size++;
	}

	private Node bubbleSort() {
		for (int p = 0; p<this.getSize(); p++) {
			Iterator<Node> itrq = this.ddlIterator();
			Node preq = head;
			Node q = itrq.next();;
			while (itrq.hasNext()) {
				q = itrq.next();
				preq = q.getPreNode();
				
				if(q.getElement() < preq.getElement()) {
					Node nextq = q.getNextNode();
					
					preq.setNextNode(nextq);
					// 마지막 node 지우기
					if(nextq != null)
						nextq.setPreNode(preq);
					
					// head부분과 그렇지 않은 부분 삭제했던 node preq 뒤에 추가
					if(preq == head) {
						q.setNextNode(preq);
						preq.setPreNode(q);
						head = q;
					}else {
						Node prepreq = preq.getPreNode();
						
						q.setNextNode(preq);
						preq.setPreNode(q);
						prepreq.setNextNode(q);
						q.setPreNode(prepreq);
					}
				}
			}
		}
		
		return head;
	}

//	 private Node selectionSort() {
//		 
//		 return head;
//	 }

	// Iterator

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DLLIterator<T> ddlIterator() {
		return new DLLIterator();
	}

	@SuppressWarnings("hiding")
	private class DLLIterator<T> implements Iterator<Node> {
		Node next = (Node) head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (this.next != null);
		}

		@Override
		public Node next() {
			// TODO Auto-generated method stub
			if (this.next == null) {
				return null;
			} else {
				Node element = this.next;
				this.next = (Node) this.next.getNextNode();
				return (Node) element;
			}
		}

	}
}