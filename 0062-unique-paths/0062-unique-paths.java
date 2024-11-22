class Solution {
    public int uniquePaths(int m, int n) {
        int [][]a=new int [n][m];
        for(int i=0;i<n;i++){
            for(int  j=0;j<m;j++){
                if(i==0||j==0){
                    a[i][j]=1;
                }
                else{
                    a[i][j]=a[i-1][j]+a[i][j-1];
                }
            }
        }
        return a[n-1][m-1];
        
    }
}