public class RodCutting {

	public int maxProfit(int[] prices, int n){
		int[] memo = new int[n+1];
		memo[0] = 0;
		for(int i=1;i<=n;i++){
			int max =0;
			for(int j=1;j<=i;j++){
				int cost = prices[j-1] + memo[i-j];
				if(cost>max){
					max = cost;
				}
			}
			memo[i] = max;
		}
		return memo[n];
	}

}