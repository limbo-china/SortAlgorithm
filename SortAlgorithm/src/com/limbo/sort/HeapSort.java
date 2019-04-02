package com.limbo.sort;

public class HeapSort extends BaseSort {

	@Override
	public void sort(int[] arr) {

		if (arr == null || arr.length < 2)
			return;
		int size = 0;

		// construct heap
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i, arr[i]);
			size++;
		}

		// heap sort
		while (size > 0) {
			swap(arr, 0, --size);
			heapify(arr, 0, size);
		}
	}

	private void heapInsert(int[] arr, int pos, int ele) {
		arr[pos] = ele;
		int p = parent(pos);
		while (p != -1 && arr[p] < arr[pos]) {
			swap(arr, p, pos);
			pos = p;
			p = parent(pos);
		}
	}

	private void heapify(int[] arr, int pos, int size) {

		int lc = leftChild(pos, size);
		int rc = rightChild(pos, size);
		while (lc != -1) {
			int max = pos;
			if (lc != -1)
				max = (arr[max] < arr[lc]) ? lc : max;
			if (rc != -1)
				max = (arr[max] < arr[rc]) ? rc : max;
			if (max == pos)
				break;
			swap(arr, max, pos);
			pos = max;
			lc = leftChild(pos, size);
			rc = rightChild(pos, size);
		}

	}

	private int parent(int i) {
		if (i == 0)
			return -1;
		return (i - 1) / 2;
	}

	private int leftChild(int i, int size) {
		return (2 * i + 1 >= size) ? -1 : (2 * i + 1);
	}

	private int rightChild(int i, int size) {
		return (2 * i + 2 >= size) ? -1 : (2 * i + 2);
	}
}
