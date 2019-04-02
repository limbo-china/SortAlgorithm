package com.limbo.sort;

public class SelectSort extends BaseSort {

	@Override
	public void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i; j < arr.length; j++)
				if (arr[j] < arr[minIndex])
					minIndex = j;
			swap(arr, i, minIndex);
		}
	}
}
