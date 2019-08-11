package Introduction;

import CtCILibrary.AssortedMethods;

public class MergeSort {	

public static void mergesort(int[] array) {
	int[] helper = new int[array.length];
	mergesort(array, helper, 0, array.length - 1);
}

public static void mergesort(
	int[] array, int[] helper, int low, int high) {
	if(low >= high) return;
	int middle = (low + high) / 2;
	mergesort(array, helper, low, middle);
	mergesort(array, helper, middle + 1, high);
	merge(array, helper, low, middle, high);
}

public static void merge(
	int[] array, int[] helper,
	int low, int middle, int high) {
	for (int i = low; i <= high; i++)
		helper[i] = array[i];

	int hLeft = low;
	int hRight = middle + 1;
	int aIndex = low;

	while (hLeft <= middle && hRight <= high) {
		if (helper[hLeft] <= helper[hRight]) {
			array[aIndex] = helper[hLeft];
			hLeft++;
		} else {
			array[aIndex] = helper[hRight];
			hRight++;
		}
		aIndex++;
	}

	/* Copy the rest of the left side of the array
	 * into the target array */
	int remaining = middle - hLeft;
	for (int i = 0; i <= remaining; i++)
		array[aIndex + i] = helper[hLeft + i];
}

public static void main(String[] args) {
	int size = 7;
	//int[] array = AssortedMethods.randomArray(size, 0, size - 1);
	int[] array = {38, 27, 43, 3, 9, 82, 10};
	AssortedMethods.printIntArray(array);
	// for (int i = 0; i < size; i++) {
	// 	validate[array[i]]++;
	// }
	mergesort(array);
	// for (int i = 0; i < size; i++) {
	// 	validate[array[i]]--;
	// }		
	AssortedMethods.printIntArray(array);
	// for (int i = 0; i < size; i++) {
	// 	if (validate[i] != 0 || (i < (size-1) && array[i] > array[i+1])) {
	// 		System.out.println("ERROR");
	// 	}
	// }
}

}
