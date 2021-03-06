package Al02_201602013;

import java.util.Iterator;
import java.util.Random;

public class ArrayList<T> {
	private int[] arr;
	private int size;
	private int count;
	private int pivotKinds;

	// construct
	public ArrayList() {
		arr = new int[10000];
		this.size = 0;
		this.count = 0;
	}
	public ArrayList(int pivotKinds) {
		arr = new int[10000];
		this.size = 0;
		this.count = 0;
		this.pivotKinds = pivotKinds;
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
		System.out.print(count + "");
	}

	public void sort_quickSort() {
		quickSort(0, size - 1);
		System.out.print(count + "");
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
			// 다른 case를 test해보고 싶다면 '4'를 원하는 숫자로 바꿀 수 있다.
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
			count++;
		}
		while (point1 <= mid) {
			arr[index] = tmp[point1];
			index++;
			point1++;
			count++;
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
				count++;
			}
			index++;
		}
	}

	private void quickSort(int left, int right) {
		if (left < right) {
			int mid = this.partition(left, right);
			this.quickSort(left, mid-1);
			this.quickSort(mid, right);
		}
	}

	private int partition(int left, int right) {
		int pivot = this.pivot(left, right);
		int toRight = left-1;
		int toLeft = right+1;
		do {
			do { toRight++; } while (arr[toRight] < pivot);
			do { toLeft--; } while (arr[toLeft] > pivot);
			if (toRight < toLeft) {
				swap(toRight, toLeft);
			}
		} while (toRight < toLeft);
		
		return toRight;
	}

	private int pivot(int left, int right) {
		if(pivotKinds == 1) {
			return arr[right];
		}else {
			Random rand = new Random();
			int  n = rand.nextInt(right - left) + 1;
			
			return arr[left + n];
		}
	}

	private void swap(int p, int q) {
		int element = arr[p];
		arr[p] = arr[q];
		arr[q] = element;
		count++;
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