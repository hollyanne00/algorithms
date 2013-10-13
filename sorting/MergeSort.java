public class MergeSort {
	
	private int[] nums;

	public void sort(int[] nums) {
		this.nums = nums;
		int len = nums.length;
		partition(0, len);
	}

	public void partition(int a, int b){
		if(b-a<2){ 
			return; }
		else {
			partition(a, a+(b-a)/2);
			partition(a+(b-a)/2, b);
			merge(a, a+(b-a)/2, b);
			return;
		}
	}

	public void merge(int a, int b, int c){
		int[] aux = new int[c-a];
		int i=a;
		int j=b;
		int k=0;
		while(i<b&&j<c){
			if(nums[i]<nums[j]){
				aux[k] = nums[i];
				i++;
			} else {
				aux[k] = nums[j];
				j++;
			}
			k++;
		}
		while(i<b){
			aux[k] = nums[i];
			k++;
			i++;
		}
		while(j<c){
			aux[k] = nums[j];
			k++;
			j++;
		}

		k=0;
		i=a;
		while(k<aux.length){
			nums[i]=aux[k];
			i++; k++;
		}
	}

	public static void main(String[] args){

		int[] nums = new int[]{10, 5, 3, 1, 7, 6, 4, 8, 9};
		MergeSort m = new MergeSort();
		m.sort(nums);

		for(int i : nums){
			System.out.print(i+" ");
		}

	}

}