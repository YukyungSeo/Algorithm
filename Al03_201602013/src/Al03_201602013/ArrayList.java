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
		// heap sort�� ��� root�� 1���� ����
		// counting sort�� 1�� ������ �����ϵ��� ��
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
		// �� ó�� �� ����
		build_max_heap();

		// �� �� ���ҿ� ��Ʈ�� ��ġ�� �ٲپ ����(��Ʈ�� ���� ū �����̹Ƿ� �������� ���� ������ ������ ����)
		// �� �� ���Ҵ� ���� ������ ġ�� heap������ �Ѵ�.
		for (int lastindex = size; lastindex > 0; lastindex--) {
			swap(1, lastindex);
			max_heapify(lastindex, 1);
		}
	}

	public void min_heap_sort() {
		// �� ó�� �� ����
		build_min_heap();

		// �� �� ���ҿ� ��Ʈ�� ��ġ�� �ٲپ ����(��Ʈ�� ���� ���� �����̹Ƿ� �������� ���� ������ ������ ����)
		// �� �� ���Ҵ� ���� ������ ġ�� heap������ �Ѵ�.
		for (int lastindex = size; lastindex > 0; lastindex--) {
			swap(1, lastindex);
			min_heapify(lastindex, 1);
		}
	}

	public void counting_sort() {
		// ���� ū ������ ũ�⸸ŭ couning�� �迭�� �����Ѵ�.
		// counting sort�� 1���� �����ϹǷ� maxNum+1�Ͽ� �����Ѵ�.
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

		// ������ counting�迭�� index ���ڿ� ���� ���ڰ� ���� ��� �ϳ��� ������Ų��.
		itr = this.arrIterator();
		while (itr.hasNext()) {
			counting[itr.next()]++;
			this.timeComplexity++;
		}

		// ������ counting �迭�� �������� �����.
		for (int i = 1; i < counting.length; i++) {
			counting[i] = counting[i] + counting[i - 1];
			this.timeComplexity++;
		}

		// ���ο� �迭�� ����� ���ĵ� �迭�� �����Ѵ�.
		// ������ ���ڸ� �̿��Ͽ� ������ ��ġ�� ã�� �־��ش�.
		// �ϳ��� ������ ������ ������ ���ڸ� -1���־�� ���������� �ٸ� ������ ��ġ�� �����Ͽ� ���� �� �ִ�.
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

		// �ڽ� ���� ũ�� ��
		// �� �� Ŭ��� ���� ū������ �Ѵ�.
		if (left < size && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < size && arr[right] > arr[largest]) {
			largest = right;
		}

		// �ڽ��� �� Ŭ ��� ��ȯ
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

		// �ڽ� ���� ũ�� ��
		// �� �� �θ𺸴� ���� ��� ���� ���� ������ �Ѵ�.
		if (left < size && arr[left] < arr[smallest]) {
			smallest = left;
		}
		if (right < size && arr[right] < arr[smallest]) {
			smallest = right;
		}

		// �ڽ��� �� ���� ��� ��ȯ
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
				// heap sort�� ��� root�� 1���� ����
				// counting sort�� 1�� ������ �����ϵ��� ��
				return arr[next - 1 + 1];
			}
		}
	}
}