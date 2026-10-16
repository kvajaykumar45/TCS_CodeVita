/*

COUNTING ROCK SAMPLES

Juan Marquinho is a geologist and he needs to count rock samples in order to send it to a chemical laboratory. He has a problem: The laboratory only accepts rock samples by a range of its size in ppm (parts per million).

Juan Marquinho receives the rock samples one by one and he classifies the rock samples according to the range of the laboratory. This process is very hard because the number of rock samples may be in millions.

Juan Marquinho needs your help, your task is to develop a program to get the number of rocks in each of the ranges(Inclusive) accepted by the laboratory.

Input Format
    • First line contains an positive integer S (the number of rock samples) separated by a blank space, and a positive integer R (the number of ranges of the laboratory) 
    • Second line contains a list of the sizes of S samples (in ppm), as positive integers separated by space 
    • Next R lines where the ith line containing two positive integers, space separated, indicating the minimum size and maximum size respectively of the ith range. 

Output Format
R lines where the ith line contains a single non-negative integer indicating the number of the samples which lie in the ith range.

Constraints
    • 10 ≤ S ≤ 10^4 
    • 1 ≤ R ≤ 10^5 
    • 1 ≤ Si ≤ 10^3 

Input
20 3
921 107 270 631 926 543 589 520 595 93 873 424 759 537 458 614 725 842 575 195
1 100
50 600
1 1000

Output
1 12 20
*/

//Solution

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int r = sc.nextInt();
        int rocksizes[] = new int[1001];

        for (int i = 0; i < s; i++)
        {
            int x = sc.nextInt();
            rocksizes[x]++;
        }
        int prefix[] = new int[1001];
        prefix[0] = rocksizes[0];

        for (int i = 1; i <= 1000; i++)
        {
            prefix[i] = prefix[i - 1] + rocksizes[i];
        }

        for (int i = 1; i <= r; i++)
        {
            int low = sc.nextInt();
            int high = sc.nextInt();
            if (high < low)
                System.out.println(0);
            else
            {
                System.out.println(prefix[high] - prefix[low - 1]);
            }
        }
    }
}

/*
The overall time complexity of this code is O(S + R + M)

S = Number of rock samples (S <= 10^4)
R = Number of range queries (R <= 10^5)
M = Maximum possible rock size (M <= 10^3)
*/

