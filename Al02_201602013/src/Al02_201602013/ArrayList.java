package Al02_201602013;

import java.util.Iterator;

public class ArrayList<T> {
	private int[] arr;
	private int size;

	// construct
	public ArrayList() {
		arr = new int[10000];
		this.size = 0;
	}

	// getter & setter
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	// public method
	public void append(int element) {
		arr[size] = element;
		size++;
	}

	public void sort_mergeSort() {
		mergeSort(0, size - 1);
	}

	public void sort_quickSort() {
		quickSort(0, size-1);
	}

	public String toString() {
		Iterator<Integer> itr = new ArrIterator<Integer>();
		String str = "";
		while (itr.hasNext()) {
			str += itr.next() + "\n";
		}
		return str;
	}

	// private method
	private void mergeSort(int start, int end) {
		if (end - start < 4) {
			// 4개가 된 순간부터 insertion
			insertionSort(start, end);
		} else {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
	}

	private void merge(int start, int mid, int end) {
		int[] tmp = new int[size];
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}
		int point1 = start;
		int point2 = mid + 1;
		int index = start;

		while (point1 <= mid && point2 <= end) {
			if (tmp[point1] <= tmp[point2]) {
				arr[index] = tmp[point1];
				point1++;
			} else {
				arr[index] = tmp[point2];
				point2++;
			}
			index++;
		}
		while (point1 <= mid) {
			arr[index] = tmp[point1];
			index++;
			point1++;
		}
	}

	private void insertionSort(int start, int end) {
		int index = start;

		while (index <= end) {
			int point = index;

			while (point <= end) {
				int min = arr[point];
				int minp = point;

				for (int i = point; i <= end; i++) {
					if (arr[i] < min) {
						min = arr[i];
						minp = i;
					}
				}
				arr[minp] = arr[point];
				arr[point] = min;
				point++;
			}
			index++;
		}
	}
	private void quickSort(int start, int end) {
		int pivot = arr[end];
		int index = partition(pivot, start, end-1);
		
		swap(index, end);
		
		if(start < index-1) {
			quickSort(start, index-1);
		}
		if(index < end-1) {
			quickSort(index+1, end);
		}
	}
	private int partition(int pivot, int start, int end) {
		while(start <= end) {
			while(arr[start] < pivot && start < end) start++;
			while(arr[end] > pivot && start < end) end--;
			
			//if(start <= end) {
			swap(start, end);
			
			start++;
			end--;
			//}
		}
		
		return start;
	}
	private void swap(int p, int q) {
		int element = arr[p];
		arr[p] = arr[q];
		arr[q] = element;
	}
	
	// Iterator

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrIterator<T> arrIterator() {
		return new ArrIterator();
	}

	@SuppressWarnings("hiding")
	private class ArrIterator<T> implements Iterator<Integer> {
		int next = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (this.next != size);
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			if (this.next == size) {
				return null;
			} else {
				this.next++;
				return arr[next - 1];
			}
		}
	}
}