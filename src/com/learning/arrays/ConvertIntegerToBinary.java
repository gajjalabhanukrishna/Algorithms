package com.learning.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConvertIntegerToBinary {

    public static String toBinary(int number){

        String binary = "";

        while(number > 0){
            binary += String.valueOf(number % 2);
            number = number/2;
        }

        return binary;

    }
    public static void main(String[] args) {

        List sor = Arrays.asList(ConvertIntegerToBinary.toBinary(10).toCharArray());

        Collections.reverse(sor);
        System.out.println(sor);
    }
}
