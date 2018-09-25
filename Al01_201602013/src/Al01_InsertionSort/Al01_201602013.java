package Al01_InsertionSort;

public class Al01_201602013 {
	public static void main(String args[]) {
		DataIO dataio = new DataIO();
		
//		insertionSort(dataio, "test_10.txt");
		insertionSort(dataio, "test_100.txt");
		insertionSort(dataio, "test_1000.txt");
		insertionSort(dataio, "test_10000.txt");
		
//		bubbleSort(dataio, "test_10.txt");
		bubbleSort(dataio, "test_100.txt");
		bubbleSort(dataio, "test_1000.txt");
		bubbleSort(dataio, "test_10000.txt");
	}
	
	private static void insertionSort(DataIO io, String fileName) {
		DoublyLinkedList<Node> dll = new DoublyLinkedList<Node>();
		io.readDataSet(fileName, dll);
		dll.sort_insertionSort();
		io.writeDataSet("Insertion_"+fileName, dll.ddlIterator());
	}
	
	private static void bubbleSort(DataIO io, String fileName) {
		DoublyLinkedList<Node> dll = new DoublyLinkedList<Node>();
		io.readDataSet(fileName, dll);
		dll.sort_BubbleSort();
		io.writeDataSet("Bubble_"+fileName, dll.ddlIterator());
	}
}

