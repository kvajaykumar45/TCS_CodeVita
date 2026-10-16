/*
​ CONSECUTIVE PRIME SUM

Some prime numbers can be expressed as a sum of other consecutive prime numbers.

For Example
    • 5=2+3, 
    • 17=2+3+5+7, 
    • 41=2+3+5+7+11+13. 

Your task is to find out how many prime numbers which satisfy this property are present in the range 3 to N subject to a constraint that summation should always start with number 2.

Write code to find out the number of prime numbers that satisfy the above-mentioned property in a given range.
​
 Input Format
    • The first line of input will contain a single integer N 
​
 Output Format
Print the total number of all such prime numbers which are less than or equal to N.
​
 Constraints
    • 2<N≤10^5 

Input
20

Output
2

​ Explanation:
Below 20 are two such cases 5 and 17
    • 5=2+3 
    • 17=2+3+5+7 
​*/ 

//Solution
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2; i*i <= n; i++)
        {
            if(isPrime[i])
            {
                for(int j=2*i; j<=n; j = j+i)
                {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        int sum = 2;
        for(int i=3; i<=n; i++)
        {
            if(isPrime[i])
            {
                if((sum+i) > n)
                    break;
                sum = sum+i;
                if(isPrime[sum])
                    count++;
            }
        }
        System.out.println(count);
	}
}
​/*
Summary
Step					Time Complexity		Operations for N=10^5
Array Initialization (Arrays.fill)	O(N)				approx 10^5
Sieve of Eratosthenes			O(N log log N)			approx 2.5 times 10^5
Consecutive Sum Counting		O(sqrtN  / ln N)		< 300
Total Time				O(N loglog N)			Easily runs in under 0.05 seconds
Total Space				O(N)			approx 100 KB for the boolean[] array
*/


