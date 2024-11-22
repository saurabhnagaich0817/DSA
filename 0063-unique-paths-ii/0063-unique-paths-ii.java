class Solution {
    public int uniquePathsWithObstacles(int[][] o) {
        int m=o.length;
        int n=o[0].length;
        if(o[0][0]==1||o[m-1][n-1]==1){
            return 0;

        }
        int [][] dp=new int [m][n];
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            dp[i][0]=o[i][0]==1?0:dp[i-1][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j]=o[0][j]==1?0:dp[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(o[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];

                }else{
                    dp[i][j]=0;
                }
            }
        }
        return dp[m-1][n-1];
    }
}