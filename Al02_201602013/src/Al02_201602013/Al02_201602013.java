package Al02_201602013;

public class Al02_201602013 {
	public static void main(String args[]) {
		DataIO dataio = new DataIO();

		mergeSort(dataio, "test_10.txt");
		mergeSort(dataio, "test_100.txt");
		mergeSort(dataio, "test_1000.txt");

	}

	private static void mergeSort(DataIO io, String fileName) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		io.readDataSet(fileName, al);
		al.sort_merSort();
		io.writeDataSet("Merge_" + fileName, al.arrIterator());
	}

//	private static void QuickSort(DataIO io, String fileName) {
//		DoublyLinkedList<Node> dll = new DoublyLinkedList<Node>();
//		io.readDataSet(fileName, dll);
//		dll.sort_bubbleSort();
//		io.writeDataSet("Bubble_" + fileName, dll.ddlIterator());
//	}
}
