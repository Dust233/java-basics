package com.example.javabasics;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        // int[][] accounts = {{1,9},{1,2},{1,2,3}};
        // System.out.println(maximumWealth(accounts));
        System.out.println(int.class);
        System.out.println(Integer.class);
        // System.out.println(fizzBuzz(10));
        // bulu();

        // MyThread thread = new MyThread();
        // thread.run();

        String[] split = "1,2，3,4,5".split("[,，]");
        for (String s : split) {
            System.out.println(s);
        }

    }


    /**
     * 继承Thread类
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("This is child thread");
        }
    }




    public static void bulu() {
        int [] arr = {1,4,7,9,3,5};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int a : arr) {
            System.out.println(a);
        }
    }

    public static int maximumWealth(int[][] accounts) {
        // int maxWealth = Integer.MIN_VALUE;
        // for (int[] account : accounts) {
        //     maxWealth = Math.max(maxWealth, Arrays.stream(account).sum());
        // }
        // return maxWealth;
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                 temp += accounts[i][j];
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static List<String> fizzBuzz(int n) {
        List<String> results = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0){
                results.add("FizzBuzz");
            } else if (i % 3 == 0) {
                results.add("Fizz");
            } else if (i % 5 == 0) {
                results.add("Buzz");
            } else {
                results.add(Integer.toString(i));
            }
        }
        return results;
    }

    // public ListNode middleNode(ListNode head) {
    //
    // }
  // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}