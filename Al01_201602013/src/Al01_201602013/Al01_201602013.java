package Al01_201602013;

public class Al01_201602013 {
	public static void main(String args[]) {
		DataIO dataio = new DataIO();

//		insertionSort(dataio, "test_10.txt");
		insertionSort(dataio, "test_100.txt");
		insertionSort(dataio, "test_1000.txt");
		insertionSort(dataio, "test_10000.txt");
//
//		bubbleSort(dataio, "test_3.txt");
		bubbleSort(dataio, "test_100.txt");
		bubbleSort(dataio, "test_1000.txt");
		bubbleSort(dataio, "test_10000.txt");

//		selectionSort(dataio, "test_5.txt");
		selectionSort(dataio, "test_100.txt");
		selectionSort(dataio, "test_1000.txt");
		selectionSort(dataio, "test_10000.txt");
	}

	private static void insertionSort(DataIO io, String fileName) {
		DoublyLinkedList<Node> dll = new DoublyLinkedList<Node>();
		io.readDataSet(fileName, dll);
		dll.sort_insertionSort();
		io.writeDataSet("Insertion_" + fileName, dll.ddlIterator());
	}

	private static void bubbleSort(DataIO io, String fileName) {
		DoublyLinkedList<Node> dll = new DoublyLinkedList<Node>();
		io.readDataSet(fileName, dll);
		dll.sort_bubbleSort();
		io.writeDataSet("Bubble_" + fileName, dll.ddlIterator());
	}

	private static void selectionSort(DataIO io, String fileName) {
		DoublyLinkedList<Node> dll = new DoublyLinkedList<Node>();
		io.readDataSet(fileName, dll);
		dll.sort_selectionSort();
		io.writeDataSet("Selection_" + fileName, dll.ddlIterator());
	}
}
