package com.limbo.sort;

public class BucketSort extends BaseSort {

	@Override
	public void sort(int[] arr) {

		if (arr == null || arr.length < 2)
			return;

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > max)
				max = arr[i];

		int[] buckets = new int[max + 1];

		for (int i = 0; i < arr.length; i++)
			buckets[arr[i]]++;

		for (int i = 0, j = 0; i < buckets.length; i++)
			while (buckets[i]-- > 0)
				arr[j++] = i;

	}

	@Override
	public int[] generateRandomArray() {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) ((maxValue + 1) * Math.random());
		return arr;
	}

}
