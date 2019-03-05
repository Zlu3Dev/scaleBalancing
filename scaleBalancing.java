package Latch;

import java.util.*;

public class scaleBalancing {

    public static String balanceCaculation(String[] strArray) {
        //Caculate  the first array so we know the difference will be the abs(first - second) values.
        String[] leftside= getlistValue(strArray[0]);
        int diff = Math.abs(Integer.valueOf(leftside[0]) - Integer.valueOf(leftside[1]));

        //Getting the value for the second array
        String[] rightside= getlistValue(strArray[1]);

        //check if the rightsdie has the value == diff.
        for (int i= 0; i < rightside.length; i++) {
            //check if there is a value == diff
            if (Integer.valueOf(rightside[i]) == diff) {
                return rightside[i];
            }
            for (int j= i+1; j < rightside.length; j++) {
                //check if the sum of the two values from the rightside == diff
                if (Integer.valueOf(rightside[i]) + Integer.valueOf(rightside[j]) == diff) {
                    return "" + rightside[i] + "," + rightside[j];
                    //check the minus for rightside of two values == diff
                } else if (Integer.valueOf(rightside[j]) - Integer.valueOf(rightside[i]) == diff) {
                    return "" + rightside[i] + "," + rightside[j];
                }
            }
        }
        return "No possible solution. Please try again";
    }

    //Using regex to split the the string based on the whitespace. so we will get the weights.
    public static String[] getlistValue(String values) {
        String[] rightside = values.substring(1,values.length()-1).split(",\\s");
        return rightside;
    }
    
    public static void main (String[] args) {
        // Using the format by only change the variables.
       System.out.print(balanceCaculation(new String[] {"[4, 7]", "[1, 2, 3, 6, 14]"}));
    }

}
