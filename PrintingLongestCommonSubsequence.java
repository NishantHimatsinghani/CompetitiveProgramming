static int[] longestCommonSubsequence(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;    
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++ ){

           for(int j = 1; j <= m; j++){
               
               if(a[i-1] == b[j-1]) {
                   dp[i][j] = 1 + dp[i-1][j-1];

               }
               else{
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

               }

           }     


        }//done with the formation of the LCS matrix
        int max_lcs = dp[n][m];
        int[] result = new int[max_lcs];
        int i = n, j = m;
        while(i > 0 && j > 0 ){
            if(a[i-1] == b[j-1]){
                result[max_lcs-1] = a[i-1];
                i--;
                j--;
                max_lcs--;
            }

            else if (dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else j--;

        }
        return result;
    }
