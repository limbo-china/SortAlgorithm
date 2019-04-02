package com.limbo.sort;

public interface Sort {
	public final static int maxSize = 500;
	public final static int maxValue = 100;

	public void sort(int[] arr);

	public int[] generateRandomArray();
}
