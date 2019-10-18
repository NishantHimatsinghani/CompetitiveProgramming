package Arrays;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CountTriplets {

    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);

        int[] input = {};
        Helper(input);

        }

        static void Helper(int[] input){
            HashSet<Integer> hs = new HashSet<Integer>();
            int n = input.length;

            for(int i = 0; i < n; i++){

                hs.add(input[i]);

            }
            int count = 0;
            for(int i = 0; i < n-1; i++){
                for(int j = i+1; j < n ; j++){
                    if(hs.contains(input[i] + input[j])) count++;
                }

            }
            System.out.println(count==0 ? -1 : count);
        }

}
