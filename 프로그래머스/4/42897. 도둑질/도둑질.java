class Solution {
    public int solution(int[] money) {
        int size = money.length;
        int[] dp1 = new int[size]; //첫 집 털
        int[] dp2 = new int[size]; //첫 집 안털
        
        dp1[0] = dp1[1] = money[0]; //첫집 털어서 가격 누적
        dp2[1] = money[1]; //두번째 집부터 터니까 가격 누젹
        
        for(int i = 2; i < size ; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        return Math.max(dp1[size-2], dp2[size-1]);
    }
}