package Al01_201602013;

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