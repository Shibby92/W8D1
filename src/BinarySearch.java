public class BinarySearch {

	public static void main(String[] args) {
		int[] niz = new int[] { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
		for (int i = 20; i < 32; i++)
			System.out.println(binarySearch(niz, i, 0, niz.length));
		int unos = TextIO.getInt();
		rekPrint(unos);
		System.out.println(rekSum(unos));

	}

	private static int rekSum(int unos) {
		if (unos > 0)
			unos += rekSum(unos - 1);
		return unos;

	}

	private static void rekPrint(int unos) {
		if (unos < 0) {
			return;
		}
		System.out.println(unos);
		rekPrint(unos - 1);
	}

	public static int binarySearch(int[] array, int find, int start, int end) {
		if (start >= end) {
			return-1;
			}
			int startEnd = (start + end) / 2;
			if (find == array[startEnd]) {
				return startEnd;
			} else if (find < array[startEnd]) {
				return binarySearch(array, find, start, startEnd);
			} else if (find > array[startEnd]) {
				return binarySearch(array, find, startEnd +1, end);
			}
		
		return -1;
		}
}
