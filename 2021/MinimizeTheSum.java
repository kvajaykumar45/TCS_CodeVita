/*

MINIMIZE THE SUM

Given an array of integers, perform atmost K operations so that the sum of elements of final array is minimum.

An operation is defined as follows-
    • Consider any 1 element from the array, arr[i].
    • Replace arr[i] by floor(arr[i]/2).
    • Perform next operations on the updated array.

The task is to minimize the sum after utmost K operations.

Input Format
    • First line contains two integers N and K representing size of array and maximum numbers of operations that can be performed on the array respectively.
    • Second line contains N space separated integers denoting the elements of the array, arr.

Output Format
Print a single integer denoting the minimum sum of the final array.

Constraints
    • 1 ≤ N,K ≤ 10^5 

Input
4 3
20 7 5 4

Output
17
*/

//Array Solution
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        for(int i=1; i<=k; i++)
        {
            int value = arr[n-1];
            sum = sum - value;
            value = value/2;
            sum = sum + value;
            int p = n-2;
            while(p>=0 && value < arr[p])
            {
                arr[p+1] = arr[p]; 
                p--;
            }
            arr[p+1] = value;
        }
        System.out.println(sum);
    }
}

//Max Heap Solution
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder()); 
        long sum = 0;
        for (int i = 0; i < n; i++)
        {
            int v = sc.nextInt();
            maxheap.add(v);
            sum += v;
        }
        
        for(int i=1; i<=k; i++)
        {
            int value = maxheap.poll();
            sum = sum - value;
            value = value/2;
            sum = sum + value;
            maxheap.add(value);
            
        }
        System.out.println(sum);
    }
}

/*
Approach					Time 
Sorted Array (Linear Shift)			O(K * N)
Binary Max-Heap (PriorityQueue)		O(K * log N)
*/



