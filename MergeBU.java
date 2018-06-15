public class mergeSort{
	private static Comparable[] aux;
	private static void merge(Comparable[] a,int lo, int mid, int hi){
		int i = lo, j = mid + 1;
		for(int k = lo; k <= hi; k++){
			if(i > mid) aux[k] = a[j++]; // array exhuasted
			else if(j > hi) aux[k] = a[i++];
			else if(less(a[j], a[i])) aux[k] = a[j++];
			else aux[k] = a[i++];
		}
	}

	private static void sort(Comparable[] a){
		//no recursion
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz < N; sz += sz)
			for(int lo = 0; lo < N-sz; lo += sz + sz)
				merge(a,lo, lo + sz - 1, Math.min(lo + sz + sz -1, N-1));
	}
}