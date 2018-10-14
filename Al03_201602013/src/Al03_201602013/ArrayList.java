package Al03_201602013;

import java.util.Iterator;

public class ArrayList<T> {
	private int[] arr;
	private int size;
	private int timeComplexity;

	// construct
	public ArrayList() {
		arr = new int[2000];
		this.size = 0;
		this.timeComplexity = 0;
	}

	// getter & setter
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTimeComplexity() {
		return timeComplexity;
	}

	public void seTtimeComplexity(int timeComplexity) {
		this.timeComplexity = timeComplexity;
	}

	// public method
	public void append(int element) {
		// heap sort일 경우 root는 1부터 시작
		// counting sort도 1일 때부터 시작하도록 함
		size++;
		arr[size] = element;
	}

	public String toString() {
		Iterator<Integer> itr = new ArrIterator<Integer>();
		String str = "";
		while (itr.hasNext()) {
			str += itr.next() + "\n";
		}
		return str;
	}

	public void max_heap_sort() {
		// 맨 처음 힙 정렬
		build_max_heap();

		// 맨 끝 원소와 루트의 위치를 바꾸어서 정렬(루트가 가장 큰 원소이므로 차례차례 빼서 끝으로 보내는 과정)
		// 맨 끝 원소는 없는 것으로 치고 heap정렬을 한다.
		for (int lastindex = size; lastindex > 0; lastindex--) {
			swap(1, lastindex);
			max_heapify(lastindex, 1);
		}
	}

	public void min_heap_sort() {
		// 맨 처음 힙 정렬
		build_min_heap();

		// 맨 끝 원소와 루트의 위치를 바꾸어서 정렬(루트가 가장 작은 원소이므로 차례차례 빼서 끝으로 보내는 과정)
		// 맨 끝 원소는 없는 것으로 치고 heap정렬을 한다.
		for (int lastindex = size; lastindex > 0; lastindex--) {
			swap(1, lastindex);
			min_heapify(lastindex, 1);
		}
	}

	public void counting_sort() {
		// 가장 큰 숫자의 크기만큼 couning할 배열을 생성한다.
		// counting sort는 1부터 시작하므로 maxNum+1하여 생성한다.
		int maxNum = 0;
		Iterator<Integer> itr = this.arrIterator();
		while (itr.hasNext()) {
			int tmp = itr.next();
			if (maxNum < tmp) {
				maxNum = tmp;
			}
			this.timeComplexity++;
		}
		int[] counting = new int[maxNum + 1];

		// 생성한 counting배열에 index 숫자와 같은 숫자가 있을 경우 하나씩 증가시킨다.
		itr = this.arrIterator();
		while (itr.hasNext()) {
			counting[itr.next()]++;
			this.timeComplexity++;
		}

		// 생성한 counting 배열을 누적으로 만든다.
		for (int i = 1; i < counting.length; i++) {
			counting[i] = counting[i] + counting[i - 1];
			this.timeComplexity++;
		}

		// 새로운 배열을 만들어 정렬된 배열을 생성한다.
		// 누적된 숫자를 이용하여 원소의 위치를 찾아 넣어준다.
		// 하나씩 정렬할 때마다 누적된 숫자를 -1해주어야 같은숫자의 다른 원소의 위치를 지정하여 넣을 수 있다.
		int[] newList = new int[size + 1];
		itr = this.arrIterator();
		while (itr.hasNext()) {
			int tmp = itr.next();
			newList[counting[tmp]] = tmp;
			counting[tmp]--;
			this.timeComplexity++;
		}

		arr = newList;
	}

	// private method
	private void build_max_heap() {
		for (int i = size / 2; i > 0; i--) {
			max_heapify(size, i);
		}
	}

	private void build_min_heap() {
		for (int i = size / 2; i > 0; i--) {
			min_heapify(size, i);
		}
	}

	private void max_heapify(int size, int index) {
		int left = index * 2;
		int right = (index * 2) + 1;
		int largest = index;

		// 자식 노드와 크기 비교
		// 둘 다 클경우 제일 큰놈으로 한다.
		if (left < size && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < size && arr[right] > arr[largest]) {
			largest = right;
		}

		// 자식이 더 클 경우 교환
		if (largest != index) {
			swap(largest, index);
			max_heapify(size, largest);
		}
		this.timeComplexity++;
	}

	private void min_heapify(int size, int index) {
		int left = index * 2;
		int right = (index * 2) + 1;
		int smallest = index;

		// 자식 노드와 크기 비교
		// 둘 다 부모보다 작을 경우 제일 작은 놈으로 한다.
		if (left < size && arr[left] < arr[smallest]) {
			smallest = left;
		}
		if (right < size && arr[right] < arr[smallest]) {
			smallest = right;
		}

		// 자식이 더 작을 경우 교환
		if (smallest != index) {
			swap(smallest, index);
			min_heapify(size, smallest);
		}
		this.timeComplexity++;
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
				// heap sort일 경우 root는 1부터 시작
				// counting sort도 1일 때부터 시작하도록 함
				return arr[next - 1 + 1];
			}
		}
	}
}