package com.able;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ArrayStackTest {
    public static void main(String[] argsl) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);

        arrayStack.pop();
        System.out.println(arrayStack);
    }
}



//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left < right) {
//            int sum = nums[left] + nums[right];
//            if (sum < target) {
//                left++;
//            } else if (sum > target) {
//                right--;
//            } else {
//                return new int[] {left, right};
//            }
//        }
//        return new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            int num1 = nums[i];
//            for (int k = (i + 1); k < nums.length; k++) {
//                int num2 = nums[k];
//                if (num1 + num2 == target) {
//                    return new int[]{i, k};
//                }
//            }
//        }
//        return null;
//    }
//
//
//}
//有效括号
//class Solution {
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//            if (c=='[' || c=='(' || c=='{') {
//                stack.push(c);
//            } else {
//                if (stack.isEmpty()) {
//                    return false;
//                }
//                Character pop = stack.pop();
//                if (pop=='('&&c!=')') {
//                    return false;
//                }
//                if (pop=='['&&c!=']') {
//                    return false;
//                }
//                if (pop=='{'&&c!='}') {
//                    return false;
//                }
//            }
//        }
//       return stack.isEmpty();
//
//    }
//}
