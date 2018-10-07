package Al02_201602013;

public class Al02_201602013 {
	public static void main(String args[]) {
		DataIO dataio = new DataIO();

		System.out.println("<<Merge Sort Length 8>>");
//		mergeSort(dataio, "test_10.txt");
		mergeSort(dataio, "test_100.txt");
		mergeSort(dataio, "test_1000.txt");

		
		System.out.println("\n\n<<Quick Sort>>");
//		QuickSort(dataio, "test_10.txt");
		QuickSort(dataio, "test_100.txt");
		QuickSort(dataio, "test_1000.txt");
	}

	private static void mergeSort(DataIO io, String fileName) {
		ArrayList<Integer> mr = new ArrayList<Integer>();
		io.readDataSet(fileName, mr);
		
		System.out.print(fileName + " count : ");
		mr.sort_mergeSort();
		
		io.writeDataSet("Merge_" + fileName, mr.arrIterator());
		System.out.println("");
	}

	private static void QuickSort(DataIO io, String fileName) {
		ArrayList<Integer> qcRE = new ArrayList<Integer>(1);	//오른쪽 맨 끝 PIVOT을 했을 경우
		ArrayList<Integer> qcRD = new ArrayList<Integer>(2);	//RANDOM하게 했을 경우
		io.readDataSet(fileName, qcRE);
		io.readDataSet(fileName, qcRD);
		
		System.out.println(fileName + " count : ");
		System.out.print("- Right End pivot : ");
		qcRE.sort_quickSort();
		System.out.println("");
		System.out.print("- Random pivot : ");
		qcRD.sort_quickSort();
		
		io.writeDataSet("QuickRightEnd_" + fileName, qcRE.arrIterator());
		io.writeDataSet("QuickRandom_" + fileName, qcRD.arrIterator());
		System.out.println("\n\n");
	}
}
