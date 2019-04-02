package com.limbo.sort;

public class ThreePartitionQuickSort extends BaseSort {

	@Override
	public void sort(int[] arr) {

		if (arr == null || arr.length < 2)
			return;

		quickSort(arr, 0, arr.length - 1);

	}

	private void quickSort(int[] arr, int left, int right) {

		if (left >= right) // 不可以仅写等于，因为right可能小于left
			return;

		int[] mid = partition(arr, left, right);
		quickSort(arr, left, mid[0] - 1);
		quickSort(arr, mid[1] + 1, right);

	}

	protected int[] partition(int[] arr, int left, int right) {

		int less = left;
		int more = right;
		int i = left;
		int sentinel = arr[right];
		while (i <= more)
			if (arr[i] < sentinel)
				swap(arr, i++, less++);
			else if (arr[i] == sentinel)
				i++;
			else
				swap(arr, i, more--);

		return new int[] { less, more };
	}
}
