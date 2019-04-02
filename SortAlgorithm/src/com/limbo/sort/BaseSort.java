package com.limbo.sort;

public class BaseSort implements Sort {

	@Override
	public void sort(int[] arr) {
	}

	@Override
	public int[] generateRandomArray() {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random())
					- (int) (maxValue * Math.random());
		}
		return arr;
	}

	protected void swap(int[] arr, int i, int j) {
		if (i == j)
			return; // 必须满足i!=j，才能正确交换；若i==j，则会产生0值
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

}
