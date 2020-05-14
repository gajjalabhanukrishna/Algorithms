package com.learning.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        List<String> operands = Arrays.asList("+","*","/","-");

        Stack<String> stack = new Stack();

        for(int i = 0; i< tokens.length; i++){
            if(operands.contains(tokens[i])){

                Integer s1 = Integer.valueOf(stack.pop());
                Integer s2 = Integer.valueOf(stack.pop());

                switch (tokens[i]){
                    case "+" :
                        stack.push(String.valueOf(s2 + s1));
                        break;
                    case "-" :
                        stack.push(String.valueOf(s2 - s1));
                        break;
                    case "*" :
                        stack.push(String.valueOf(s2 * s1));
                        break;
                    case "/" :
                        stack.push(String.valueOf(s2 / s1));
                        break;
                }
            }else{
                stack.push(tokens[i]);
            }
        }
    return Integer.valueOf(stack.pop());
    }


    public static void main(String[] args) {
        String input[] = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(input));
    }
}
