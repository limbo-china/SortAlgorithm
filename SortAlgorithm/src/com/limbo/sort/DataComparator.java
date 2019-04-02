package com.limbo.sort;

import java.util.Arrays;

public class DataComparator {

	private final static int testTime = 50000;

	public static void checkAlgorithm(Sort sortAlgorithm) {
		long start = System.currentTimeMillis();
		String sortName = sortAlgorithm.getClass().getSimpleName();
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = sortAlgorithm.generateRandomArray();
			int[] arr2 = copyArray(arr1);
			int[] arrTemp = copyArray(arr1);
			sortAlgorithm.sort(arr1);
			Arrays.sort(arr2);
			if (!isEqual(arr1, arr2)) {
				System.out.println(sortName + "-originArray-"
						+ Arrays.toString(arrTemp));
				System.out.println(sortName + "-false");
				System.out.println(sortName + "-MyResult-"
						+ Arrays.toString(arr1));
				System.out.println(sortName + "-CorrectResult-"
						+ Arrays.toString(arr2));
				return;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(sortName + "-true" + " Test times:" + testTime
				+ " Time lapse:" + (end - start) + "ms");
	}

	private static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	private static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		DataComparator.checkAlgorithm(new BubbleSort());
		DataComparator.checkAlgorithm(new InsertSort());
		DataComparator.checkAlgorithm(new SelectSort());
		DataComparator.checkAlgorithm(new MergeSort());
		DataComparator.checkAlgorithm(new BucketSort());
		DataComparator.checkAlgorithm(new TwoPartitionQuickSort());
		DataComparator.checkAlgorithm(new TwoPartitionRandomQuickSort());
		DataComparator.checkAlgorithm(new ThreePartitionQuickSort());
		DataComparator.checkAlgorithm(new HeapSort());
		DataComparator.checkAlgorithm(new RadixSort());
		DataComparator.checkAlgorithm(new ShellSort());
	}
}
