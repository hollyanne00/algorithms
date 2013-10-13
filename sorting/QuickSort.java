public class QuickSort {
	
	private int[] nums;

	public int[] sort(int[] a) {
		nums = a;
		quick(0, a.length-1);
		return nums;
	}

	public void quick(int a, int b){
		if((b-a)<1){ return; }
		int piv = nums[b];

		int i=a;
		int j=i;
		while(j<b){
			if(nums[j]<piv){
				swap(i,j);
				i++;
			}
			j++;
		}

		swap(i, b);
		quick(a, i-1);
		quick(i+1, b);
	}

	public void swap(int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args){

		//random
		int[] nums = new int[]{10, 5, 2, 7, 4, 1, 8, 6, 3, 7};
		QuickSort q = new QuickSort();
		nums = q.sort(nums);


		//worst case o(n^2)
		int nums2 = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
		q.sort(nums);
		
	}

}