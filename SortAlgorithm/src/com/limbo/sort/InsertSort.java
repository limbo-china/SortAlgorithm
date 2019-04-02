package com.limbo.sort;

public class InsertSort extends BaseSort {

	@Override
	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = i; (j > 0) && (arr[j] < arr[j - 1]); j--)
				swap(arr, j, j - 1);
	}
}
