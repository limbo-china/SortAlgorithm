package com.limbo.sort;

public class RadixSort extends BaseSort {

	@Override
	public void sort(int[] arr) {

		if (arr == null || arr.length < 2)
			return;
		int maxBits = maxBits(arr);

		int[] count = new int[10];
		int[] help = new int[arr.length];

		for (int i = 0; i < maxBits; i++) {
			for (int j = 0; j < count.length; j++)
				count[j] = 0;
			for (int j = 0; j < arr.length; j++)
				count[digit(arr[j], i)]++;
			for (int j = 1; j < count.length; j++)
				count[j] = count[j] + count[j - 1];
			for (int j = arr.length - 1; j >= 0; j--) {
				int digit = digit(arr[j], i);
				help[count[digit] - 1] = arr[j];
				count[digit]--;
			}
			for (int j = 0; j < arr.length; j++)
				arr[j] = help[j];
		}
	}

	private int maxBits(int[] arr) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int res = 0;
		while (max != 0) {
			res++;
			max /= 10;
		}
		return res;
	}

	private int digit(int i, int digit) {
		int res = 0;
		while (digit >= 0) {
			res = i % 10;
			i = i / 10;
			digit--;
		}

		return res;
	}

	@Override
	public int[] generateRandomArray() {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) ((maxValue + 1) * Math.random());
		return arr;
	}

}
