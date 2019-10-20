package DynamicProgramming;

public class BuySellStockKTimesMax {

    private static void MaxProfitSlow(int[] input, int k){
        int n = input.length;
        int[][] dp = new int[k+1][n];

        for(int i = 1 ; i <= k ; i++){ //i is the transactions

            for(int j = 1 ; j < n ; j++){ //j is the day..0-based index

                int no_trans = dp[i][j-1];
                int do_trans = Integer.MIN_VALUE;
                for(int m = 0 ; m < j ; m++){

                    do_trans = Math.max(do_trans, input[j]-input[m] + dp[i-1][m]);

                }

                dp[i][j] = Math.max(no_trans, do_trans);


            }


        }
        System.out.print("Maximum Profit Possible is : " + dp[k][n-1]);

        //printSolution(dp, input);


    }

    private static void printSolution(int[][] dp, int[] input){
        int i = dp.length;
        int j = input.length;

    }

    public  static  void  main(String[] args){
        int[] input = {10, 22, 5, 75, 65, 80};

        int k = 2;

        MaxProfitSlow(input, k);


    }

}
