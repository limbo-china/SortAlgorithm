package com.limbo.sort;

public class MergeSort extends BaseSort {

	@Override
	public void sort(int[] arr) {
		if (arr == null || arr.length < 2)
			return;
		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int left, int right) {

		if (left == right)
			return;
		int mid = left + ((right - left) >> 1);
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	private void merge(int[] arr, int left, int mid, int right) {
		int[] help = new int[right - left + 1];

		int p = 0;
		int p1 = left;
		int p2 = mid + 1;

		while (p1 <= mid && p2 <= right)
			help[p++] = arr[(arr[p1] <= arr[p2]) ? p1++ : p2++];
		while (p1 <= mid)
			help[p++] = arr[p1++];
		while (p2 <= right)
			help[p++] = arr[p2++];

		for (int i = 0; i < help.length; i++)
			arr[left + i] = help[i];

	}

}
