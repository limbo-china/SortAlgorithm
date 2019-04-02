package com.limbo.sort;

public class TwoPartitionQuickSort extends BaseSort {

	@Override
	public void sort(int[] arr) {

		if (arr == null || arr.length < 2)
			return;

		quickSort(arr, 0, arr.length - 1);

	}

	private void quickSort(int[] arr, int left, int right) {

		if (left >= right) // 不可以仅写等于，因为right可能小于left
			return;

		int mid = partition(arr, left, right);
		quickSort(arr, left, mid - 1);
		quickSort(arr, mid + 1, right);

	}

	protected int partition(int[] arr, int left, int right) {

		int less = left;
		for (int i = left; i < right; i++)
			if (arr[i] < arr[right])
				swap(arr, i, less++);
		swap(arr, right, less);

		return less;
	}

}
