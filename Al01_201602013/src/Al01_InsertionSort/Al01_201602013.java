package Al01_InsertionSort;

import java.io.*;
import java.util.*;

public class Al01_201602013 {
	public static void main(String args[]) {
		DataIO dataio = new DataIO();
		
		insertionSort(dataio, "test_100.txt");
		insertionSort(dataio, "test_1000.txt");
		insertionSort(dataio, "test_10000.txt");
	}
	
	private static void insertionSort(DataIO io, String fileName) {
		DoublyLinkedList<Node> dll = new DoublyLinkedList<Node>();
		io.readDataSet(fileName, dll);
		dll.sort_insertionSort();
		io.writeDataSet("sorted_"+fileName, dll.ddlIterator());
	}
}

class DataIO {

	// public method
	public void readDataSet(String fileName, DoublyLinkedList<Node> dl) {
		try {
			File file = new File("C:\\Users\\SeoYukyung\\eclipse-workspace\\Algorithm\\Al01_201602013", fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = "";
			while ((line = br.readLine()) != null) {
				dl.append(new Node(Integer.parseInt(line)));
				// System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void writeDataSet(String fileName, Iterator<Node> itr) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

			while (itr.hasNext()) {
				out.write(itr.next().toString());
				out.newLine();
			}

			out.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}

	}
}

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
		head = node;

		size++;

		return head;
	}
	
	public void sort_insertionSort(){
		DoublyLinkedList<Node> newList = new DoublyLinkedList<Node>();
		
		Iterator<Node> itr_test_10 = this.ddlIterator();
		while(itr_test_10.hasNext()){
			newList.insertionSort(new Node(itr_test_10.next().getElement()));
		}
		
		head = newList.getHead();
	}
	public Node insertionSort(Node node) {
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

		return head;
	}

	public Node add_BubbleSort() {
		return head;
	}

	public Node add_SelectionSort() {
		return head;
	}

	public String toString() {
		Node p = head;
		String str = "";
		while (p.getNextNode() != null) {
			str += p.getElement() + "\n";
			p = p.getNextNode();
		}
		return str;
	}

	// Iterator
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DLLIterator<T> ddlIterator(){
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
				this.next = (Node)this.next.getNextNode();
				return (Node) element;
			}
		}

	}
}

class Node {
	private Node preNode;
	private Node nextNode;
	private int element;

	// construct
	public Node(int data) {
		this.preNode = null;
		this.nextNode = null;
		this.element = data;
	}

	public Node(int data, Node preNode, Node nextNode) {
		this.preNode = preNode;
		this.nextNode = nextNode;
		this.element = data;
	}

	// getter & setter
	public Node getPreNode() {
		return preNode;
	}

	public void setPreNode(Node preNode) {
		this.preNode = preNode;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	// public method
	@Override
	public String toString() {
		return this.element + "";
	}
}