package Al03_201602013;

public class Al03_201602013 {
	public static void main(String args[]) {
		DataIO dataio = new DataIO();

//		heapSort(dataio, "test_10.txt");
		heapSort(dataio, "test_100.txt");
		heapSort(dataio, "test_1000.txt");
		
//		countingSort(dataio, "test_10.txt");
		countingSort(dataio, "test_100.txt");
		countingSort(dataio, "test_1000.txt");
		
	}

	private static void heapSort(DataIO io, String fileName) {
		ArrayList<Integer> maxheapsort = new ArrayList<Integer>();
		ArrayList<Integer> minheapsort = new ArrayList<Integer>();
		io.readDataSet(fileName, maxheapsort);
		io.readDataSet(fileName, minheapsort);
		
		maxheapsort.max_heap_sort();
		minheapsort.min_heap_sort();
		
		io.writeDataSet("MaxHeap_" + fileName, maxheapsort.arrIterator());
		System.out.println(fileName + " MaxHeap count : " + maxheapsort.getTimeComplexity());
		io.writeDataSet("MinHeap_" + fileName, minheapsort.arrIterator());
		System.out.println(fileName + " MinHeap count : " + minheapsort.getTimeComplexity());
		System.out.println("");
	}

	private static void countingSort(DataIO io, String fileName) {
		ArrayList<Integer> countingsort = new ArrayList<Integer>();
		io.readDataSet(fileName, countingsort);
		
		countingsort.counting_sort();
		
		io.writeDataSet("Counting_" + fileName, countingsort.arrIterator());
		System.out.println(fileName + " Counting count : " + countingsort.getTimeComplexity());
		System.out.println("");
	}
}
