/**
 * Created by sriram on 11/5/16.
 * 343. Integer Break   QuestionEditorial Solution  My Submissions
 Total Accepted: 30022
 Total Submissions: 67735
 Difficulty: Medium
 Contributors: Admin
 Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.

 Show Hint
 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

 Subscribe to see which companies asked this question

 Show Tags

 */
public class IntegerBreak {
    public class Solution {
        public int integerBreak(int n) {
            int dp[]=new int[n+1];
            dp[0]=1;
            dp[1]=1;
            dp[2]=1;
            for(int i=3;i<=n;i++){
                int max=0;
                for(int j=1;j<=i/2;j++){
                    int p1=j*(i-j);
                    int p2=j*dp[i-j];
                    int p3=dp[j]*(i-j);
                    int p4=dp[j]*dp[i-j];
                    int m=max(p1,p2,p3,p4);
                    if(m>max){
                        max=m;
                    }
                }
                dp[i]=max;
            }
            return dp[n];
        }
        public int max(int p1,int p2,int p3,int p4){
            if(p1>=p2 && p1>=p3 && p1>=p4){
                return p1;
            } else if(p2>=p1 && p2>=p3 && p2>=p4){
                return p2;
            } else if(p3>=p1 && p3>=p2 && p3>=p4){
                return p3;
            }
            return p4;
        }
    }
}
