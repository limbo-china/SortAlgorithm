package com.limbo.sort;

public class ShellSort extends BaseSort {

	@Override
	public void sort(int[] arr) {

		if (arr == null || arr.length < 2)
			return;

		int gap = arr.length / 2;
		while (gap != 0) {
			for (int i = 0; i < gap; i++)
				for (int j = i + gap; j < arr.length; j = j + gap)
					while ((j >= gap) && arr[j] < arr[j - gap]) {
						swap(arr, j, j - gap);
						j = j - gap;
					}
			gap = gap / 2;
		}

	}
}
