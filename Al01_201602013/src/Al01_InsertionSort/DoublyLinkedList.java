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
		if (head != null) {
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

	public void sort_bubbleSort() {
		if (this.getSize() != 0)
			this.bubbleSort();
	}

	public void sort_selectionSort() {
		if (this.getSize() != 0)
			this.selectionSort();
	}

	public String toString() {
		Iterator<Node> itr = new DLLIterator<Node>();
		String str = "";
		while (itr.hasNext()) {
			str += itr.next().getElement() + "\n";
		}
		return str;
	}

	// private method
	private void insert(Node preNode, Node nextNode, Node newNode) {
		if(nextNode == head) {
			newNode.setNextNode(nextNode);
			nextNode.setPreNode(newNode);
			head = newNode;
		}else if(nextNode == null) {
			preNode.setNextNode(newNode);
			newNode.setPreNode(preNode);
		} else {
			newNode.setNextNode(nextNode);
			nextNode.setPreNode(newNode);
			preNode.setNextNode(newNode);
			newNode.setPreNode(preNode);
		}
		
		size++;
	}

	private void remove(Node node) {
		Node preNode = node.getPreNode();
		Node nextNode = node.getNextNode();
		
		if(node == head) {
			nextNode.setPreNode(null);
			head = nextNode;
		}else if(nextNode == null) {
			preNode.setNextNode(nextNode);
		} else {
			preNode.setNextNode(nextNode);
			nextNode.setPreNode(preNode);
		}
		
		node.setNextNode(null);
		node.setPreNode(null);
		
		size--;
	}

	private void insertionSort(Node node) {
		int element = node.getElement();
		Node p = head;
		Node preNode = null;

		// ���� ��ġ ã��
		while (p != null && element > p.getElement()) {
			preNode = p;
			p = p.getNextNode();
		}
		
		// ���� �߰�
		this.insert(preNode, p, node);
	}

	private void bubbleSort() {
		for (int p = 0; p < this.getSize(); p++) {
			Iterator<Node> itrq = this.ddlIterator();
			Node preq = head;
			Node q = itrq.next();

			while (itrq.hasNext()) {
				q = itrq.next();
				preq = q.getPreNode();

				if (q.getElement() < preq.getElement()) {
					// ���� ���� ����
					this.remove(q);

					// preq �ٷ� �ڿ� q ���� �߰� ����
					Node prepreq = preq.getPreNode();
					this.insert(prepreq, preq, q);
				}
			}
		}
	}

	private void selectionSort() {
		Iterator<Node> itr = this.ddlIterator();		
		
		while (itr.hasNext()) {
			Node p = itr.next();
			Node q = p;
			Node r = q;

			// �ּ� ���� ã��
			while (q != null) {
				if (q.getElement() < r.getElement())
					r = q;
				q = q.getNextNode();
			}

			// ���� ����(r)�� ���� �� ���� ����(p)�� ��ġ �ٲ�ġ��
			if(r.getPreNode() == p){ 
				// ���޾� �ִ� ������ ��ġ�� �ٲ� ���
				this.remove(r);
				
				Node prep = p.getPreNode();
				this.insert(prep, p, r);
			}else if(r != p){
				// �Ÿ� ���� �ִ� ������ ��ġ�� �ٲ� ���
				Node prer = r.getPreNode();
				this.remove(r);
				
				Node prep = p.getPreNode();
				this.insert(prep, p, r);
				
				this.remove(p);
				this.insert(prer, prer.getNextNode(), p);
			}
		}
	}

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