package com.limbo.sort;

public class TwoPartitionRandomQuickSort extends TwoPartitionQuickSort {

	@Override
	protected int partition(int[] arr, int left, int right) {

		int less = left;
		int random = left + (int) ((right - left) * Math.random());
		swap(arr, random, right);
		for (int i = left; i < right; i++)
			if (arr[i] < arr[right])
				swap(arr, i, less++);
		swap(arr, right, less);

		return less;
	}

}
