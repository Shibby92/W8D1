/**
 * Program ispisuje broj indeksa clana niza ako trazeni broj od korisnika
 * postoji u nizu,a vraca -1 ako taj broj ne postoji u tom nizu
 * 
 * @author harisarifovic
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] niz = new int[] { 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
		// ispitivanje niza
		for (int i = 20; i < 32; i++)
			System.out.println(binarySearch(niz, i, 0, niz.length));
		int unos = TextIO.getInt();
		rekPrint(unos);
		System.out.println(rekSum(unos));

	}

	/**
	 * Rekurzivno sabiranje brojeva od nekog broja do nule
	 * 
	 * @param unos
	 *            pocetak sabiranja
	 * @return sumu tih brojeva
	 */
	private static int rekSum(int unos) {
		if (unos > 0)
			unos += rekSum(unos - 1);
		return unos;

	}

	/**
	 * Ispisuje brojeve od unosa do nule
	 * 
	 * @param unos
	 *            Broj od kojeg pocinje ispis
	 */
	private static void rekPrint(int unos) {
		if (unos < 0) {
			return;
		}
		System.out.println(unos);
		rekPrint(unos - 1);
	}

	/**
	 * Rekurzivna funkcija koja trazi uneseni korisnicki broj
	 * 
	 * @param array
	 *            Niz u kojem se trazi broj
	 * @param find
	 *            Broj koji se trazi
	 * @param start
	 *            pocetak niza
	 * @param end
	 *            kraj niza
	 * @return indeks na kojem se nalazi niz, osim ako ga nije nasao, onda vraca
	 *         -1
	 */
	public static int binarySearch(int[] array, int find, int start, int end) {
		if (start >= end) {
			return -1;
		}
		int startEnd = (start + end) / 2;
		if (find == array[startEnd]) {
			return startEnd;
		} else if (find < array[startEnd]) {
			return binarySearch(array, find, start, startEnd);
		} else if (find > array[startEnd]) {
			return binarySearch(array, find, startEnd + 1, end);
		}

		return -1;
	}
}
