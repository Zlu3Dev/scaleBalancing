package Latch;

import java.util.*;

public class scaleBalancing {

    //int[] input,int[] scale
    private static void scaleBalance() {
        Scanner scan = new Scanner(System.in);

        //declare the input value into an array.
        int[] input = new int[2];
        input[0] = scan.nextInt();
        input[1] = scan.nextInt();
        Arrays.sort(input);
        for (int i = 0; i < 2; i++) {
            if (i == input.length - 1) {
                System.out.println(input[i]);
            } else {
                System.out.print(input[i] + ",");
            }
        }

        //Given test data length
        System.out.println("Input testing data length:");
        int n = scan.nextInt();
        System.out.println("Testing data length is:" + n);
        int[] testData = new int[n];
        System.out.println("Input test data:");
        for (int i = 0; i < testData.length; i++) {
            testData[i] = scan.nextInt();
        }
        Arrays.sort(testData);
        System.out.println("Testing data are:");
        for (int i = 0; i < testData.length; i++) {
            if (i == testData.length - 1) {
                System.out.println(testData[i]);
            } else {
                System.out.print(testData[i] + ",");
            }
        }
        //Checking if they are balanced.
        System.out.println("Comparing results:");

        List<Integer> sumOne =  new ArrayList<>();
        List<Integer> sumTwo =  new ArrayList<>();
        int[] sum1 =  new int[n];
        for(int i = 0; i < n;i++){
            System.out.println(sum1[i]);
        }
        int[] sum2 =  new int[n];
        for(int i = 0; i < n;i++){
            System.out.println(sum2[i]);
        }
        //ArrayList<Integer> results = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                sumOne = subsets(sum1,input[0]);
                //System.out.print(sum1);
                sumTwo = subsets(sum2,input[1]);
                //System.out.print(sum2);

                if (sum1 == sum2 || input[1] == sumOne.get(i)) {
                    System.out.println(testData[i] + "," + testData[j]);
                } else {
                    System.out.println("No possible solution. Please try again!");
                    break;
                }
            }
        }
    }



    private static void helper(int[] nums, List<Integer> results, int i, int a){
        if(i < 0){
            System.out.println(results);
        }
        results.add(nums[i] + a);
        helper(nums,results, i - 1, a);
        results.remove(results.size() - 1);
        while( i > 0 && nums[i] == nums[ i -1]){
            i--;
        }
        helper(nums,results, i - 1, a);
    }
    public static List<Integer>  subsets(int[] num, int a) {
        List<Integer> list = new ArrayList<>();
        helper(num,new ArrayList<>(),0,a);
        return list;
    }

    public static void main(String[] args){
        System.out.println("Please enter two numbers:");
        scaleBalance();
    }
}
