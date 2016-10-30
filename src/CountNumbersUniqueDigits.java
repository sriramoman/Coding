/**
 * Created by sriram on 10/29/16.
 */
/*
Qn 357. Count Numbers with Unique Digits
        Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

        Example:
        Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100,
        excluding [11,22,33,44,55,66,77,88,99])

*/
public class CountNumbersUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n>10)
            return 0;
        if(n==0)
            return 1;
        if(n==1)
            return 10;
        if(n==2)
            return 91;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=10;
        dp[2]=91;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]-dp[i-2])*(11-i)+dp[i-1];
        }
        return dp[n];
    }
}
