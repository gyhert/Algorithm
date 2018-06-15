public class mergeSort{
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++){
			if(i > mid) aux[k] = a[j++]; // array exhuasted
			else if(j > hi) aux[k] = a[i++];
			else if(less(a[j], a[i])) aux[k] = a[j++];
			else aux[k] = a[i++];
		}
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
		if(hi <= lo) return;
		int mid = lo + (hi -lo)/2;
		sort(aux, a, lo, mid);
		sort(aux, a, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
}