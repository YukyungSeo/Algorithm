package Al02_201602013;

public class Al02_201602013 {
	public static void main(String args[]) {
		DataIO dataio = new DataIO();

		mergeSort(dataio, "test_10.txt");
		mergeSort(dataio, "test_100.txt");
		mergeSort(dataio, "test_1000.txt");

		QuickSort(dataio, "test_10.txt");
		QuickSort(dataio, "test_100.txt");
		QuickSort(dataio, "test_1000.txt");
	}

	private static void mergeSort(DataIO io, String fileName) {
		ArrayList<Integer> mr = new ArrayList<Integer>();
		io.readDataSet(fileName, mr);
		mr.sort_mergeSort();
		io.writeDataSet("Merge_" + fileName, mr.arrIterator());
	}

	private static void QuickSort(DataIO io, String fileName) {
		ArrayList<Integer> qc = new ArrayList<Integer>();
		io.readDataSet(fileName, qc);
		qc.sort_mergeSort();
		io.writeDataSet("Quick_" + fileName, qc.arrIterator());
	}
}
