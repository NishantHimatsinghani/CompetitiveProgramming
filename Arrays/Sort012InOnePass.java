package Arrays;

public class Sort012InOnePass {

    private static void SortOnePass(int[] input){
        int n = input.length;
        int zero = -1;
        int one = 0;
        int two = n;

        while(one < two){
            int value = input[one];
            int temp = 0;
            switch(value){

                case 0:
                    zero++;
                    temp = input[zero];
                    input[zero] = 0;
                    input[one] = temp;
                    one++;
                    break;

                case 1 :
                    one++;

                    break;

                case 2 :
                    two--;
                    temp = input[two];
                    input[two] = 2;
                    input[one] = temp;

                    break;

            }

        }
        return;

    }
    

    public static void main(String[] args){
        int[] input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

        SortOnePass(input);
        printArr(input);

    }

    private static void printArr(int[] input){
        for(int ele : input){
            System.out.print(ele + " ");
        }
    }



}
