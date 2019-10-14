public class UnboundedKnapsack {

    private static class Min_Remaining{
        int min_remaining;


    }


    // Complete the unboundedKnapsack function below.
    static int unboundedKnapsack(int k, int[] arr) {
        Min_Remaining MR = new Min_Remaining();
        MR.min_remaining = Integer.MAX_VALUE;
        boolean zero_flag = false;
        unboundedKnapsackUtil(k, arr, zero_flag, MR);

        return (k-MR.min_remaining);

    }

    public static void unboundedKnapsackUtil(int k, int[] arr, boolean zero_flag, Min_Remaining MR ){

        if(k < MR.min_remaining) MR.min_remaining = k;
       // System.out.println("Min Remaining = " + MR.min_remaining);
        if(k == 0) zero_flag = true;

        if(zero_flag) return;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= k){
                if(!zero_flag){
                    unboundedKnapsackUtil(k - arr[i], arr, zero_flag, MR);
                }
            }
        }
    }


    public static void main(String[] args){

        int[] input = {3,7,9};

        int k = 13;

        int nearest_k = unboundedKnapsack(k, input);

        System.out.println("Nearest value that can be achieved to " + k + " is " + nearest_k);


    }


}
